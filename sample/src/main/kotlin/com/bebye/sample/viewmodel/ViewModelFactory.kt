package com.bebye.sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by mkwon on 28/06/2020.
 */
object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        modelClass.run {
            when {
                isAssignableFrom(MainViewModel::class.java) -> MainViewModel()
                else -> super.create(modelClass)
            }
        } as T

}