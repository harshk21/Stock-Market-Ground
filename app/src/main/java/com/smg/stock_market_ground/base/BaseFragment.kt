package com.softradix.financial_calculator.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController

/**
 * Base fragment with some common functions
 * Inheriting base activity functions
 **/

open class BaseFragment : Fragment() {

    private var mActivity: FragmentActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity
    }

    /*
    * to call fragments
    */

    fun callFragment(view: View, fragmentId: Int) {
        view.findNavController().navigate(fragmentId)

    }

    fun callFragment(view: View, fragmentId: Int, bundle: Bundle) {
        view.findNavController().navigate(fragmentId, bundle)

    }

    fun callActivity(context: AppCompatActivity, activity: AppCompatActivity) {
        startActivity(
            Intent(context, activity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )

        context.finishAffinity()
    }

    fun callActivity(context: AppCompatActivity, activity: AppCompatActivity, bundle: Bundle?) {
        startActivity(
            Intent(context, activity::class.java).apply {
                bundle?.let {
                    putExtras(it)
                }
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
        )
    }

    /*
    to get all the functions from base activity
    */
    fun getBaseActivity(): BaseActivity {
        return requireActivity() as BaseActivity
    }

}