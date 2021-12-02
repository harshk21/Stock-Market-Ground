package com.smg.stock_market_ground.ui.fragments.authFragments

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.smg.stock_market_ground.R
import com.smg.stock_market_ground.base.BaseFragment
import com.smg.stock_market_ground.databinding.FragmentSignUpBinding
import com.smg.stock_market_ground.utils.Constants
import com.smg.stock_market_ground.utils.customViews.customLoader.CustomViewLoader
import com.smg.stock_market_ground.utils.makeSnackBar
import java.util.regex.Pattern


class SignUpFragment : BaseFragment() {

    private lateinit var signUpBinding: FragmentSignUpBinding

    private lateinit var mView: View

    private lateinit var mViewModel: AuthViewModel

    private lateinit var map: HashMap<String, String>

    private lateinit var customViewLoader: CustomViewLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        attachObserver()
    }

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
        customViewLoader = CustomViewLoader()
        mView = view
        allClicks()
    }

    private fun allClicks() {
        signUpBinding.ivBack.setOnClickListener {
            it.findNavController().navigateUp()
        }

        signUpBinding.btSignUp.setOnClickListener {
            signUp()
        }
    }

    private fun attachObserver() {

        mViewModel.signUpResponse.observe(this) { response ->
            response?.let {
                if (response.userStatus == "ENABLED") {
                    makeSnackBar(mView, "Welcome ${response.name}, Please Login to proceed.")
                    mView.findNavController().navigate(R.id.logInFragment)
                }
            }
        }
        mViewModel.apiErrorResponse.observe(this) {
            it?.let {
                makeSnackBar(mView, it)
            }
        }
        mViewModel.isLoading.observe(this) {
            it?.let {
                if (it) {
                    customViewLoader.loader(requireContext())
                } else {
                    customViewLoader.loaderDisable()
                }
            }
        }


    }

    private fun signUp() {
        val fName = signUpBinding.edtFirstName.text.toString()
        val lName = signUpBinding.edtLastName.text.toString()
        val email = signUpBinding.edtEmailSignup.text.toString()
        val password = signUpBinding.edtPasswordSignup.text.toString()
        if (validation(fName, lName, email, password)) {
            initData(fName, lName, email, password)
            mViewModel.signUp(map)
        }

    }

    private fun validation(fName: String, lName: String, email: String, password: String): Boolean {
        if (fName.isNotEmpty() && lName.isNotEmpty()) {
            if (email.isNotEmpty()) {
                return if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    val pattern = Pattern.compile(Constants.PASSWORD_REGEX)
                    if (password.isNotEmpty()) {
                        pattern.matcher(password)
                        return if (signUpBinding.cbKeepMe.isChecked && signUpBinding.cbTermsAgree.isChecked) {
                            true
                        } else {
                            makeSnackBar(mView, "Please Agree to terms and Conditions")
                            false
                        }
                    } else {
                        makeSnackBar(mView, "Password cannot be empty")
                        false
                    }
                } else {
                    makeSnackBar(mView, "Enter a valid email address")
                    false
                }
            } else {
                makeSnackBar(mView, "Please enter email")
                return false
            }
        } else {
            makeSnackBar(mView, "Firstname or last name cannot be empty")
            return false
        }
    }

    private fun initData(firstName: String, lastName: String, email: String, password: String) {
        val name = firstName + lastName
        map = HashMap()
        map["name"] = name
        map["last_name"] = lastName
        map["email"] = email
        map["password"] = password
    }

}