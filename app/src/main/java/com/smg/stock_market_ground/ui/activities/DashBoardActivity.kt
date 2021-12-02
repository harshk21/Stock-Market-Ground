package com.smg.stock_market_ground.ui.activities

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.smg.stock_market_ground.R
import com.smg.stock_market_ground.base.BaseActivity
import com.smg.stock_market_ground.databinding.ActivityDashBoardBinding

class DashBoardActivity : BaseActivity() {

    private lateinit var dashBoardBinding: ActivityDashBoardBinding
    private lateinit var navCon: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashBoardBinding = ActivityDashBoardBinding.inflate(layoutInflater)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_dashboard_navigation) as NavHostFragment
        navCon = navHostFragment.navController
        dashBoardBinding.bottomNavigationView.setupWithNavController(navCon)
        dashBoardBinding.root.apply {
            setContentView(this)
        }
    }
}