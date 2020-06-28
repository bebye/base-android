package com.bebye.base.utils

import android.util.TypedValue
import androidx.annotation.DimenRes
import com.bebye.base.appContext

/**
 * Created by mkwon on 27/06/2020.
 */
object ScaleUtils {

    fun dp2px(dp: Int): Int {
        val displayMetrics = appContext.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), displayMetrics).toInt()
    }

    fun dp2px(dp: Float): Int {
        val displayMetrics = appContext.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics).toInt()
    }

    fun dimen2px(@DimenRes dimension: Int): Int {
        return appContext.resources.getDimensionPixelSize(dimension)
    }

}