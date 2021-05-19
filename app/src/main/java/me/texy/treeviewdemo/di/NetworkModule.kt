package me.texy.treeviewdemo.di

import android.util.Log
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.texy.treeviewdemo.data.constrains.Constants
import me.texy.treeviewdemo.data.remote.api.ApiPath
import me.texy.treeviewdemo.data.remote.api.ApiService
import me.texy.treeviewdemo.data.remote.api.HeaderInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    val TIMEOUT = 10

    @Singleton
    @Provides
    @Named("header")
    fun provideHeaderInterceptor(): Interceptor = HeaderInterceptor()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @Named("header") header: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original = chain.request()
                    val request = original.newBuilder()
                        .header(ApiPath.AUTH_TOKEN, Constants.API_KEY)
                        .build()
                    Log.d("TAG345", "intercept:   " + request.headers.toString())
                    return chain.proceed(request)
                }
            })
            .build()

    @Singleton
    @Provides
    @Named("api")
    fun provideApiRedditRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiPath.REDDIT_API_URL)
            .client(okHttpClient).build()

    @Singleton
    @Provides
    @Named("apiFootball")
    fun provideApiFootballRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiPath.FOOTBALL_API_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiFootballService(
        @Named("apiFootball") retrofit: Retrofit
    ): ApiService = retrofit.create(ApiService::class.java)

//    @Singleton
//    @Provides
//    @Named("api")
//    fun provideApiRedditService(
//        @Named("api") retrofit: Retrofit
//    ): ApiService = retrofit.create(ApiService::class.java)
}