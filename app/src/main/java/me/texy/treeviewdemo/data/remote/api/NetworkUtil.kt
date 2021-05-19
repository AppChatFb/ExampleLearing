package me.texy.treeviewdemo.data.remote.api

import android.content.Context
import android.net.ConnectivityManager

open class NetworkUtil {
    fun hasNetwork(context: Context): Boolean {
        var isConnected = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected) {
            isConnected = true
        }
        return isConnected
    }
}