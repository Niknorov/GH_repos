package com.example.icerock_t1.detail.presentation

import androidx.recyclerview.widget.RecyclerView
import com.example.icerock_t1.databinding.DetailReadmeRecyclerviewItemBinding
import com.example.icerock_t1.databinding.DetailStatsRecyclerviewItemBinding
import com.example.icerock_t1.detail.domain.ReadmeModel
import com.example.icerock_t1.repo.domain.RepositoryModel

class StatsViewHolder(
    private val binding: DetailStatsRecyclerviewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(statsItem: RepositoryDetailItem.StatsItem) {

        binding.stars.text = statsItem.stargazersCount.toString()
        binding.forks.text = statsItem.forksCount.toString()
        binding.watchers.text = statsItem.watchersCount.toString()
        binding.license.text = statsItem.license
        binding.link.text = statsItem.url

    }
}

class ReadmeViewHolder(
    private val binding: DetailReadmeRecyclerviewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(readmeItem: RepositoryDetailItem.ReadmeItem) {
        if (readmeItem.content.isNotBlank()) {
            binding.readme.text = readmeItem.content
        } else {
            binding.readme.text = "ReadMe отстутствует"
        }
    }
}
