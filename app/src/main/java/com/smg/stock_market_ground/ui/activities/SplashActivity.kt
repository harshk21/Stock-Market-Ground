package com.smg.stock_market_ground.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smg.stock_market_ground.databinding.ActivitySplashBinding
import com.smg.stock_market_ground.utils.Constants
import com.smg.stock_market_ground.utils.startActivity
import java.util.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var bindingSplash: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSplash = ActivitySplashBinding.inflate(layoutInflater)
        bindingSplash.root.apply {
            setContentView(this)
        }
        splashTime()
    }

    private fun splashTime() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity<AuthActivity>()
                finishAffinity()
            }
        }, Constants.SPLASH_TIME)
    }
}