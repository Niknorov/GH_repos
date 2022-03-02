package com.example.icerock_t1.auth.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

            when (it) {
                is AuthState.Ok -> {

                }
                is AuthState.HttpException -> {
                    Toast.makeText(context, "Error network", Toast.LENGTH_SHORT).show()
                }
                is AuthState.ErrorNetwork -> {
                    Toast.makeText(context, "Error network", Toast.LENGTH_SHORT).show()
                }
                is AuthState.Forbidden -> {
                    Toast.makeText(context, "Forbidden", Toast.LENGTH_SHORT).show()
                }
                is AuthState.NotModified -> {
                    Toast.makeText(context, "Not Modified", Toast.LENGTH_SHORT).show()
                }
                is AuthState.Unauthorized -> {
                    Toast.makeText(context, "Unauthorized", Toast.LENGTH_SHORT).show()
                }
            }

        }


        binding.signIn.setOnClickListener {
            val user = binding.user.text
            val token = binding.token.text
            viewModel.launchAuth(user = user.toString(), token = token.toString())
            findNavController().navigate(
                R.id.action_authFragment_to_repoFragment
            )
        }
    }
}