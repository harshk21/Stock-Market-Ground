package com.smg.stock_market_ground

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

    }

    companion object {
        val Context.context: MyApplication
            get() = applicationContext as MyApplication

        lateinit var instance: MyApplication
            private set
    }

}