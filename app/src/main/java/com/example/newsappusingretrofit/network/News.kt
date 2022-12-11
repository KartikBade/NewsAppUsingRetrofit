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
    val imageLink: String? = "https://imgs.search.brave.com/JEJxsFyrQQQw_ZEzKd7z5rm1bm8Kjqi7WWC9VvPvkAk/rs:fit:800:500:1/g:ce/aHR0cHM6Ly9kYWIx/bm1zbHZ2bnRwLmNs/b3VkZnJvbnQubmV0/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDE1/LzEyLzE0NTA5NzMw/NDZ3b3JkcHJlc3Mt/ZXJyb3JzLnBuZw",
    @Json(name = "content")
    val content: String
        )