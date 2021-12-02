package com.smg.stock_market_ground.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.smg.stock_market_ground.R

/**
 * Base activity with some common functions
 *
 **/

open class BaseActivity : AppCompatActivity() {

    fun navigateFirstTabWithClearStack(id: Int, navId: Int) {
        val navController = findNavController(navId)
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(navId) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_dashboard)
        graph.startDestination = id
        navController.graph = graph
    }

    fun switchRoute(id: Int, navId: Int) {
        val navController = findNavController(navId)
        navController.navigate(id)
    }

    fun switchRoute(id: Int, navId: Int, bundle: Bundle) {
        val navController = findNavController(navId)
        navController.navigate(id, bundle)
    }


}