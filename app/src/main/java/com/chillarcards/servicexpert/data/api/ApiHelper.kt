package com.chillarcards.servicexpert.data.api

import com.chillarcards.servicexpert.data.model.OTPModel
import com.chillarcards.servicexpert.data.model.*
import retrofit2.Response

/**
 * @Author: Sherin Jaison
 * @Date: 01-11-2023
 * Chillar
 */
interface ApiHelper {

    suspend fun sendOTP(
        mobileNumber: String,
        userID: String,
        token: String
    ): Response<OTPModel>

    suspend fun verifyOTP(
        mobileNumber: String,
        otp: String,
        userID: String,
        token: String
    ): Response<OTPModel>

}