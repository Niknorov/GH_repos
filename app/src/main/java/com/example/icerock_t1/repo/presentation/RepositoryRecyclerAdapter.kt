package com.example.icerock_t1.repo.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.icerock_t1.databinding.RepoRecyclerviewIemBinding
import com.example.icerock_t1.repo.domain.RepositoryModel

class RepositoryRecyclerAdapter(private val repositories: List<RepositoryModel>) :
    RecyclerView.Adapter<RepositoryRecyclerAdapter.RepositoryViewHolder>() {

    var onItemClick: ((RepositoryModel) -> Unit)? = null

    inner class RepositoryViewHolder(private val binding: RepoRecyclerviewIemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repositoryModel: RepositoryModel) {

            binding.title.text = repositoryModel.name
            binding.body.text = repositoryModel.description
            binding.language.text = repositoryModel.language

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {

        val binding =
            RepoRecyclerviewIemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {

        val repositoryModel: RepositoryModel = repositories[position]
        holder.bind(repositoryModel)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(repositories[position])
        }
    }

    override fun getItemCount() = repositories.size
}