package com.smg.stock_market_ground.ui.activities

import android.os.Bundle
import com.smg.stock_market_ground.databinding.ActivityAuthBinding
import com.smg.stock_market_ground.base.BaseActivity

class AuthActivity : BaseActivity() {

    private lateinit var authBinding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authBinding = ActivityAuthBinding.inflate(layoutInflater)
        authBinding.root.apply {
            setContentView(this)
        }
    }
}