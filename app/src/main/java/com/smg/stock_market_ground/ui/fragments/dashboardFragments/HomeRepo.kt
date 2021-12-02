package com.smg.stock_market_ground.ui.fragments.dashboardFragments

import com.smg.stock_market_ground.network.ApiRequests
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object HomeRepo {
    private val apiService = ApiRequests.createService()

    fun logoutUser(
        success: (ResponseBody) -> Unit,
        failure: (Throwable) ->Unit,
        token: String
    ) {
        apiService.userLogout(token).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                response.body()?.let { success(it) }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                failure(t)
            }

        })
    }

}