package com.example.icerock_t1.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.auth.domain.PerformAuthUseCase
import kotlinx.coroutines.launch

class AuthViewModel(
    private val performAuthUseCase: PerformAuthUseCase,
) : ViewModel() {

    private val _installationsLiveData = MutableLiveData<AuthState>()
    val installationsLiveData: LiveData<AuthState> = _installationsLiveData


    fun launchAuth(user: String, token: String) {

        if (token.isNotBlank()) {

            viewModelScope.launch {

                performAuthUseCase(user, token)
                _installationsLiveData.postValue(AuthState.OK)


            }
        }
    }

}