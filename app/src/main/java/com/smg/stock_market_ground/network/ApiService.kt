package com.smg.stock_market_ground.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v4/latest/{base_currency}")
    fun getConversions(@Path("base_currency") base_currency: String?): Call<ResponseBody>
}