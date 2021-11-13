package com.smg.stock_market_ground.ui.fragments.authFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.smg.stock_market_ground.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private lateinit var signUpBinding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        signUpBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        return signUpBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allClicks()
    }

    private fun allClicks() {
        signUpBinding.ivBack.setOnClickListener {
            it.findNavController().navigateUp()
        }
    }


}