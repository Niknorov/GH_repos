package com.example.icerock_t1.splash.presentation

sealed interface SplashAction {

    object GoToLogin : SplashAction
    object GoToRepos : SplashAction
}