package com.smg.stock_market_ground.ui.fragments.authFragments

import androidx.lifecycle.MutableLiveData
import com.smg.stock_market_ground.base.BaseViewModel
import com.smg.stock_market_ground.model.UsersModel


class AuthViewModel : BaseViewModel() {

    val logInResponse = MutableLiveData<UsersModel>()
    val signUpResponse = MutableLiveData<UsersModel>()

    fun logIn(map: HashMap<String, String>) {
        isLoading.value = true
        AuthRequestRepo.loginUser(
            success = {
                isLoading.value = false
                logInResponse.value = it
            }, {
                isLoading.value = false
                apiErrorResponse.value = it.localizedMessage
            }, map
        )
    }

    fun signUp(map: HashMap<String, String>) {
        isLoading.value = true
        AuthRequestRepo.registerUser({
            isLoading.value = false
            signUpResponse.value = it
        }, {
            isLoading.value = false
            apiErrorResponse.value = it.localizedMessage
        }, map)
    }


}