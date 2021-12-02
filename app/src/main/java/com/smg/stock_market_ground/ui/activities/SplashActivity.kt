package com.smg.stock_market_ground.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import com.smg.stock_market_ground.databinding.ActivitySplashBinding
import com.smg.stock_market_ground.utils.Constants
import com.smg.stock_market_ground.utils.SharedPrefs
import com.smg.stock_market_ground.utils.SharedPrefs.Companion.getBoolean
import com.smg.stock_market_ground.utils.startActivity
import com.smg.stock_market_ground.base.BaseActivity
import java.util.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private lateinit var bindingSplash: ActivitySplashBinding

    lateinit var sharedPrefs: SharedPrefs

    companion object {
        var mComeFromWelcome: Boolean? = false
        var mCheckForLogIn: Boolean? = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSplash = ActivitySplashBinding.inflate(layoutInflater)
        sharedPrefs = SharedPrefs.init(this)
        bindingSplash.root.apply {
            setContentView(this)
        }
        mComeFromWelcome = getBoolean(Constants.WELCOME_CHECK)
        mCheckForLogIn = getBoolean(Constants.USER_CHECK)
        if(mCheckForLogIn == true){
            startActivity<DashBoardActivity>()
            finishAffinity()
        }else{
            splashTime()
        }
    }

    private fun splashTime() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity<AuthActivity>()
                finishAffinity()
            }
        }, Constants.SPLASH_TIME)
    }
    override fun onDestroy() {
        super.onDestroy()
        mComeFromWelcome = false
        mCheckForLogIn = false
    }
}