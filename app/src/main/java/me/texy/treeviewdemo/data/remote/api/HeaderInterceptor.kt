package me.texy.treeviewdemo.data.remote.api

import android.util.Log
import me.texy.treeviewdemo.data.constrains.Constants
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import java.util.*

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .header(ApiPath.AUTH_TOKEN, Constants.API_KEY)
            .build()
        Log.d("TAG345", "intercept:   " + request.headers.toString())
        Timber.d(request.headers.toString())
        return chain.proceed(request)
    }
}