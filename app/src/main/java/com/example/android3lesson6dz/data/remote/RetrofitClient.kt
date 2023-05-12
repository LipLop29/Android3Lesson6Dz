package com.example.android3lesson6dz.data.remote

import com.example.android3lesson6dz.data.remote.apisevices.NewsApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private var OkHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://newsapi.org")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient)
        .build()

    fun provideNewsApiServices(): NewsApiService {
        return retrofitClient.create(NewsApiService::class.java)
    }

//
//    fun provideLocationApiService(): LocationApiService {
//        return retrofitClient.create(LocationApiService::class.java)
//    }
//
//    fun provideEpisodeApiService(): EpisodeApiService {
//        return retrofitClient.create(EpisodeApiService::class.java)
//    }
}