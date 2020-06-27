package com.bebye.base.extension

import android.util.DisplayMetrics
import androidx.activity.ComponentActivity

/**
 * Created by mkwon on 27/06/2020.
 */
fun ComponentActivity.getDeviceRealWidth() = getRealDisplayMetrics().widthPixels

fun ComponentActivity.getDeviceRealHeight() = getRealDisplayMetrics().heightPixels

fun ComponentActivity.getDeviceWidth() = getDisplayMetrics().widthPixels

fun ComponentActivity.getDeviceHeight() = getDisplayMetrics().heightPixels

/**
 * with StatusBar and NavigationBar
 */
fun ComponentActivity.getRealDisplayMetrics() : DisplayMetrics {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getRealMetrics(displayMetrics)
    return displayMetrics
}

/**
 * without StatusBar and NavigationBar
 */
fun ComponentActivity.getDisplayMetrics() : DisplayMetrics {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics
}

