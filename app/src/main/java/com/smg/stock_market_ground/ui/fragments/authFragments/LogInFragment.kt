package com.smg.stock_market_ground.ui.fragments.authFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smg.stock_market_ground.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {

    private lateinit var logInBinding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        logInBinding = FragmentLogInBinding.inflate(inflater, container, false)
        return logInBinding.root
    }


}