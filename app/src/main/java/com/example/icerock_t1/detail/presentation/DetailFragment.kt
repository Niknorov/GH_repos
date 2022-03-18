package com.example.icerock_t1.detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.icerock_t1.R
import com.example.icerock_t1.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val args by navArgs<DetailFragmentArgs>()
    private val detailViewModel: DetailViewModel by viewModels()
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailRecyclerView.layoutManager = LinearLayoutManager(context)

        binding.toolbar.title = args.repositoryName

        detailViewModel.detailLiveData.observe(viewLifecycleOwner) {


            val adapter = DetailRecyclerAdapter()
            binding.detailRecyclerView.adapter = adapter

            when (it) {
                is DetailUiState.Success -> {
                    binding.detailRecyclerView.visibility = View.VISIBLE
                    binding.connectionImage.visibility = View.GONE
                    binding.connectionErrorTV.visibility = View.GONE
                    binding.checkConnectionTV.visibility = View.GONE
                    binding.retry.visibility = View.GONE
                    adapter.items = it.detail
                }
                is DetailUiState.ErrorNetwork -> {
                    binding.detailRecyclerView.visibility = View.GONE
                    binding.connectionImage.visibility = View.VISIBLE
                    binding.connectionErrorTV.visibility = View.VISIBLE
                    binding.checkConnectionTV.visibility = View.VISIBLE
                    binding.retry.visibility = View.VISIBLE

                }
                is DetailUiState.HttpError -> {
                    binding.detailRecyclerView.visibility = View.GONE
                    binding.connectionImage.visibility = View.VISIBLE
                    binding.connectionErrorTV.visibility = View.VISIBLE
                    binding.checkConnectionTV.visibility = View.VISIBLE
                    binding.retry.visibility = View.VISIBLE
                }
                is DetailUiState.ReadmeErrorNetwork -> {
                    binding.detailRecyclerView.visibility = View.VISIBLE
                    binding.connectionImage.visibility = View.VISIBLE
                    binding.connectionErrorTV.visibility = View.VISIBLE
                    binding.checkConnectionTV.visibility = View.VISIBLE
                    binding.retry.visibility = View.VISIBLE

                }
                is DetailUiState.ReadmeHttpError -> {
                    binding.detailRecyclerView.visibility = View.VISIBLE
                    binding.connectionImage.visibility = View.VISIBLE
                    binding.connectionErrorTV.visibility = View.VISIBLE
                    binding.checkConnectionTV.visibility = View.VISIBLE
                    binding.retry.visibility = View.VISIBLE

                }
                is DetailUiState.Progress -> {

                }
            }
        }
        binding.retry.setOnClickListener {
            detailViewModel.getDetail(args.repositoryName)
        }
        detailViewModel.getDetail(args.repositoryName)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_repoFragment)
        }



        binding.toolbar.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.toolbar_Button -> {
            detailViewModel.onExit()
            findNavController().navigate(R.id.action_detailFragment_to_authFragment)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}