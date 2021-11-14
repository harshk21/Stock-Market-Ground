package com.smg.stock_market_ground.ui.fragments.dashboardFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smg.stock_market_ground.databinding.FragmentHomeBinding
import com.softradix.financial_calculator.base.BaseFragment

class HomeFragment : BaseFragment() {

    private lateinit var homeBinding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

}