package com.smg.stock_market_ground.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.smg.stock_market_ground.R
import com.smg.stock_market_ground.base.BaseFragment
import com.smg.stock_market_ground.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : BaseFragment() {

    private lateinit var welBinding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        welBinding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        return welBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allCLicks()
    }

    private fun allCLicks() {
        welBinding.logIn.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeScreen_to_logInFragment)
        }
        welBinding.signUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeScreen_to_signUpFragment)
        }
    }
}