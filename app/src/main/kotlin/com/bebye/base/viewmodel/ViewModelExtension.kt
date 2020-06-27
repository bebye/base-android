package com.bebye.base.viewmodel

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * Created by mkwon on 27/06/2020.
 */
inline fun <reified VM : BaseViewModel> ViewModelStoreOwner.createViewModel(viewModelFactory: ViewModelProvider.Factory? = null): VM {
    return viewModelFactory?.let { ViewModelProvider(this, it).get(VM::class.java) }
        ?: ViewModelProvider(this).get(VM::class.java)
}

inline fun <reified VM : BaseViewModel> ComponentActivity.viewModels(viewModelFactory: ViewModelProvider.Factory): Lazy<VM> {
    return viewModels { viewModelFactory }
}

inline fun <reified VM : BaseViewModel> Fragment.viewModels(viewModelFactory: ViewModelProvider.Factory): Lazy<VM> {
    return viewModels { viewModelFactory }
}

inline fun <reified VM : BaseViewModel> Fragment.activityViewModels(viewModelFactory: ViewModelProvider.Factory): Lazy<VM> {
    return activityViewModels { viewModelFactory }
}

inline fun <reified VM : BaseViewModel> ComponentActivity.savedStateViewModel(): Lazy<VM> {
    return viewModels()
}

inline fun <reified VM : BaseViewModel> Fragment.savedStateViewModel(): Lazy<VM> {
    return viewModels()
}