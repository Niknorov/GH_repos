package com.example.icerock_t1.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.auth.domain.PerformAuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val performAuthUseCase: PerformAuthUseCase,
) : ViewModel() {

    private val _installationsLiveData = MutableLiveData<AuthUiState>()
    val installationsLiveData: LiveData<AuthUiState> = _installationsLiveData

    val _userNameLiveData = MutableLiveData<AuthUiState>()
    val _tokenLiveData = MutableLiveData<AuthUiState>()


    fun launchAuth(user: String, token: String) {

        if (token.isNotBlank() && user.isNotBlank()) {

            viewModelScope.launch {

                try {
                    withContext(Dispatchers.IO) {
                        performAuthUseCase(user, token)
                        _installationsLiveData.postValue(AuthUiState.Ok)

                    }
                } catch (unknownHostException: UnknownHostException) {

                    _installationsLiveData.postValue(AuthUiState.ErrorNetwork)
                } catch (socketTimeoutException: SocketTimeoutException) {

                    _installationsLiveData.postValue(AuthUiState.ErrorNetwork)
                } catch (httpException: HttpException) {

                    if (httpException.code() == 304) {
                        _installationsLiveData.postValue(AuthUiState.HttpException)
                    } else if (httpException.code() == 401) {
                        _installationsLiveData.postValue(AuthUiState.UserOrTokenError)
                    } else if (httpException.code() == 403) {
                        _installationsLiveData.postValue(AuthUiState.HttpException)
                    } else if (httpException.code() == 404) {
                        _installationsLiveData.postValue(AuthUiState.HttpException)
                    }
                }
            }

        } else {
            if (token.isBlank()) {
                _tokenLiveData.postValue(AuthUiState.TokenError)
            }
            if (user.isBlank()) {
                _userNameLiveData.postValue(AuthUiState.UserNameError)
            }
        }
    }


}

