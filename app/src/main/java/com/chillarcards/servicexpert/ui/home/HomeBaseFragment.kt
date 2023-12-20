package com.chillarcards.servicexpert.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.chillarcards.servicexpert.R
import com.chillarcards.servicexpert.databinding.FragmentHomeBaseBinding

class HomeBaseFragment : Fragment() {

    lateinit var binding: FragmentHomeBaseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_base, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = childFragmentManager
            .findFragmentById(R.id.inner_host_nav) as NavHostFragment
        val navController = navHostFragment.navController


//        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        bottomNavigationView.menu.findItem(R.id.empty).isChecked = true;
//        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.staff -> {
//                    true
//                }
//                R.id.report -> {
//                    true
//                }
//                R.id.service -> {
//                    true
//                }
//                R.id.settings -> {
//                    true
//                }
//                else -> false
//            }
//        }

        binding.addStaff.setOnClickListener {
            navController.navigate(R.id.StaffFragment)
        }

        binding.addService.setOnClickListener {
            navController.navigate(R.id.BookingFragment)
        }
        binding.walkBook.setOnClickListener {
            navController.navigate(R.id.walk_book_Fragment)
        }
        binding.report.setOnClickListener {
            navController.navigate(R.id.reportFragment)
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.BookingFragment, R.id.StaffBookFragment, R.id.estimateFragment,
                R.id.successFragment, R.id.addStaffFragment , R.id.walk_book_Fragment ,
                R.id.StaffFragment, R.id.reportFragment -> {
                    binding.bottomMenu.visibility = View.GONE
                }
                else -> {
                    binding.bottomMenu.visibility = View.VISIBLE
                }
            }
        }
     }
}