package com.example.newsappusingretrofit.network

import com.squareup.moshi.Json

data class News (
    @Json(name = "title")
    val title: String,
    @Json(name = "source")
    val source: Source,
    @Json(name = "author")
    val author: String? = "Unknown Author",
    @Json(name = "description")
    val description: String,
    @Json(name = "url")
    val newsLink: String,
    @Json(name = "urlToImage")
    val imageLink: String,
    @Json(name = "content")
    val content: String
        )