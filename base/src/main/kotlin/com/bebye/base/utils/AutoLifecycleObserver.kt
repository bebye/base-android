package com.bebye.base.utils

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.bebye.base.currentClassName
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.plusAssign

/**
 * Created by mkwon on 27/06/2020.
 */
class AutoLifecycleObserver(private val lifecycle: Lifecycle) : LifecycleObserver {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    var className: String? = null

    fun init(activity: Activity) {
        lifecycle.addObserver(this)
        className = activity::class.java.simpleName
    }

    fun init(fragment: Fragment) {
        lifecycle.addObserver(this)
        className = fragment::class.java.simpleName
    }

    fun addDisposable(disposable: Disposable) {
        check(lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED))
        compositeDisposable += disposable
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
        compositeDisposable.clear()
        lifecycle.removeObserver(this)
    }

    private fun logInfo(lifecycleName: String) {
        Log.d(this::class.java.simpleName, "$className - $lifecycleName")
    }

}