package com.example.icerock_t1.auth.di

import com.example.icerock_t1.auth.data.*
import com.example.icerock_t1.auth.domain.AuthRepository
import com.example.icerock_t1.auth.domain.PerformAuthUseCase
import com.example.icerock_t1.auth.presentation.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val authModule = module {
    single { createAuthApi(get()) }
    single { AuthRemoteDataSource(get()) }
    single<AuthRepository> { return@single AuthRepositoryImpl(get()) }
    single { PerformAuthUseCase(get(), get()) }
    viewModel { AuthViewModel(get()) }
}

fun createAuthApi(retrofit: Retrofit): AuthApi {

    return retrofit.create(AuthApi::class.java)
}


