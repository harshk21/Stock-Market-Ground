package com.smg.stock_market_ground.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smg.stock_market_ground.databinding.ActivityAuthBinding
import com.softradix.financial_calculator.base.BaseActivity

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