package com.example.android3lesson6dz.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android3lesson6dz.R
import com.example.android3lesson6dz.databinding.FragmentNewsBinding
import com.example.android3lesson6dz.ui.adapters.NewsAdapter

class NewsFragment : Fragment() {

    private val viewModel: NewsViewModel by viewModels()

    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        adapter = NewsAdapter()

//        binding.recyclerView.adapter = adapter
//        viewModel.newsLiveData.observe(viewLifecycleOwner) { articles ->
//            adapter.submitList(articles)
//        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.refresh()
    }
}