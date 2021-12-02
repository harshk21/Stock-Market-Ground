package com.smg.stock_market_ground.ui.fragments.dashboardFragments.portfolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smg.stock_market_ground.R
import com.smg.stock_market_ground.databinding.FragmentPortfolioBinding

class PortfolioFragment : Fragment() {

    private lateinit var portfolioBinding: FragmentPortfolioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        portfolioBinding = FragmentPortfolioBinding.inflate(inflater, container, false)
        return portfolioBinding.root
    }

}