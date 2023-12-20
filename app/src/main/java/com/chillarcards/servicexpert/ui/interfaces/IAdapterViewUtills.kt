package com.chillarcards.servicexpert.ui.interfaces

import com.chillarcards.servicexpert.utills.CommonDBaseModel

interface IAdapterViewUtills {

    fun getAdapterPosition(Position: Int, ValueArray: ArrayList<CommonDBaseModel>, Mode: String?)
}