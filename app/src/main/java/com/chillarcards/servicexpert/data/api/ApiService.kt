package com.chillarcards.servicexpert.data.api

import com.chillarcards.servicexpert.data.model.OTPModel
import com.chillarcards.servicexpert.data.model.OTPRequestModel
import com.chillarcards.servicexpert.data.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @Author: Sherin Jaison
 * @Date: 02-11-2023$
 * Chillar
 */

interface ApiService {

    @POST("C_otp")
    suspend fun sendOTP(
        @Body reqModel: OTPRequestModel
    ): Response<OTPModel>

}