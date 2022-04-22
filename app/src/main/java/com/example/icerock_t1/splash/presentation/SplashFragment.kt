package com.example.icerock_t1.splash.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.icerock_t1.R
import com.example.icerock_t1.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment() {


    private lateinit var binding: FragmentSplashBinding
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fun handleSplashAction(action: SplashAction) {
            when (action) {
                SplashAction.GoToLogin -> {
                    findNavController().navigate(R.id.action_splashFragment_to_authFragment)
                }
                SplashAction.GoToRepos -> {
                    findNavController().navigate(R.id.action_splashFragment_to_repoFragment)
                }
            }
        }

        lifecycleScope.launch {
            splashViewModel.splashAction.collect { handleSplashAction(it) }
        }
    }
}