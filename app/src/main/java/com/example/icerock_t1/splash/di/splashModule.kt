package com.example.icerock_t1.splash.di

import com.example.icerock_t1.splash.domain.DetermineUserAuthorizedUseCase
import com.example.icerock_t1.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    single { DetermineUserAuthorizedUseCase(get()) }
    viewModel { SplashViewModel(get()) }
}