package com.smg.stock_market_ground.ui.fragments.dashboardFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.smg.stock_market_ground.base.BaseFragment
import com.smg.stock_market_ground.databinding.FragmentHomeBinding
import com.smg.stock_market_ground.ui.activities.AuthActivity
import com.smg.stock_market_ground.utils.Constants
import com.smg.stock_market_ground.utils.SharedPrefs
import com.smg.stock_market_ground.utils.makeSnackBar

class HomeFragment : BaseFragment() {

    private lateinit var homeBinding: FragmentHomeBinding

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var mView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = view
        attachObservers()
        allClicks()
    }

    private fun allClicks(){
        homeBinding.btLogout.setOnClickListener {
            homeViewModel.userLogout(SharedPrefs.getStringFromSharedPrefs(Constants.TOKEN))
        }
    }

    private fun attachObservers(){
        homeViewModel.logoutResponse.observe(viewLifecycleOwner){
            if(it){
                callActivity(activity as AppCompatActivity, AuthActivity())
                SharedPrefs.setBoolean(isLog = false, isWel = true)
                SharedPrefs.setString(Constants.DATA, "null")
                SharedPrefs.setString(Constants.TOKEN, "null")
            }
        }

        homeViewModel.apiErrorResponse.observe(viewLifecycleOwner) {
            it?.let {
                makeSnackBar(mView, it)
            }
        }

        homeViewModel.isLoading.observe(viewLifecycleOwner){
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