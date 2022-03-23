package com.example.icerock_t1.detail.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.icerock_t1.databinding.DetailReadmeRecyclerviewItemBinding
import com.example.icerock_t1.databinding.DetailStatsRecyclerviewItemBinding

class DetailRecyclerAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private companion object {

        const val STATS_VIEW_TYPE = 0
        const val README_VIEW_TYPE = 1
    }

    var items: List<RepositoryDetailItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            STATS_VIEW_TYPE -> StatsViewHolder(
                DetailStatsRecyclerviewItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            README_VIEW_TYPE -> ReadmeViewHolder(
                DetailReadmeRecyclerviewItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            else -> throw IllegalArgumentException("Wrong view type: $viewType")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is StatsViewHolder -> holder.bind(items[position] as RepositoryDetailItem.StatsItem)
            is ReadmeViewHolder -> holder.bind(items[position] as RepositoryDetailItem.ReadmeItem)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int =
        if (items[position] is RepositoryDetailItem.StatsItem) {
            STATS_VIEW_TYPE
        } else {
            README_VIEW_TYPE
        }
}

