package com.example.icerock_t1.repo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.icerock_t1.R
import com.example.icerock_t1.databinding.FragmentRepoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoFragment : Fragment() {

    private val repositoriesViewModel: RepositoriesViewModel by viewModels()
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

        repositoriesViewModel.repositoriesLiveData.observe(viewLifecycleOwner) { it ->

            when (it) {
                is RepoUiState.Success -> {
                    val adapter = RepositoryRecyclerAdapter(it.repositories)
                    binding.reposRecyclerView.adapter = adapter


                    adapter.onItemClick = {
                        val repoName = it.name
                        val action =
                            RepoFragmentDirections.actionRepoFragmentToDetailFragment(repoName)
                        findNavController().navigate(action)
                    }
                    binding.reposRecyclerView.visibility = View.VISIBLE
                    binding.connectionImage.visibility = View.GONE
                    binding.connectionErrorTV.visibility = View.GONE
                    binding.checkConnectionTV.visibility = View.GONE
                    binding.retry.visibility = View.GONE
                    binding.emptyImage.visibility = View.GONE
                    binding.emptyTV.visibility = View.GONE
                    binding.noRepositoriesTV.visibility = View.GONE
                    binding.refresh.visibility = View.GONE
                }
                is RepoUiState.ErrorNetwork -> {
                    Toast.makeText(context, "Error network", Toast.LENGTH_SHORT).show()
                    binding.reposRecyclerView.visibility = View.GONE
                    binding.connectionImage.visibility = View.VISIBLE
                    binding.connectionErrorTV.visibility = View.VISIBLE
                    binding.checkConnectionTV.visibility = View.VISIBLE
                    binding.retry.visibility = View.VISIBLE
                    binding.emptyImage.visibility = View.GONE
                    binding.emptyTV.visibility = View.GONE
                    binding.noRepositoriesTV.visibility = View.GONE
                    binding.refresh.visibility = View.GONE
                }
                is RepoUiState.HttpException -> {
                    binding.reposRecyclerView.visibility = View.GONE
                    binding.connectionImage.visibility = View.VISIBLE
                    binding.connectionErrorTV.visibility = View.VISIBLE
                    binding.checkConnectionTV.visibility = View.VISIBLE
                    binding.retry.visibility = View.VISIBLE
                    binding.emptyImage.visibility = View.GONE
                    binding.emptyTV.visibility = View.GONE
                    binding.noRepositoriesTV.visibility = View.GONE
                    binding.refresh.visibility = View.GONE
                }
                is RepoUiState.EmptyRepos -> {
                    binding.reposRecyclerView.visibility = View.GONE
                    binding.emptyImage.visibility = View.VISIBLE
                    binding.emptyTV.visibility = View.VISIBLE
                    binding.noRepositoriesTV.visibility = View.VISIBLE
                    binding.refresh.visibility = View.VISIBLE
                    binding.connectionImage.visibility = View.GONE
                    binding.connectionErrorTV.visibility = View.GONE
                    binding.checkConnectionTV.visibility = View.GONE
                    binding.retry.visibility = View.GONE

                }
            }

        }
        repositoriesViewModel.getRepositories()

        binding.retry.setOnClickListener {
            repositoriesViewModel.getRepositories()
        }

        binding.refresh.setOnClickListener {
            repositoriesViewModel.getRepositories()
        }

        binding.toolbar.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.toolbar_Button -> {
            repositoriesViewModel.onExit()
            findNavController().navigate(R.id.action_repoFragment_to_authFragment)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
