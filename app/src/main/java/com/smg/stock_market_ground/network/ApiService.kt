package com.smg.stock_market_ground.network

import com.smg.stock_market_ground.model.UsersModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("users/register")
    fun userRegister(@Body map: HashMap<String, String>): Call<UsersModel>

    @POST("users/login")
    fun userLogin(@Body map: HashMap<String, String>): Call<UsersModel>

    @POST("users/logout")
    fun userLogout(@Body map: HashMap<String, String>): Call<ResponseBody>

}