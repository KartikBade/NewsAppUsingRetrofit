package com.example.newsappusingretrofit.network

import com.squareup.moshi.Json

data class Source (
    @Json(name = "name")
    val source: String
        )