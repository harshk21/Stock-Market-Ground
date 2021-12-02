package com.smg.stock_market_ground.ui.fragments.dashboardFragments.home

import androidx.lifecycle.MutableLiveData
import com.smg.stock_market_ground.base.BaseViewModel

class HomeViewModel : BaseViewModel() {

    val logoutResponse = MutableLiveData<Boolean>()

    fun userLogout(token: String) {
        isLoading.value = true
        HomeRepo.logoutUser(success = {
            isLoading.value = false
            logoutResponse.value = true
        }, failure = {
            isLoading.value = false
            logoutResponse.value = false
            apiErrorResponse.value = it.message
        }, token)
    }


}