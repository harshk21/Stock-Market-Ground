package com.smg.stock_market_ground.ui.fragments.authFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smg.stock_market_ground.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {

    private lateinit var welBinding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        welBinding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        return welBinding.root
    }


}