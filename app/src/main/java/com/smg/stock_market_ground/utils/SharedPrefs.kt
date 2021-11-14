package com.smg.stock_market_ground.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPrefs(context: Context) {
    companion object {

        private lateinit var sharedPreferences: SharedPreferences
        var sharedPref: SharedPrefs? = null

        fun init(context: Context): SharedPrefs {
            if (sharedPref == null) {
                sharedPref = SharedPrefs(context)
                sharedPreferences =
                    context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
            }
            return sharedPref as SharedPrefs
        }

        fun setBoolean(isLog: Boolean, isWel: Boolean) {
            sharedPreferences.edit().putBoolean(Constants.WELCOME_CHECK, isWel).apply()
            sharedPreferences.edit().putBoolean(Constants.USER_CHECK, isLog).apply()
        }
        fun setBoolean(isDiscover: Boolean, isSaved: Boolean, int: Int) {
            sharedPreferences.edit().putBoolean(Constants.IS_DISCOVER, isDiscover).apply()
            sharedPreferences.edit().putBoolean(Constants.IS_SAVED, isSaved).apply()
        }



        fun setString(type: String,data:String) {
            sharedPreferences.edit().putString(type, data).apply()
        }

        fun getStringFromSharedPrefs(key: String): String {
            return sharedPreferences.getString(key, "").toString()
        }

        fun getBoolean(key: String): Boolean {
            return sharedPreferences.getBoolean(key, false)
        }

        fun clearData() {
            sharedPreferences.edit().clear().apply()
        }
    }
}