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

enum class Status { DONE, ERROR, LOADING }

class NewsViewModel: ViewModel() {

    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> = _news

    private val _newsArticle = MutableLiveData<News>()
    val newsArticle: LiveData<News> = _newsArticle

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> = _status

    fun getNewsFeed(searchQuery: String) {
        _news.value = listOf()
        _status.value = Status.LOADING
        viewModelScope.launch {
            try {
                _news.value = NewsApi.retrofitService.getNews(searchQuery).articles
                if (_news.value!!.isEmpty()) {
                    _status.value = Status.ERROR
                } else {
                    _status.value = Status.DONE
                }
            } catch (e: java.lang.Exception) {
                _news.value = listOf()
                _status.value = Status.ERROR
                Log.e(TAG, "getNewsFeed: $e")
            }
        }
    }

    fun onNewsClicked(newsArticle: News) {
        _newsArticle.value = newsArticle
    }
}