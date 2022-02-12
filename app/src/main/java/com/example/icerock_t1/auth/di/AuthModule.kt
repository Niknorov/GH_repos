package com.example.icerock_t1.auth.di

import com.example.icerock_t1.auth.data.AuthApi
import com.example.icerock_t1.auth.data.InstallationsRemoteDataSource
import com.example.icerock_t1.auth.data.RepositoriesRemoteDataSource
import org.koin.dsl.module
import retrofit2.Retrofit

val authModule = module {
    single { createAuthApi(get()) }
    single { InstallationsRemoteDataSource(get()) }
    single { RepositoriesRemoteDataSource(get()) }
}

fun createAuthApi(retrofit: Retrofit): AuthApi {

    return retrofit.create(AuthApi::class.java)
}


