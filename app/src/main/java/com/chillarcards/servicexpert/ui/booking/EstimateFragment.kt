package com.chillarcards.servicexpert.ui.booking

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chillarcards.servicexpert.R
import com.chillarcards.servicexpert.databinding.FragmentEstimateBinding
import com.chillarcards.servicexpert.ui.DummyStaff
import com.chillarcards.servicexpert.ui.adapter.EstimateAdapter
import com.chillarcards.servicexpert.ui.interfaces.IAdapterViewUtills
import com.chillarcards.servicexpert.utills.BottomSheetFragment
import com.chillarcards.servicexpert.utills.CommonDBaseModel


class EstimateFragment : Fragment(), IAdapterViewUtills {

    lateinit var binding: FragmentEstimateBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEstimateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pInfo =
            activity?.let { activity?.packageManager!!.getPackageInfo(it.packageName, PackageManager.GET_ACTIVITIES) }

        setToolbar()
        binding.headTran.text = getString(R.string.est_qr)

        val transItem = listOf(
            DummyStaff(1, "Hair Cut", "₹ 800"),
            DummyStaff(2, "Full Hair Pack", "₹ 800"),
            DummyStaff(3, "Nail Art", "₹ 800"),
            DummyStaff(4, "Hair Color", "₹ 800")
        )

        val adapter = EstimateAdapter(transItem)
        binding.estimateRv.adapter = adapter
        binding.estimateRv.layoutManager = LinearLayoutManager(context)

        binding.printBillBtn.setOnClickListener {
            findNavController().navigate(
                EstimateFragmentDirections.actionEstimateFragmentToSuccessFragment(
                )
            )
        }
    }

    private fun setToolbar() {
        binding.toolbar.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setBottomSheet(selectedData: ArrayList<CommonDBaseModel>) {
//        binding.bottomView.visibility= View.VISIBLE
//        val bottomSheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_persistent, null)
//        val bottomSheetDialog = BottomSheetDialog(requireContext())
//        bottomSheetDialog.setContentView(bottomSheetView)
//        bottomSheetDialog.show()

        val bottomSheetFragment = BottomSheetFragment(selectedData)
        bottomSheetFragment.show((context as AppCompatActivity).supportFragmentManager, bottomSheetFragment.tag)


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

    fun createLinear(){

//        for (item in transItem) {
//            val newLinearLayout = LinearLayout(context)
//            newLinearLayout.layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            )
//            newLinearLayout.orientation = LinearLayout.HORIZONTAL
//            newLinearLayout.weightSum = 2f
//
//            val slnoTextView = TextView(context)
//            slnoTextView.layoutParams = LinearLayout.LayoutParams(
//                0,
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                0.4f
//            )
//            slnoTextView.text = item.id.toString()
//            slnoTextView.gravity = Gravity.CENTER
//            slnoTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_black))
//            slnoTextView.setTypeface(null, Typeface.BOLD)
//
//            val serviceNameTextView = TextView(context)
//            serviceNameTextView.layoutParams = LinearLayout.LayoutParams(
//                0,
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                1f
//            )
//            serviceNameTextView.text = item.name
//            serviceNameTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_black))
//
//            val serviceRateTextView = TextView(context)
//            serviceRateTextView.layoutParams = LinearLayout.LayoutParams(
//                0,
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                0.6f
//            )
//            serviceRateTextView.gravity = Gravity.CENTER
//            serviceRateTextView.text = item.total
//            serviceRateTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_black))
//
//            newLinearLayout.addView(slnoTextView)
//            newLinearLayout.addView(serviceNameTextView)
//            newLinearLayout.addView(serviceRateTextView)
//
//            binding.parentLayout.addView(newLinearLayout)
//        }

    }


}
