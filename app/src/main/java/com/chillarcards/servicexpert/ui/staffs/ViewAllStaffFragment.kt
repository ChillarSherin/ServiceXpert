package com.chillarcards.servicexpert.ui.staffs


import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chillarcards.servicexpert.R
import com.chillarcards.servicexpert.databinding.FragmentViewStaffsBinding
import com.chillarcards.servicexpert.ui.DummyStaff
import com.chillarcards.servicexpert.ui.adapter.AllStaffAdapter
import com.chillarcards.servicexpert.ui.adapter.StaffAdapter
import com.chillarcards.servicexpert.ui.interfaces.IAdapterViewUtills
import com.chillarcards.servicexpert.utills.CommonDBaseModel
import com.chillarcards.servicexpert.utills.Const


class ViewAllStaffFragment : Fragment(), IAdapterViewUtills {

    lateinit var binding: FragmentViewStaffsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewStaffsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pInfo =
            activity?.let { activity?.packageManager!!.getPackageInfo(it.packageName, PackageManager.GET_ACTIVITIES) }

        setToolbar()
        binding.headTran.text = getString(R.string.staff_view_msg)

        val transItem = listOf(
            DummyStaff(1,"Sajith",  "500"),
            DummyStaff(2,"Sujith",  "400"),
            DummyStaff(3,"Ram Kumar",  "100"),
            DummyStaff(4,"Shilpa",  "800"),
            DummyStaff(5,"Ramu",  "400"),
            DummyStaff(6,"John",  "100"),
            DummyStaff(7,"Amith Khan",  "220"),
            DummyStaff(8,"Damaro",  "502")
        )

        val staffAdapter = AllStaffAdapter(
            transItem, this@ViewAllStaffFragment,context)

        Const.enableButton(binding.confirmBtn)
        binding.staffRv.adapter = staffAdapter
        binding.staffRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.confirmBtn.setOnClickListener {
            findNavController().navigate(
                ViewAllStaffFragmentDirections.actionStaffFragmentToAddStaffFragment()
            )
        }
    }

    private fun setToolbar() {
        binding.toolbar.toolbarTitle.text = getString(R.string.staff_view)
        binding.toolbar.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("abc_mob", "onStop: ")
       // mobileViewModel.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("abc_mob", "onDestroy: ")
    }

    override fun getAdapterPosition(
        Position: Int,
        ValueArray: ArrayList<CommonDBaseModel>,
        Mode: String?
    ) {
        if(Mode.equals("VIEW")){
            val staffId: String = ValueArray[0].mastIDs.toString()
//
//            findNavController().navigate(
//                ViewAllStaffFragmentDirections.actionStaffFragmentToBookingFragment(staffId)
//            )
        }
    }
}
