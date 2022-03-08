package com.example.icerock_t1.detail.presentation

import android.graphics.Color
import android.text.method.LinkMovementMethod
import androidx.recyclerview.widget.RecyclerView
import com.crescentflare.simplemarkdownparser.conversion.SimpleMarkdownConverter
import com.example.icerock_t1.databinding.DetailReadmeRecyclerviewItemBinding
import com.example.icerock_t1.databinding.DetailStatsRecyclerviewItemBinding

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

            val markdownReadme = readmeItem.content
            binding.textview.text = SimpleMarkdownConverter.toSpannable(markdownReadme)
            binding.textview.setTextColor(Color.WHITE)


        } else {
            binding.textview.text = "ReadMe отстутствует"
            binding.textview.setTextColor(Color.WHITE)
        }
    }
}
