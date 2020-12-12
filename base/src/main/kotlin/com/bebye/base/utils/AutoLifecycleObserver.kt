package com.bebye.base.utils

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.bebye.base.currentClassName

/**
 * Created by mkwon on 27/06/2020.
 */
class AutoLifecycleObserver(private val lifecycle: Lifecycle) : LifecycleObserver {

    var className: String? = null

    fun init(activity: Activity) {
        lifecycle.addObserver(this)
        className = activity::class.java.simpleName
    }

    fun init(fragment: Fragment) {
        lifecycle.addObserver(this)
        className = fragment::class.java.simpleName
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        logInfo("onCreate()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart() {
        logInfo("onStart()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        logInfo("onResume()")
        currentClassName = className
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause() {
        logInfo("onPause()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onStop() {
        logInfo("onStop()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        logInfo("onDestroy()")
        lifecycle.removeObserver(this)
    }

    private fun logInfo(lifecycleName: String) {
        Log.d(this::class.java.simpleName, "$className - $lifecycleName")
    }

}