package com.example.newsappusingretrofit.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://newsapi.org/v2/"
private const val API_KEY = "dba4f8a86abe4b0d9c8c83fbf065db62"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface NewsApiService {
    @GET("everything?sortBy=popularity")
    suspend fun getNews(
        @Query("q") keyword: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): Articles
}

object NewsApi {
    val retrofitService: NewsApiService by lazy {
        retrofit.create()
    }
}