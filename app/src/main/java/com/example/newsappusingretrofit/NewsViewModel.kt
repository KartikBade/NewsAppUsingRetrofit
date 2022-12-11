package com.example.newsappusingretrofit

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappusingretrofit.network.News
import com.example.newsappusingretrofit.network.NewsApi
import com.example.newsappusingretrofit.ui.NewsFeedFragment
import kotlinx.coroutines.launch

private const val TAG = "NewsViewModel"

class NewsViewModel: ViewModel() {

    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> = _news

    private val _newsArticle = MutableLiveData<News>()
    val newsArticle: LiveData<News> = _newsArticle

    fun getNewsFeed(searchQuery: String) {
        viewModelScope.launch {
            _news.value = NewsApi.retrofitService.getNews(searchQuery).articles
        }
    }

    fun onNewsClicked(newsArticle: News) {
        _newsArticle.value = newsArticle
    }
}