package com.example.newsappusingretrofit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.newsappusingretrofit.NewsViewModel
import com.example.newsappusingretrofit.R
import com.example.newsappusingretrofit.databinding.FragmentNewsFeedBinding
import com.example.newsappusingretrofit.network.News
import com.example.newsappusingretrofit.network.NewsApi
import kotlinx.coroutines.launch

class NewsFeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNewsFeedBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val viewModel: NewsViewModel by activityViewModels()
        binding.viewModel = viewModel

        binding.newsFeedRecyclerView.adapter = NewsFeedAdapter(NewsClickListener {
            viewModel.onNewsClicked(it)
            findNavController().navigate(R.id.action_newsFeedFragment_to_descriptionFragment)
        })

        binding.searchBarImage.setOnClickListener {
            val searchQuery = binding.searchBarInput.text?.trim()
            if (searchQuery.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a search word.", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.getNewsFeed(searchQuery.toString())
            }
        }

        return binding.root
    }
}