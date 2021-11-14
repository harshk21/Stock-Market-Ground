package com.smg.stock_market_ground.ui.fragments.authFragments

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.smg.stock_market_ground.databinding.FragmentLogInBinding
import com.smg.stock_market_ground.ui.activities.DashBoardActivity
import com.smg.stock_market_ground.utils.Constants
import com.smg.stock_market_ground.utils.SharedPrefs.Companion.setBoolean
import com.smg.stock_market_ground.utils.SharedPrefs.Companion.setString
import com.smg.stock_market_ground.utils.makeSnackBar
import com.softradix.financial_calculator.base.BaseFragment
import java.util.regex.Pattern

class LogInFragment : BaseFragment() {

    private lateinit var logInBinding: FragmentLogInBinding

    private lateinit var mViewModel: AuthViewModel

    private lateinit var map: HashMap<String, String>

    private lateinit var mView: View

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
        logInBinding = FragmentLogInBinding.inflate(inflater, container, false)
        return logInBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = view
        allClicks()
    }

    private fun allClicks() {
        logInBinding.ivBack.setOnClickListener {
            it.findNavController().navigateUp()
        }

        logInBinding.btLogin.setOnClickListener {
            login()
        }

    }

    private fun initData(email: String, password: String) {
        map = HashMap()
        map["login"] = email
        map["password"] = password
    }

    private fun login() {
        val email = logInBinding.etEmail.text.toString()
        val password = logInBinding.etPass.text.toString()
        if (validation(email, password)) {
            initData(email, password)
            mViewModel.logIn(map)
        }

    }

    private fun validation(e: String, p: String): Boolean {
        if (e.isNotEmpty()) {
            return if (Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
                val password = Pattern.compile(Constants.PASSWORD_REGEX)
                if (p.isNotEmpty()) {
                    password.matcher(p)
                    true
                } else {
                    makeSnackBar(mView, "Password cannot be empty")
                    false
                }
            } else {
                makeSnackBar(mView, "enter a valid email address")
                false
            }
        } else {
            makeSnackBar(mView, "Please enter email")
            return false
        }
    }

    private fun attachObserver() {
        mViewModel.logInResponse.observe(this) { response ->
            response?.let {
                if (response.userStatus == "ENABLED") {
                    callActivity(activity as AppCompatActivity, DashBoardActivity())
                    setString(Constants.DATA, Gson().toJson(it))
                    setString(Constants.TOKEN, it.userToken)
                    setBoolean(true, isWel = false)
                }
            }
        }
        mViewModel.apiErrorResponse.observe(this) {
            it?.let {
                makeSnackBar(mView,it)
            }
        }
        mViewModel.isLoading.observe(this) {
            it?.let {
                if (it) {
                    /**
                     * loader to be done
                     **/
//                    customViewLoader.loader(requireContext())
                } else {
                    /**
                     * loader to be done
                     **/
//                    customViewLoader.loaderDisable()
                }
            }
        }
    }
}