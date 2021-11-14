package com.smg.stock_market_ground.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smg.stock_market_ground.databinding.ActivityDashBoardBinding
import com.softradix.financial_calculator.base.BaseActivity

class DashBoardActivity : BaseActivity() {

    private lateinit var dashBoardBinding: ActivityDashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashBoardBinding = ActivityDashBoardBinding.inflate(layoutInflater)
        dashBoardBinding.root.apply {
            setContentView(this)
        }
    }
}