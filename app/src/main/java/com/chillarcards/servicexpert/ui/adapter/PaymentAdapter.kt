package com.chillarcards.servicexpert.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.chillarcards.servicexpert.R
import com.chillarcards.servicexpert.utills.CommonDBaseModel
import com.chillarcards.servicexpert.ui.Dummy
import com.chillarcards.servicexpert.ui.interfaces.IAdapterViewUtills

class PaymentAdapter(private val items: List<Dummy>,
                     context: Context?,
                     private val getAdapterUtil: IAdapterViewUtills)
    : RecyclerView.Adapter<PaymentAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.payment_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        holder.BookingView.setOnClickListener {
            val commonDObj = CommonDBaseModel()
            commonDObj.mastIDs = item.id.toString()
            commonDObj.itmName = item.name
            commonDObj.valueStr1 = item.custname
            val sCommonDAry: ArrayList<CommonDBaseModel> = ArrayList()
            sCommonDAry.add(commonDObj)
            getAdapterUtil.getAdapterPosition(position, sCommonDAry, "VIEW")
        }
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val BookingView: CardView = itemView.findViewById(R.id.book_frm)
        val CustomNameTextView: TextView = itemView.findViewById(R.id.tran_cust_name)

        fun bind(item: Dummy) {
            CustomNameTextView.text = item.custname
//            itemView.idTextView.text = "ID: ${item.id}"
//            itemView.imageView.setImageResource(item.imageResId)
        }

    }

    fun getFirstLetterAfterSpace(inputText: String): String {
        val words = inputText.split(" ")
        val result = StringBuilder()

        for (word in words) {
            if (word.isNotEmpty()) {
                val firstChar = word[0]
                result.append(firstChar)
            }
        }

        return result.toString()
    }

}
