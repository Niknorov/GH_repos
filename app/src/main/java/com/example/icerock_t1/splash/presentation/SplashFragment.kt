package com.example.icerock_t1.splash.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.icerock_t1.R
import com.example.icerock_t1.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {


    private lateinit var binding: FragmentSplashBinding
    private val splashViewModel: SplashViewModel by viewModels()

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