package com.smg.stock_market_ground.ui.fragments.dashboardFragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.smg.stock_market_ground.adapter.HomeAdapter
import com.smg.stock_market_ground.base.BaseFragment
import com.smg.stock_market_ground.databinding.FragmentHomeBinding
import com.smg.stock_market_ground.model.HomeArenaModel
import com.smg.stock_market_ground.ui.activities.AuthActivity
import com.smg.stock_market_ground.utils.Constants
import com.smg.stock_market_ground.utils.SharedPrefs
import com.smg.stock_market_ground.utils.customViews.customLoader.CustomViewLoader
import com.smg.stock_market_ground.utils.makeSnackBar

class HomeFragment : BaseFragment() {

    private lateinit var homeBinding: FragmentHomeBinding

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var mView: View

    private lateinit var customViewLoader: CustomViewLoader

    private lateinit var list: ArrayList<HomeArenaModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = ArrayList()
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
        customViewLoader = CustomViewLoader()
        mView = view
        attachObservers()
        allClicks()
        setUp(view)
    }

    private fun allClicks() {
        homeBinding.btLogout.setOnClickListener {
            homeViewModel.userLogout(SharedPrefs.getStringFromSharedPrefs(Constants.TOKEN))
        }
    }

    private fun attachObservers() {
        homeViewModel.logoutResponse.observe(viewLifecycleOwner) {
            if (it) {
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

        homeViewModel.isLoading.observe(viewLifecycleOwner) {
            it?.let {
                if (it) {
                    customViewLoader.loader(requireContext())
                } else {
                    customViewLoader.loaderDisable()
                }
            }
        }
    }

    private fun setUp(view: View){
        list.add(HomeArenaModel(type = "Arena Minor", entry = "Rs. 100", arenaPrize = "Rs. 100000"))
        list.add(HomeArenaModel(type = "Arena Major", entry = "Rs. 500", arenaPrize = "Rs. 500000"))
        list.add(HomeArenaModel(type = "Arena Maestro", entry = "Rs. 1000", arenaPrize = "Rs. 1000000"))
        list.add(HomeArenaModel(type = "Arena King", entry = "Rs. 2000", arenaPrize = "Rs. 2000000"))

        homeBinding.recyclerView.apply {
            adapter = HomeAdapter(list)
            layoutManager = LinearLayoutManager(requireActivity())
        }

    }

}