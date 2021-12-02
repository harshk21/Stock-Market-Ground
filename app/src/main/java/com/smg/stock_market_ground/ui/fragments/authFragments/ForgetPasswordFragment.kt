package com.smg.stock_market_ground.ui.fragments.authFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.smg.stock_market_ground.databinding.FragmentForgetPasswordBinding
import com.smg.stock_market_ground.utils.Constants
import com.smg.stock_market_ground.utils.customViews.customLoader.CustomViewLoader
import com.smg.stock_market_ground.utils.makeSnackBar


class ForgetPasswordFragment : Fragment() {

    private lateinit var bindingForget: FragmentForgetPasswordBinding

    private lateinit var mViewModel: AuthViewModel

    private lateinit var customViewLoader: CustomViewLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingForget = FragmentForgetPasswordBinding.inflate(inflater, container, false)
        return bindingForget.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        customViewLoader = CustomViewLoader()
        allClicks()
        attachObservers()
    }

    private fun allClicks() {
        bindingForget.ivBack.setOnClickListener {
            it.findNavController().navigateUp()
        }

        bindingForget.btReset.setOnClickListener {
            val email = bindingForget.etEmail.text.toString()
            mViewModel.passwordReset(email)
        }
    }

    private fun attachObservers() {
        mViewModel.passwordResetResponse.observe(viewLifecycleOwner) {
            if (it) {
                makeSnackBar(bindingForget.root, Constants.SENT_MAIL)
            }
        }

        mViewModel.isLoading.observe(viewLifecycleOwner) {
            it?.let {
                if (it) {
                    customViewLoader.loader(requireContext())
                } else {
                    customViewLoader.loaderDisable()
                }
            }
        }
    }

}