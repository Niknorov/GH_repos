package com.example.icerock_t1.auth.presentation

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.icerock_t1.R
import com.example.icerock_t1.databinding.FragmentAuthBinding
import com.github.razir.progressbutton.bindProgressButton
import com.github.razir.progressbutton.hideProgress
import com.github.razir.progressbutton.showProgress
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private val viewModel: AuthViewModel by viewModels()

    private fun requestAuth() {
        viewModel._tokenLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is AuthUiState.TokenError -> {
                    binding.token.error = context?.getString(R.string.invalid_values)
                }
            }
        }
        viewModel._userNameLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is AuthUiState.UserNameError -> {
                    binding.user.error = context?.getString(R.string.invalid_values)
                }
            }
        }
        val user = binding.user.editText?.text
        val token = binding.token.editText?.text
        binding.signIn.showProgress {
            progressColor = Color.WHITE
        }
        viewModel.launchAuth(user = user.toString(), token = token.toString())

        binding.signIn.hideProgress(R.string.sign_in)
    }



    private fun View.hideKeyboard() {
        val inputManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

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
                is AuthUiState.Ok -> {
                    findNavController().navigate(
                        R.id.action_authFragment_to_repoFragment
                    )
                }
                is AuthUiState.HttpException -> {
                    Toast.makeText(context, "Error network", Toast.LENGTH_SHORT).show()
                }
                is AuthUiState.ErrorNetwork -> {
                    Toast.makeText(context, "Error network", Toast.LENGTH_SHORT).show()
                }
                is AuthUiState.Forbidden -> {
                    Toast.makeText(context, "Forbidden", Toast.LENGTH_SHORT).show()
                }
                is AuthUiState.NotModified -> {
                    Toast.makeText(context, "Not Modified", Toast.LENGTH_SHORT).show()
                }
                is AuthUiState.Unauthorized -> {
                    Toast.makeText(context, "Unauthorized", Toast.LENGTH_SHORT).show()
                }
                is AuthUiState.UserOrTokenError -> {
                    Toast.makeText(context, "Invalid user or token", Toast.LENGTH_SHORT).show()
                }
            }
            binding.signIn.hideProgress(R.string.sign_in)
        }

        bindProgressButton(binding.signIn)
        binding.signIn.setOnClickListener {
            requestAuth()
            it.hideKeyboard()
        }

        val userTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.user.error = null
            }

            override fun afterTextChanged(s: Editable?) = Unit

        }

        val tokenTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)= Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.token.error = null
            }

            override fun afterTextChanged(s: Editable?)=Unit

        }

        binding.tokenEditText.addTextChangedListener(tokenTextWatcher)
        binding.userNameEditText.addTextChangedListener(userTextWatcher)

    }
}