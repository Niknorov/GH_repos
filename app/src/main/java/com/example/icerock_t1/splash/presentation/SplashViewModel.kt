package com.example.icerock_t1.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.icerock_t1.auth.domain.PerformAuthUseCase
import com.example.icerock_t1.splash.domain.DetermineUserAuthorizedUseCase

class SplashViewModel(
    private val determineUserAuthorizedUseCase: DetermineUserAuthorizedUseCase
) : ViewModel() {

    private val _splashLiveData = MutableLiveData<SplashState>()
    val splashLiveData: LiveData<SplashState> = _splashLiveData

    fun startTransition() {


        if (determineUserAuthorizedUseCase()) {
            _splashLiveData.postValue(SplashState.GO_TO_REPOS)
        } else {
            _splashLiveData.postValue(SplashState.GO_TO_LOGIN)
        }

    }

}