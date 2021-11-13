package com.smg.stock_market_ground.utils.customViews.textViews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TextViewRegular constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init()
    }

    constructor(context: Context) : this(context, null, 0) {
        init()
    }

    private fun init() {
        val font = Typeface.createFromAsset(context.assets, "Montserrat-Regular.ttf")
        this.typeface = font
    }
}