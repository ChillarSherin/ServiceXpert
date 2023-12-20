package com.chillarcards.servicexpert

import android.app.Application
import com.chillarcards.servicexpert.di.module.appModule
import com.chillarcards.servicexpert.di.module.repoModule
import com.chillarcards.servicexpert.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * @Author: Sherin Jaison
 * @Date: 01-11-2023$
 * Chillar
 * for kotlin koin di
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }

        // Generate Hash Key >>>>> GOOGLE SMS
        //  val appSignatureHashHelper = AppSignatureHashHelper(this)
        //  Log.e(TAG, "HashKey: " + appSignatureHashHelper.appSignatures[0])
        //  Last uploaded VrgIsm6rcVw
    }


}