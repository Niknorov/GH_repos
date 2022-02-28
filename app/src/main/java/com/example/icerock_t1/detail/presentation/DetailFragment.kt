package com.example.icerock_t1.detail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.icerock_t1.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private val args by navArgs<DetailFragmentArgs>()
    private val readmeViewModel: ReadmeViewModel by viewModel()
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

        binding.toolbar.title = args.repositoryName

        binding.detailRecyclerView.layoutManager = LinearLayoutManager(context)

        readmeViewModel.readmeLiveData.observe(viewLifecycleOwner) {

            val adapter = DetailRecyclerAdapter(it)
            binding.detailRecyclerView.adapter = adapter
        }

        readmeViewModel.getDetail(repoName = args.repositoryName)
    }
}