package com.bebye.base.viewmodel

/**
 * Created by mkwon on 27/06/2020.
 */
class BaseViewModelLazy<VM: BaseViewModel>(viewModelLazy: Lazy<VM>) : Lazy<VM> {

    val viewModel by viewModelLazy

    override val value: VM
        get() = viewModel

    override fun isInitialized() = true

}