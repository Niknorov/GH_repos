package com.example.icerock_t1.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.icerock_t1.splash.domain.DetermineUserAuthorizedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val determineUserAuthorizedUseCase: DetermineUserAuthorizedUseCase
) : ViewModel() {


    private val _splashAction: Channel<SplashAction> = Channel(Channel.BUFFERED)
    val splashAction: Flow<SplashAction> = _splashAction.receiveAsFlow()

    init {
        viewModelScope.launch { startTransition() }
    }

   private suspend fun startTransition() {
        if (determineUserAuthorizedUseCase()) {
            _splashAction.send(SplashAction.GoToRepos)
        } else {
            _splashAction.send(SplashAction.GoToLogin)
        }
    }

}