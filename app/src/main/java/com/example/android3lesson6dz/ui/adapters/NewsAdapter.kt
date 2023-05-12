package com.example.android3lesson6dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android3lesson6dz.databinding.ItemNewsBinding
import com.example.android3lesson6dz.models.news.Source

class NewsAdapter : PagingDataAdapter<Source, NewsAdapter.NewsViewHolder>(diffUtil) {

    class NewsViewHolder(binding :ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Source?) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Source>() {
            override fun areItemsTheSame(
                oldItem: Source,
                newItem: Source
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Source,
                newItem: Source
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
