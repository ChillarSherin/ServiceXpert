package com.chillarcards.servicexpert.ui.booking

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chillarcards.servicexpert.R
import com.chillarcards.servicexpert.databinding.FragmentSuccessBinding
import com.chillarcards.servicexpert.utills.Const


class SuccessFragment : Fragment(){

    lateinit var binding: FragmentSuccessBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuccessBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pInfo =
            activity?.let { activity?.packageManager!!.getPackageInfo(it.packageName, PackageManager.GET_ACTIVITIES) }

        binding.paybill.setAnimation(R.raw.ic_success)
        Const.enableButton(binding.bchHomeBtn)

        binding.bchHomeBtn.setOnClickListener {
            findNavController().navigate(
                SuccessFragmentDirections.actionSuccessFragmentToHomeFragment()
            )
        }
    }


    override fun onStop() {
        super.onStop()
        Log.d("abc_mob", "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("abc_mob", "onDestroy: ")
    }

}
