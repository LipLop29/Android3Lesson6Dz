package com.example.android3lesson6dz.models.news

import com.google.gson.annotations.SerializedName

data class NewsResponse<T>(

    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("articles")
    val articles: List<T>?,

    @SerializedName("status")
    val status: String = ""
)