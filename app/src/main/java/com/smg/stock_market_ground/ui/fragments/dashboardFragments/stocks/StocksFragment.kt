package com.smg.stock_market_ground.ui.fragments.dashboardFragments.stocks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smg.stock_market_ground.R
import com.smg.stock_market_ground.databinding.FragmentStocksBinding


class StocksFragment : Fragment() {

    private lateinit var stocksBinding: FragmentStocksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        stocksBinding = FragmentStocksBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return stocksBinding.root
    }

}