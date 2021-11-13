package com.smg.stock_market_ground.utils.customViews.editTextViews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class EditTextView constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    def: Int = 0
) : AppCompatEditText(context, attributeSet, def) {

    constructor(context: Context, attributeSet: AttributeSet?) : this(
        context,
        attributeSet,
        android.R.attr.editTextStyle
    ) {
        init()
    }

    constructor(context: Context) : this(context, null, android.R.attr.editTextStyle) {
        init()
    }


    private fun init() {
        val font = Typeface.createFromAsset(context.assets, "/Montserrat-Bold.ttf")
        this.typeface = font
    }
}
