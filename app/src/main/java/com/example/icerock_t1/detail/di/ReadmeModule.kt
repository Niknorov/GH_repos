package com.example.icerock_t1.detail.di

import com.example.icerock_t1.detail.data.DetailApi
import com.example.icerock_t1.detail.data.ReadmeRemoteDataSource
import com.example.icerock_t1.detail.data.ReadmeRepositoryImpl
import com.example.icerock_t1.detail.domain.GetLicenseUseCase
import com.example.icerock_t1.detail.domain.GetReadmeUseCase
import com.example.icerock_t1.detail.domain.GetRepositoryUseCase
import com.example.icerock_t1.detail.domain.ReadmeRepository
import com.example.icerock_t1.detail.presentation.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val readmeModule = module {
    single { createReadmeApi(get()) }
    single { ReadmeRemoteDataSource(get()) }
    single<ReadmeRepository> { return@single ReadmeRepositoryImpl(get()) }
    single { GetReadmeUseCase(get(), get()) }
    single { GetRepositoryUseCase(get(), get()) }
    single { GetLicenseUseCase(get(), get()) }
    viewModel { DetailViewModel(get(), get(), get()) }
}

fun createReadmeApi(retrofit: Retrofit): DetailApi {

    return retrofit.create(DetailApi::class.java)
}