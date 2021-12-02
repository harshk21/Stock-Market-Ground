package com.smg.stock_market_ground.network

import com.smg.stock_market_ground.model.UsersModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("users/register")
    fun userRegister(@Body map: HashMap<String, String>): Call<UsersModel>

    @POST("users/login")
    fun userLogin(@Body map: HashMap<String, String>): Call<UsersModel>

    @GET("users/logout")
    fun userLogout(@Header("user-token") token:String): Call<ResponseBody>

    @GET("users/restorepassword/{email}")
    fun passwordReset(@Path("email") email:String): Call<ResponseBody>

}