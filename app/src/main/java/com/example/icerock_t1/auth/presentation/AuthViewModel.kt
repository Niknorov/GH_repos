package com.example.icerock_t1.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.auth.domain.PerformAuthUseCase
import com.example.icerock_t1.repo.presentation.RepoUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class AuthViewModel(
    private val performAuthUseCase: PerformAuthUseCase,
) : ViewModel() {

    private val _installationsLiveData = MutableLiveData<AuthState>()
    val installationsLiveData: LiveData<AuthState> = _installationsLiveData


    fun launchAuth(user: String, token: String) {

        if (token.isNotBlank()) {

            viewModelScope.launch {

                try {
                    withContext(Dispatchers.IO) {
                        performAuthUseCase(user, token)
                        _installationsLiveData.postValue(AuthState.Ok)

                    }
                } catch (unknownHostException: UnknownHostException) {

                    _installationsLiveData.postValue(AuthState.ErrorNetwork)
                } catch (socketTimeoutException: SocketTimeoutException) {

                    _installationsLiveData.postValue(AuthState.ErrorNetwork)
                } catch (httpException: HttpException) {

                    if (httpException.code() == 304) {
                        _installationsLiveData.postValue(AuthState.HttpException)
                    } else if (httpException.code() == 401) {
                        _installationsLiveData.postValue(AuthState.UserOrTokenError)
                    } else if (httpException.code() == 403) {
                        _installationsLiveData.postValue(AuthState.HttpException)
                    } else if (httpException.code() == 404) {
                        _installationsLiveData.postValue(AuthState.HttpException)
                    }
                }
            }


        }
    }
}

