package com.chillarcards.servicexpert

import android.content.Intent
import android.content.IntentFilter
import android.content.IntentSender
import android.content.pm.ActivityInfo
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import com.chillarcards.servicexpert.databinding.ActivityMainBinding
import com.chillarcards.servicexpert.utills.ConnectivityReceiver
import com.chillarcards.servicexpert.utills.PrefManager
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability


class MainActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefManager: PrefManager

    private val  MY_REQUEST_CODE = 5

    companion object {
        var justLoggedIn = false
        fun setLoggedInValue(isJustLoggedIn: Boolean) {
            justLoggedIn = isJustLoggedIn
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
     //   WindowCompat.setDecorFitsSystemWindows(window, false)
        // Set the activity to be fullscreen.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        getUpdate() //Check new version is released for not
        installSplashScreen()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            hideStatusBar();
        }
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        prefManager = PrefManager(this)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val graphInflater = navHostFragment.navController.navInflater
        val navGraph = graphInflater.inflate(R.navigation.nav_graph)
        val navController = navHostFragment.navController
        justLoggedIn = false

        val destination =
            if (prefManager.isLoggedIn()) R.id.homeBaseFragment else R.id.mobileFragment
        navGraph.setStartDestination(destination)
        navController.graph = navGraph

        registerReceiver(
            ConnectivityReceiver(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )


        //FIREBASE CRASH

//        val crashButton = Button(this)
//        crashButton.text = "Test Crash"
//        crashButton.setOnClickListener {
//            throw RuntimeException("Test Crash") // Force a crash
//        }
//        addContentView(crashButton, ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT))
    }


    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (!isConnected) {
            val intent = Intent(this, NetworkErrorActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this

        // TODO: check the time taken to execute the following and in case it is taking too long, run it in a separate thread
        if (!isFinishing) {
            if (justLoggedIn) {
                val intent = Intent(this@MainActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }

        getUpdate()

    }


    private fun getUpdate(){
        val appUpdateManager = AppUpdateManagerFactory.create(this)

        // Check if an update is available
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                //  && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                // An update is available and it's a flexible update

                // Start the update flow
                try {
                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        //'AppUpdateType.IMMEDIATE' for immediate updates Or 'AppUpdateType.FLEXIBLE' for flexible updates.
                        // AppUpdateType.IMMEDIATE,
                        AppUpdateType.FLEXIBLE,
                        this,
                        MY_REQUEST_CODE)
                } catch (e: IntentSender.SendIntentException) {
                    e.printStackTrace()
                }
            }
        }

        // Create a listener to track request state updates.
        val listener = InstallStateUpdatedListener { state ->
            // (Optional) Provide a download progress bar.
            if (state.installStatus() == InstallStatus.DOWNLOADING) {
                val bytesDownloaded = state.bytesDownloaded()
                val totalBytesToDownload = state.totalBytesToDownload()
                // Show update progress bar.
            }
            // Log state or install the update.
        }

        // Listen for download progress updates
        appUpdateManager.registerListener { state ->
            when (state.installStatus()) {
                InstallStatus.DOWNLOADED -> {
                    // An update was downloaded
                    // Notify the user and prompt them to install the update
                    // Displays the snackbar notification and call to action.
                    Snackbar.make(
                        findViewById(R.id.heading),
                        "An update has just been downloaded.",
                        Snackbar.LENGTH_INDEFINITE
                    ).apply {
                        setAction("RESTART") { appUpdateManager.completeUpdate() }
                        setActionTextColor(resources.getColor(R.color.black))
                        show()
                    }
                }
                InstallStatus.INSTALLING -> {
                    // The update is being installed
                    // You can show a progress bar or other UI
                }
                InstallStatus.INSTALLED -> {
                    // The update was installed successfully
                    // You can restart the app or take other actions
                }
                InstallStatus.FAILED -> {
                    // The update failed to install
                    // You can retry the update or fallback to another flow
                }
                else -> {}
            }
        }

// Unregister the listener when it's no longer needed
        appUpdateManager.unregisterListener(listener)

    }

    // Handle the update flow result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode != RESULT_OK) {
                Log.e("MY_APP", "Update flow failed! Result code: $resultCode")
                // The update failed or was canceled
                // You can retry the update or fallback to another flow
            }
        }
    }

    private fun hideStatusBar() {
        val decorView = window.decorView

        // Hide the status bar.
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions

        // Set the activity to be fullscreen.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

}