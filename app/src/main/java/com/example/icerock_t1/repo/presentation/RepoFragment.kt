package com.example.icerock_t1.repo.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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

        repositoriesViewModel.repositoriesLiveData.observe(viewLifecycleOwner) { it ->

            when (it) {
                is RepoUiState.Success -> {
                    val adapter = RepositoryRecyclerAdapter(it.repositories)
                    binding.reposRecyclerView.adapter = adapter


                    adapter.onItemClick = {
                        Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
                        val repoName = it.name
                        val action =
                            RepoFragmentDirections.actionRepoFragmentToDetailFragment(repoName)
                        findNavController().navigate(action)
                    }
                }
                is RepoUiState.ErrorNetwork -> {
                    Toast.makeText(context, "Error network", Toast.LENGTH_SHORT).show()
                }
                is RepoUiState.HttpException -> {
                    Toast.makeText(context, "404", Toast.LENGTH_SHORT).show()
                }
            }

        }
        repositoriesViewModel.getRepositories()


        binding.toolbar.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.toolbar_Button -> {
            findNavController().navigate(R.id.action_repoFragment_to_authFragment)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
    }
