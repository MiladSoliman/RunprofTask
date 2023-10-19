package com.example.runprof_task.common.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

/*
** NetworkConnectivityObserver class that responsible for getting the statues of connection ( Available, Lost, UnAvailable)
* and set this statues to flow that fragment can observe on and handle each case
*/
class NetworkConnectivityObserver(private val context: Context) : NetworkObservation {

    private val connectivityManger =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun observeOnNetwork(): Flow<InternetStatus> {
        return callbackFlow {
            val callback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    launch { send(InternetStatus.Available) }
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    launch { send(InternetStatus.Lost) }
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    launch { send(InternetStatus.UnAvailable) }
                }
            }
            val networkCapabilities =
                connectivityManger.activeNetwork?.let { connectivityManger.getNetworkCapabilities(it) }
            val isInternetAvailable =
                networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true

            if (isInternetAvailable) {
                send(InternetStatus.Available)
            } else {
                send(InternetStatus.UnAvailable)
            }

            connectivityManger.registerDefaultNetworkCallback(callback)

            awaitClose {
                connectivityManger.unregisterNetworkCallback(callback)
            }
        }.distinctUntilChanged()


    }
}

interface NetworkObservation {
    fun observeOnNetwork(): Flow<InternetStatus>

}

enum class InternetStatus {
    Available, Lost, UnAvailable
}