package com.example.icerock_t1.splash.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.icerock_t1.R
import com.example.icerock_t1.databinding.FragmentDetailBinding
import com.example.icerock_t1.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashFragment : Fragment() {


    private lateinit var binding: FragmentSplashBinding
    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashViewModel.startTransition()

        splashViewModel.splashLiveData.observe(
            viewLifecycleOwner
        ) {
            when (it) {
                SplashState.GO_TO_LOGIN -> {
                    findNavController().navigate(R.id.action_splashFragment_to_authFragment)
                }
                SplashState.GO_TO_REPOS -> {
                    findNavController().navigate(R.id.action_splashFragment_to_repoFragment)
                }
            }
        }
    }
}