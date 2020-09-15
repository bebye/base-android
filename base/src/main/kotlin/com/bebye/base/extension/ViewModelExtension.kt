package com.bebye.base.extension

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bebye.base.viewmodel.BaseViewModel

/**
 * Created by mkwon on 27/06/2020.
 */
inline fun <reified VM : BaseViewModel> ComponentActivity.getViewModels(viewModelFactory: ViewModelProvider.Factory? = null): Lazy<VM> {
    return viewModels(viewModelFactory?.let { { it } })
}

inline fun <reified VM : BaseViewModel> Fragment.getViewModels(viewModelFactory: ViewModelProvider.Factory? = null): Lazy<VM> {
    return viewModels({ this }, viewModelFactory?.let { { it } })
}

inline fun <reified VM : BaseViewModel> Fragment.getActivityViewModels(viewModelFactory: ViewModelProvider.Factory? = null): Lazy<VM> {
    return activityViewModels(viewModelFactory?.let { { it } })
}