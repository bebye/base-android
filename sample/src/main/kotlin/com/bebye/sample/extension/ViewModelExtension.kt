package com.bebye.sample.extension

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelStoreOwner
import com.bebye.base.extension.activityViewModels
import com.bebye.base.extension.createViewModel
import com.bebye.base.extension.savedStateViewModel
import com.bebye.base.extension.viewModels
import com.bebye.base.viewmodel.BaseViewModel
import com.bebye.sample.viewmodel.ViewModelFactory

/**
 * Created by mkwon on 28/06/2020.
 */
inline fun <reified VM : BaseViewModel> ViewModelStoreOwner.createViewModel() : VM = createViewModel(ViewModelFactory)

inline fun <reified VM : BaseViewModel> ComponentActivity.getViewModel(): Lazy<VM> = viewModels(ViewModelFactory)

inline fun <reified VM : BaseViewModel> Fragment.getViewModel(): Lazy<VM> = viewModels(ViewModelFactory)

inline fun <reified VM : BaseViewModel> Fragment.getActivityViewModel(): Lazy<VM> = activityViewModels(ViewModelFactory)

inline fun <reified VM : BaseViewModel> ComponentActivity.getSavedStateViewModel(): Lazy<VM> = savedStateViewModel()

inline fun <reified VM : BaseViewModel> Fragment.getSavedStateViewModel(): Lazy<VM> = savedStateViewModel()