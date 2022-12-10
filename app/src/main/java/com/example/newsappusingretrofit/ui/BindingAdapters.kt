package com.example.newsappusingretrofit.ui

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String) {
    val uri = imgUrl.toUri().buildUpon().scheme("https").build()
    imageView.load(uri)
}