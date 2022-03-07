package com.example.icerock_t1.detail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.icerock_t1.R
import com.example.icerock_t1.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private val args by navArgs<DetailFragmentArgs>()
    private val detailViewModel: DetailViewModel by viewModel()
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
                    adapter.items = it.detail
                }
                is DetailUiState.ErrorNetwork -> {

                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                }
                is DetailUiState.HttpError -> {
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                }
            }
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