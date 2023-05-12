package com.example.android3lesson6dz.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android3lesson6dz.data.remote.apisevices.NewsApiService
import com.example.android3lesson6dz.data.repositories.pagingsources.NewsPagingSource
import com.example.android3lesson6dz.models.news.ArticlesItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsRepository  @Inject constructor(
    private val newsApiService: NewsApiService
) {
    private val _newsLiveData = MutableLiveData<List<ArticlesItem>>()
    val newsLiveData: LiveData<List<ArticlesItem>> = _newsLiveData


    fun fetchNews(): Flow<PagingData<ArticlesItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                NewsPagingSource(newsApiService!!)
            }).flow
    }
}