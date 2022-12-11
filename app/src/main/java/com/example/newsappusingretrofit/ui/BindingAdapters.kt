package com.example.newsappusingretrofit.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsappusingretrofit.R
import com.example.newsappusingretrofit.Status
import com.example.newsappusingretrofit.network.News

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {

    if (imgUrl.isNullOrEmpty()) {
        imageView.setBackgroundResource(R.drawable.ic_launcher_background)
    }

    imgUrl?.let {
        val uri = imgUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(uri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_launcher_background)
        }
    }
}

@BindingAdapter("listData")
fun bindData(recyclerView: RecyclerView, data: List<News>?) {
    val adapter = recyclerView.adapter as NewsFeedAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageStatus")
fun bindMessageImage(imageView: ImageView, status: Status?) {
    status?.let {
        if (status == Status.LOADING) {
            imageView.visibility = ImageView.VISIBLE
        } else {
            imageView.visibility = ImageView.GONE
        }
    }
}

@BindingAdapter("textStatus")
fun bindMessageText(textView: TextView, status: Status?) {
    status?.let {
        if (status == Status.ERROR) {
            textView.text = "No Results Found"
            textView.visibility = TextView.VISIBLE
        } else {
            textView.visibility = TextView.GONE
        }
    }
}