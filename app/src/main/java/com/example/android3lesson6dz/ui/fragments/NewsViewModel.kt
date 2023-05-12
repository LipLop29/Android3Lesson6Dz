package com.example.android3lesson6dz.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3lesson6dz.data.repositories.NewsRepository
import com.example.android3lesson6dz.models.news.ArticlesItem
import retrofit2.Response
import javax.inject.Inject

class NewsViewModel  @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    fun fetchNews() :MutableLiveData<Response<ArticlesItem>>{
        return newsRepository.fetchNews()
    }
}