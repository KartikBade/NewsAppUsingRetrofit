package com.example.newsappusingretrofit.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappusingretrofit.R
import com.example.newsappusingretrofit.databinding.NewsItemBinding
import com.example.newsappusingretrofit.network.News

class NewsFeedAdapter(private val clickListener: NewsClickListener): ListAdapter<News, NewsFeedAdapter.NewsFeedViewHolder>(DiffCalBack) {

    class NewsFeedViewHolder(private val binding: NewsItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News, clickListener: NewsClickListener) {
            binding.news = news
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFeedViewHolder {
        return NewsFeedViewHolder(NewsItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsFeedViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news, clickListener)
    }

    companion object DiffCalBack: DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.title == newItem.title && oldItem.source == newItem.source && oldItem.imageLink == newItem.imageLink
        }

    }
}

class NewsClickListener(val clickListener: (news: News) -> Unit) {
    fun onClick(news: News) = clickListener(news)
}