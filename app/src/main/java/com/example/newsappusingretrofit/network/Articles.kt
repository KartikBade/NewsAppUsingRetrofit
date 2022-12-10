package com.example.newsappusingretrofit.network

import com.squareup.moshi.Json

data class Articles (
    @Json(name = "articles")
    val articles: List<News>
        )