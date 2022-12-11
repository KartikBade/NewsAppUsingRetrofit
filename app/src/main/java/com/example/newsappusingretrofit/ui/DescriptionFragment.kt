package com.example.newsappusingretrofit.ui

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.fragment.app.activityViewModels
import com.example.newsappusingretrofit.MainActivity
import com.example.newsappusingretrofit.NewsViewModel
import com.example.newsappusingretrofit.databinding.FragmentDescriptionBinding

private const val TAG = "DescriptionFragment"

class DescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDescriptionBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val viewModel: NewsViewModel by activityViewModels()
        binding.viewModel = viewModel

        binding.fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(viewModel.newsArticle.value?.newsLink)
            binding.root.context.startActivity(intent)
        }

        return binding.root
    }
}