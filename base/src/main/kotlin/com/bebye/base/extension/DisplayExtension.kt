package com.bebye.base.extension

import android.content.Context
import android.graphics.Insets
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowInsets
import android.view.WindowManager
import android.view.WindowMetrics
import androidx.activity.ComponentActivity


/**
 * Created by mkwon on 27/06/2020.
 */
fun ComponentActivity.getDisplayRealWidth() = getRealDisplayMetrics().widthPixels

fun ComponentActivity.getDisplayRealHeight() = getRealDisplayMetrics().heightPixels

fun ComponentActivity.getDisplayWidth() = getDisplaySize(false)

fun ComponentActivity.getDisplayHeight() = getDisplaySize(true)

fun Context.getDisplayWidth() = getDisplayMetrics().widthPixels

fun Context.getDisplayHeight() = getDisplayMetrics().heightPixels

fun ComponentActivity.getStatusBarHeight(): Int {
    var result = 0
    val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId)
    }
    return result
}

/**
 * with StatusBar and NavigationBar
 */
fun ComponentActivity.getRealDisplayMetrics(): DisplayMetrics {
    val displayMetrics = DisplayMetrics()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        display?.getRealMetrics(displayMetrics)
    } else windowManager.defaultDisplay.getRealMetrics(displayMetrics)
    return displayMetrics
}

fun Context.getDisplayMetrics() : DisplayMetrics {
    val windowManager = (getSystemService(Context.WINDOW_SERVICE) as WindowManager)
    val displayMetrics = DisplayMetrics()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        display?.getRealMetrics(displayMetrics)
    } else windowManager.defaultDisplay.getRealMetrics(displayMetrics)
    return displayMetrics
}

/**
 * without StatusBar and NavigationBar
 */
private fun ComponentActivity.getDisplaySize(isHeight: Boolean): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
        val insets: Insets = windowMetrics.windowInsets
                .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
        if (isHeight) windowMetrics.bounds.height() - insets.top - insets.bottom
        else windowMetrics.bounds.width() - insets.left - insets.right
    } else {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        if (isHeight) displayMetrics.heightPixels else displayMetrics.widthPixels
    }
}