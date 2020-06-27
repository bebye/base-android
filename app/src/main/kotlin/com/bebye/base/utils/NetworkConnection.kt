package com.bebye.base.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import com.bebye.base.appContext

/**
 * Created by mkwon on 27/06/2020.
 */
class NetworkConnection : LiveData<Boolean>() {

    private val TAG = this::class.java.simpleName

    private val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private enum class NetworkType {
        NONE, WIFI, MOBILE, ETC
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network?) {
            Log.d(TAG, "onAvailable()")
            postValue(checkNetworkType() != NetworkType.NONE)
        }

        override fun onLost(network: Network?) {
            Log.d(TAG, "onLost()")
            postValue(false)
        }

    }

    override fun onActive() {
        super.onActive()

        Log.d(TAG, "onActive()")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        } else {
            val networkBuilder = NetworkRequest.Builder().build()
            connectivityManager.registerNetworkCallback(networkBuilder, networkCallback)
        }
    }

    override fun onInactive() {
        super.onInactive()
        Log.d(TAG, "onInactive()")
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    private fun checkNetworkType(): NetworkType {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI)     -> NetworkType.WIFI
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> NetworkType.MOBILE
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> NetworkType.ETC
                    else                                                 -> NetworkType.NONE
                }
            } ?: NetworkType.NONE
        } else {
            connectivityManager.activeNetworkInfo?.run {
                when (type) {
                    ConnectivityManager.TYPE_WIFI   -> NetworkType.WIFI
                    ConnectivityManager.TYPE_MOBILE -> NetworkType.MOBILE
                    else                            -> NetworkType.NONE
                }
            } ?: NetworkType.NONE
        }
    }

}