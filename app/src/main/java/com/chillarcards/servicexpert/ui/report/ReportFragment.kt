package com.chillarcards.servicexpert.ui.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chillarcards.servicexpert.R
import com.chillarcards.servicexpert.databinding.FragmentReportBinding
import com.chillarcards.servicexpert.ui.Dummy
import com.chillarcards.servicexpert.ui.adapter.HorizontalAdapter
import com.chillarcards.servicexpert.ui.adapter.PaymentAdapter
import com.chillarcards.servicexpert.ui.adapter.StaffReportAdapter
import com.chillarcards.servicexpert.ui.adapter.TransactionAdapter
import com.chillarcards.servicexpert.ui.home.HomeFragmentDirections
import com.chillarcards.servicexpert.ui.interfaces.IAdapterViewUtills
import com.chillarcards.servicexpert.utills.CommonDBaseModel

class ReportFragment : Fragment(), IAdapterViewUtills {

    lateinit var binding: FragmentReportBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_report, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
        val dummyItem = listOf(
            Dummy("sajith", 1, "customer name a"),
            Dummy("sujith", 2, "customer name b"),
            Dummy("rony jak", 3, "customer name c"),
            Dummy("smith", 3, "customer name d"),
            Dummy("sam paul", 3, "customer name d")
        )
        val transItem = listOf(
            Dummy("8.00 am \n 8.15 am", 5, "customer name a"),
            Dummy("9.00 am \n 9.15 am", 2, "customer name b"),
            Dummy("10.00 am \n 12.15 am", 8, "customer name c"),
            Dummy("10.00 am \n 12.15 am", 8, "customer name d"),
            Dummy("10.00 am \n 12.15 am", 8, "customer name e"),
            Dummy("10.00 am \n 12.15 am", 8, "customer name f")
        )

        val salesTopPicAdapter = StaffReportAdapter(
            dummyItem, context)

        val transactionAdapter = PaymentAdapter(
            transItem, context,this@ReportFragment)

        binding.topPicRv.adapter = salesTopPicAdapter
        binding.topPicRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.tranRv.adapter = transactionAdapter
        binding.tranRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.staffAll.setOnClickListener {
            try {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToStaffBookFragment(
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        binding.bookingViewAll.setOnClickListener {
            try {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToBookingFragment(
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
     }

    private fun setToolbar() {
        binding.toolbar.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.toolbar.toolbarTitle.text = getString(R.string.sales_report)
    }

    override fun getAdapterPosition(
        Position: Int,
        ValueArray: ArrayList<CommonDBaseModel>,
        Mode: String?
    ) {
//        if(Mode.equals("VIEW")) {
//            val bottomSheetFragment = BottomSheetFragment(ValueArray)
//            bottomSheetFragment.show(
//                (context as AppCompatActivity).supportFragmentManager,
//                bottomSheetFragment.tag
//            )
//        }
    }
}