package ru.tinkoff.edu.popularfilms.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build

enum class ConnectionType {
    WIFI, CELLULAR
}

class NetworkUtils(context: Context) {

    private var mContext = context

    private lateinit var networkCallback: NetworkCallback

    lateinit var result: ((isAvailable: Boolean, type: ConnectionType?) -> Unit)

    fun register() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager.activeNetwork == null)
                result(false, null)

            networkCallback = object : NetworkCallback() {
                override fun onLost(network: Network) {
                    super.onLost(network)
                    result(false, null)
                }

                override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
                    super.onCapabilitiesChanged(network, networkCapabilities)
                    when {
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ->
                            result(true, ConnectionType.WIFI)

                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->
                            result(true, ConnectionType.CELLULAR)
                    }
                }
            }
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        } else {
            val intentFilter = IntentFilter()
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
            mContext.registerReceiver(networkChangeReceiver, intentFilter)
        }
    }

    fun unregister() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            connectivityManager.unregisterNetworkCallback(networkCallback)
        } else {
            mContext.unregisterReceiver(networkChangeReceiver)
        }
    }

    private val networkChangeReceiver: BroadcastReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetworkInfo = connectivityManager.activeNetworkInfo

            if (activeNetworkInfo != null) {
                when (activeNetworkInfo.type) {
                    ConnectivityManager.TYPE_WIFI -> {
                        result(true, ConnectionType.WIFI)
                    } else -> {
                        result(true, ConnectionType.CELLULAR)
                    }
                }
            } else {
                result(false, null)
            }
        }
    }
}