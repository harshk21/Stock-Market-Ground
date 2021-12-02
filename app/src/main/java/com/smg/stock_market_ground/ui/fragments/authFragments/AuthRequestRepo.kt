package com.smg.stock_market_ground.ui.fragments.authFragments

import com.smg.stock_market_ground.model.UsersModel
import com.smg.stock_market_ground.network.ApiRequests
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AuthRequestRepo {
    private val apiService = ApiRequests.createService()

    fun registerUser(
        success: (UsersModel) -> Unit,
        failure: (Throwable) -> Unit,
        map: HashMap<String, String>
    ) {
        apiService.userRegister(map).enqueue(object : Callback<UsersModel> {
            override fun onResponse(call: Call<UsersModel>, response: Response<UsersModel>) {
                response.body()?.let {
                    success(it)
                }
            }

            override fun onFailure(call: Call<UsersModel>, t: Throwable) {
                failure(t)
            }

        })
    }

    fun loginUser(
        success: (UsersModel) -> Unit,
        failure: (Throwable) -> Unit,
        map: HashMap<String, String>
    ) {
        apiService.userLogin(map).enqueue(object : Callback<UsersModel> {
            override fun onResponse(call: Call<UsersModel>, response: Response<UsersModel>) {
                response.body()?.let {
                    success(it)
                }
            }

            override fun onFailure(call: Call<UsersModel>, t: Throwable) {
                failure(t)
            }

        })

    }

    fun passwordReset(
        success: (ResponseBody) -> Unit,
        failure: (Throwable) -> Unit,
        email: String
    ) {
        apiService.passwordReset(email).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                response.body()?.let { success(it) }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                failure(t)
            }

        })
    }


}