package com.example.icerock_t1.repo.presenatation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.icerock_t1.R
import com.example.icerock_t1.databinding.FragmentRepoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class RepoFragment : Fragment() {

    private val repositoriesViewModel: RepositoriesViewModel by viewModel()
    private lateinit var binding: FragmentRepoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRepoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reposRecyclerView.layoutManager = LinearLayoutManager(context)

        repositoriesViewModel.repositoriesLiveData.observe(viewLifecycleOwner) {

            val adapter = RepositoryRecyclerAdapter(it)
            binding.reposRecyclerView.adapter = adapter



            adapter.onItemClick = {
                Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
            }
        }
        repositoriesViewModel.getRepositories()
    }
}