package com.example.android3lesson6dz.data.remote.apisevices

import com.example.android3lesson6dz.models.news.ArticlesItem
import com.example.android3lesson6dz.models.news.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("/v2/top-headlines?country=us&apiKey=43dc89b92d32488f9610185be65d7726")
    suspend fun fetchNews(
        @Query("page") page: Int,
    ): NewsResponse<ArticlesItem>
}