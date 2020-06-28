package com.bebye.base.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by mkwon on 27/06/2020.
 */
class CoroutineThrottle : CoroutineThrottleInterface {

    override lateinit var coroutineThrottleScope: CoroutineScope

    private var throttleFirstJob: Job? = null
    private var throttleFirstTime: Long = System.currentTimeMillis()

    private var throttleLastJob: Job? = null
    private var throttleLastTime: Long = System.currentTimeMillis()

    private var throttleWithTimeOutJob: Job? = null

    override fun throttleFirst(delayTime: Int, function: () -> Unit) {
        if (throttleFirstTime + delayTime < System.currentTimeMillis()) {
            if (throttleFirstJob == null || throttleFirstJob?.isActive == false) {
                throttleFirstJob = coroutineThrottleScope.launch {
                    throttleFirstTime = System.currentTimeMillis()
                    function()
                }
            }
        }
    }

    override fun throttleLast(delayTime: Int, function: () -> Unit) {
        val realDelay = throttleLastTime + delayTime - System.currentTimeMillis()
        if (realDelay > 0) throttleLastJob?.cancel()
        throttleLastJob = coroutineThrottleScope.launch {
            delay(realDelay)
            throttleLastTime = System.currentTimeMillis()
            function()
        }
    }

    override fun debounce(waitTime: Int, function: () -> Unit) {
        throttleWithTimeOutJob?.cancel()
        throttleWithTimeOutJob = coroutineThrottleScope.launch {
            delay(waitTime.toLong())
            function()
        }
    }

}