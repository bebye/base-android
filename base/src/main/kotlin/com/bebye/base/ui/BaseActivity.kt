package com.bebye.base.ui

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.bebye.base.utils.AutoLifecycleObserver

/**
 * Created by mkwon on 27/06/2020.
 */
abstract class BaseActivity(private val isDataBinding: Boolean = false) : AppCompatActivity() {

    @get:LayoutRes
    protected abstract val layoutResourceId: Int

    protected val autoLifeCycleObserver by lazy { AutoLifecycleObserver(lifecycle) }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoLifeCycleObserver.init(this)
        if (!isDataBinding) setContentView(layoutResourceId)
    }

}