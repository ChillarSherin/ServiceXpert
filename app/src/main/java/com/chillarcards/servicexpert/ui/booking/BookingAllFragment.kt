package com.chillarcards.servicexpert.ui.booking

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chillarcards.servicexpert.R
import com.chillarcards.servicexpert.databinding.FragmentViewAllBinding
import com.chillarcards.servicexpert.ui.Dummy
import com.chillarcards.servicexpert.ui.adapter.BookingAdapter
import com.chillarcards.servicexpert.ui.interfaces.IAdapterViewUtills
import com.chillarcards.servicexpert.utills.CommonDBaseModel
import com.google.android.material.bottomsheet.BottomSheetDialog


class BookingAllFragment : Fragment(), IAdapterViewUtills {

    lateinit var binding: FragmentViewAllBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewAllBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pInfo =
            activity?.let { activity?.packageManager!!.getPackageInfo(it.packageName, PackageManager.GET_ACTIVITIES) }

        setToolbar()
        binding.headTran.text = getString(R.string.book_head)

        val transItem = listOf(
            Dummy("8.00 am \n 8.15 am", 5, "customer name a "),
            Dummy("9.00 am \n 9.15 am", 2, "customer name b "),
            Dummy("10.00 am \n 12.15 am", 8, "customer name c "),
            Dummy("10.00 am \n 12.15 am", 8, "customer name d "),
            Dummy("10.00 am \n 12.15 am", 8, "customer name e "),
            Dummy("10.00 am \n 12.15 am", 8, "customer name f "),
            Dummy("11.00 am \n 11.15 am", 3, "customer name g "),
            Dummy("11.00 am \n 11.15 am", 3, "customer name h "),
            Dummy("11.00 am \n 11.15 am", 3, "customer name i "),
            Dummy("11.00 am \n 11.15 am", 3, "customer name j "),
            Dummy("12.00 am \n 13.15 am", 3, "customer name k "),
            Dummy("20.00 am \n 21.15 am", 3, "customer name l ")
        )

        val BookingAdapter = BookingAdapter(
            transItem, context,this@BookingAllFragment)

        binding.tranRv.adapter = BookingAdapter
        binding.tranRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    private fun setToolbar() {
        binding.toolbar.toolbarTitle.text = getString(R.string.booking_head)
        binding.toolbar.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setBottomSheet(selectedData: ArrayList<CommonDBaseModel>) {
//        val bottomSheetFragment = BottomSheetFragment(selectedData)
//        bottomSheetFragment.show((context as AppCompatActivity).supportFragmentManager, bottomSheetFragment.tag)

        val bottomSheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_persistent, null)
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)

        val customerTV: TextView = bottomSheetView.findViewById(R.id.customerNameTextView)
        customerTV.text = selectedData[0].valueStr1

        val closeButton: ImageView = bottomSheetView.findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            bottomSheetDialog.dismiss()
        }

        val completeButton: TextView = bottomSheetView.findViewById(R.id.completedButton)
        completeButton.setOnClickListener {
            findNavController().navigate(
                BookingAllFragmentDirections.actionBookingFragmentToEstimateFragment(
                )
            )
            bottomSheetDialog.dismiss()
        }

        val callButton: TextView = bottomSheetView.findViewById(R.id.callButton)
        callButton.setOnClickListener {
            val phoneNumber = "tel:" + selectedData[0].mastIDs
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse(phoneNumber)
            if (dialIntent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(dialIntent)
            }
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()

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
            setBottomSheet(ValueArray)
        }
    }

}
