package com.chillarcards.servicexpert.ui.register


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chillarcards.servicexpert.R
import com.chillarcards.servicexpert.databinding.FragmentBankBinding
import com.chillarcards.servicexpert.databinding.FragmentWorkHoursBinding
import com.chillarcards.servicexpert.utills.Const
import com.chillarcards.servicexpert.utills.PrefManager


class WorkHoursFragment : Fragment() {

    lateinit var binding: FragmentWorkHoursBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // in here you can do logic when backPress is clicked
                alertMsg(requireContext())
            }
        })
    }
    fun alertMsg(context: Context) {
        try {
            PrefManager(context)
            val builder = AlertDialog.Builder(context)
            // Create the AlertDialog

            //set title for alert dialog
            builder.setTitle(R.string.alert_heading)
            //set message for alert dialog
            builder.setMessage(R.string.pop_alert_message)
            builder.setIcon(R.mipmap.ic_launcher)
            builder.setCancelable(false)

            //performing positive action
            builder.setPositiveButton(context.getString(R.string.ok)) { _, _ ->
                findNavController().popBackStack()
            }
            builder.setNegativeButton(context.getString(R.string.cancel)) { _, _ ->
//                alertDialog.dismiss()
            }
            val alertDialog: AlertDialog = builder.create()

            alertDialog.setCanceledOnTouchOutside(false)
            alertDialog.show()
        } catch (e: Exception) {
            //e.printstackTrace()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_work_hours, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Const.enableButton(binding.confirmBtn)

        binding.confirmBtn.setOnClickListener {

            context?.let { it1 -> PrefManager(it1).setIsLoggedIn(true) }

            findNavController().navigate(
                WorkHoursFragmentDirections.actionTimeFragmentToHomeFragment()
            )
        }
    }
    
}
