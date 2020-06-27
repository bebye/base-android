package com.bebye.base.viewmodel

import kotlinx.coroutines.CoroutineScope

/**
 * Created by mkwon on 27/06/2020.
 */
interface CoroutineThrottleInterface {

    var coroutineThrottleScope: CoroutineScope

    fun throttleFirst(delayTime: Int = 200, function: () -> Unit)
    fun throttleLast(delayTime: Int = 200, function: () -> Unit)
    fun debounce(waitTime: Int = 200, function: () -> Unit)

}