package com.bebye.base.utils

import android.util.Log
import com.bebye.base.appContext
import com.bebye.base.model.AdInfo
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Created by mkwon on 27/06/2020.
 */
object ADIDUtil {

    private val TAG = ADIDUtil::class.java.simpleName

    fun requestAdInfo(onSuccess: (AdInfo?) -> Unit = {}) {
        CoroutineScope(Dispatchers.IO).launch {
            getAdInfo()?.let {
                onSuccess(AdInfo(it.id, it.isLimitAdTrackingEnabled))
            } ?: onSuccess(null)
        }
    }

    private fun getAdInfo(): AdvertisingIdClient.Info? = try {
        AdvertisingIdClient.getAdvertisingIdInfo(appContext)
    } catch (e: Exception) {
        when (e) {
            is IOException -> Log.d(TAG, "getAdInfo() : GooglePlayServices connection failed.")
            is NoClassDefFoundError -> Log.d(TAG, "getAdInfo() : GooglePlayServices Library is missing.")
            is IllegalStateException -> Log.d(TAG, "getAdInfo() : IllegalStateException")
            is GooglePlayServicesRepairableException -> Log.d(TAG, "getAdInfo() : GooglePlayServices is not installed.")
            is GooglePlayServicesNotAvailableException -> Log.d(TAG, "getAdInfo() : GooglePlayServices is not available.")
        }
        Log.d(TAG, "$e")
        null
    }

}