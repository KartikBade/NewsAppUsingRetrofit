package com.example.newsappusingretrofit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.newsappusingretrofit.databinding.FragmentNewsFeedBinding
import com.example.newsappusingretrofit.network.NewsApi
import kotlinx.coroutines.launch

class NewsFeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewsFeedBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.newsFeedRecyclerView.adapter = NewsFeedAdapter()
        val adapter = binding.newsFeedRecyclerView.adapter as NewsFeedAdapter
        lifecycleScope.launch {
            val data = NewsApi.retrofitService.getNews()
            adapter.submitList(data.articles)
        }
        return binding.root
    }
}