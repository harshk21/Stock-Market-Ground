package com.smg.stock_market_ground.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smg.stock_market_ground.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var authBinding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authBinding = ActivityAuthBinding.inflate(layoutInflater)
        authBinding.root.apply {
            setContentView(this)
        }
    }
}