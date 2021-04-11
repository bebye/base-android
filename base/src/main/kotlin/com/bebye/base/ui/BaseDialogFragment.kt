package com.bebye.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.bebye.base.utils.AutoLifecycleObserver

/**
 * Created by mkwon on 27/06/2020.
 */
abstract class BaseDialogFragment<VB : ViewDataBinding> : DialogFragment() {

    protected abstract val fragmentTag: String

    @get:LayoutRes
    protected abstract val layoutResourceId: Int

    protected lateinit var dataBinding: VB

    private val autoLifeCycleObserver by lazy { AutoLifecycleObserver(lifecycle) }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoLifeCycleObserver.init(this)
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    fun show(manager: FragmentManager) {
        if (isAdded) return
        super.show(manager, fragmentTag)
    }

}