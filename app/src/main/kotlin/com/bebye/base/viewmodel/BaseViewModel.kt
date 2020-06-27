package com.bebye.base.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * Created by mkwon on 27/06/2020.
 */
open class BaseViewModel : ViewModel(), CoroutineThrottleInterface by CoroutineThrottle() {

    private val job = Job()
    protected val viewModelScope = CoroutineScope(Dispatchers.Main + job)

    init {
        coroutineThrottleScope = viewModelScope
    }

    protected val disposable = CompositeDisposable()

    var isShowRefresh: MutableLiveData<Boolean> = MutableLiveData()
    var isShowProgress: MutableLiveData<Boolean> = MutableLiveData()
    var isShowFooter: MutableLiveData<Boolean> = MutableLiveData()

    protected fun isLoading(): Boolean = isShowRefresh.value == true || isShowFooter.value == true || isShowProgress.value == true

    @CallSuper
    override fun onCleared() {
        disposable.clear()
        job.cancel()
        super.onCleared()
    }

}