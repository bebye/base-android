package com.bebye.base.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job

/**
 * Created by mkwon on 27/06/2020.
 */
open class BaseViewModel : ViewModel(), CoroutineThrottleInterface by CoroutineThrottle() {

    private val job = Job()

    init {
        coroutineThrottleScope = viewModelScope
    }

    var isShowRefresh: MutableLiveData<Boolean> = MutableLiveData()
    var isShowProgress: MutableLiveData<Boolean> = MutableLiveData()
    var isShowFooter: MutableLiveData<Boolean> = MutableLiveData()

    protected fun isLoading(): Boolean = isShowRefresh.value == true || isShowFooter.value == true || isShowProgress.value == true

    @CallSuper
    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }

}