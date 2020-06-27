package com.bebye.base.ui

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by mkwon on 27/06/2020.
 */
abstract class BaseDataBindingActivity<VB : ViewDataBinding> : BaseActivity(true) {

    protected lateinit var dataBinding: VB

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoLifeCycleObserver.init(this)
        dataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
        dataBinding.lifecycleOwner = this
    }

}