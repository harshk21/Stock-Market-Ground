package com.smg.stock_market_ground.ui.fragments.dashboardFragments.arena

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smg.stock_market_ground.R
import com.smg.stock_market_ground.databinding.FragmentArenaBinding

class ArenaFragment : Fragment() {

    private lateinit var arenaBinding: FragmentArenaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arenaBinding = FragmentArenaBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return arenaBinding.root
    }

}