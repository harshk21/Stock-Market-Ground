package com.smg.stock_market_ground.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Base view-model for handling states
 **/

open class BaseViewModel : ViewModel() {

    var isLoading = MutableLiveData<Boolean>()
    val apiErrorResponse = MutableLiveData<String>()

}