package com.example.android3lesson6dz.di

import com.example.android3lesson6dz.data.remote.RetrofitClient
import com.example.android3lesson6dz.data.remote.apisevices.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideNewsApiService() : NewsApiService{
        return retrofitClient.provideNewsApiServices()
    }
}