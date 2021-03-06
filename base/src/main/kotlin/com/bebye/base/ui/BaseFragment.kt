package com.bebye.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.bebye.base.extension.observe
import com.bebye.base.utils.AutoLifecycleObserver
import com.bebye.base.utils.NetworkConnection

/**
 * Created by mkwon on 27/06/2020.
 */
abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {

    @get:LayoutRes
    protected abstract val layoutResourceId: Int

    protected abstract fun refresh()

    protected lateinit var dataBinding: VB

    private val autoLifeCycleObserver by lazy { AutoLifecycleObserver(lifecycle) }

    protected var isNetworkConnected: Boolean = true

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNetworkConnection()
    }

    protected open fun initNetworkConnection() {
        NetworkConnection().observe(viewLifecycleOwner) {
            if (!isNetworkConnected && it) {
                refresh()
            } else if (!it) {
                // TODO : show exception view
            }
            isNetworkConnected = it
        }
    }

}