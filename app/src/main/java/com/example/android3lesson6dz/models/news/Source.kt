package com.example.android3lesson6dz.models.news

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: String = ""
)