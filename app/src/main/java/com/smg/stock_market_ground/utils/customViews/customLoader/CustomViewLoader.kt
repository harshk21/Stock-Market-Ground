package com.smg.stock_market_ground.utils.customViews.customLoader

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.view.WindowManager
import com.smg.stock_market_ground.R

class CustomViewLoader {

    private var progressBar: Dialog? = null

    fun loader(context: Context) {
        if (progressBar == null) {
            progressBar = Dialog(context, android.R.style.Theme_Translucent)
            progressBar?.window?.requestFeature(Window.FEATURE_NO_TITLE)
            progressBar?.window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            progressBar?.setContentView(R.layout.loader_layout)
            progressBar?.setCancelable(false)
            progressBar?.show()
        }
    }

    fun loaderDisable() {
        progressBar?.dismiss()
        progressBar = null
    }
}