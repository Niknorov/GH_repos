package com.example.icerock_t1.auth.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.icerock_t1.R
import com.example.icerock_t1.databinding.FragmentAuthBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private val viewModel: AuthViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAuthBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.installationsLiveData.observe(viewLifecycleOwner) {

        }
        val user = binding.user.text
        val token = binding.token.text

        binding.signIn.setOnClickListener {
            viewModel.launchAuth(user = user.toString(), token = token.toString())
        }
        binding.signIn.setOnClickListener {
            findNavController().navigate(
                R.id.action_authFragment_to_repoFragment
            )
        }
    }
}