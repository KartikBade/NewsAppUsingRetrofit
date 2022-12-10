package com.example.newsappusingretrofit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappusingretrofit.databinding.NewsItemBinding
import com.example.newsappusingretrofit.network.News

class NewsFeedAdapter: ListAdapter<News, NewsFeedAdapter.NewsFeedViewHolder>(DiffCalBack) {
    class NewsFeedViewHolder(private val binding: NewsItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.news = news
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFeedViewHolder {
        return NewsFeedViewHolder(NewsItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsFeedViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    companion object DiffCalBack: DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.newsLink == newItem.newsLink
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.title == newItem.title && oldItem.source == newItem.source && oldItem.imageLink == newItem.imageLink
        }

    }
}