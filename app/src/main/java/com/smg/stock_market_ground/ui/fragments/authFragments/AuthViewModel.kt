package com.smg.stock_market_ground.ui.fragments.authFragments

import androidx.lifecycle.MutableLiveData
import com.smg.stock_market_ground.base.BaseViewModel
import com.smg.stock_market_ground.model.UsersModel


class AuthViewModel : BaseViewModel() {

    val logInResponse = MutableLiveData<UsersModel>()
    val signUpResponse = MutableLiveData<UsersModel>()
    val passwordResetResponse = MutableLiveData<Boolean>()

    fun logIn(map: HashMap<String, String>) {
        isLoading.value = true
        AuthRequestRepo.loginUser(
            success = {
                isLoading.value = false
                logInResponse.value = it
            }, {
                isLoading.value = false
                apiErrorResponse.value = it.message
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
            apiErrorResponse.value = it.message
        }, map)
    }

    fun passwordReset(email: String) {
        isLoading.value = true
        AuthRequestRepo.passwordReset({
            isLoading.value = false
            passwordResetResponse.value = true
        }, failure = {
            isLoading.value = false
            passwordResetResponse.value = false
        }, email)
    }


}