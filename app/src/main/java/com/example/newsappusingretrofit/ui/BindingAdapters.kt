package com.example.newsappusingretrofit.ui

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsappusingretrofit.R
import com.example.newsappusingretrofit.network.News

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {

    if (imgUrl.isNullOrEmpty()) {
        imageView.setBackgroundResource(R.drawable.ic_launcher_background)
    }

    imgUrl?.let {
        val uri = imgUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(uri)
    }
}

@BindingAdapter("listData")
fun bindData(recyclerView: RecyclerView, data: List<News>?) {
    val adapter = recyclerView.adapter as NewsFeedAdapter
    adapter.submitList(data)
}