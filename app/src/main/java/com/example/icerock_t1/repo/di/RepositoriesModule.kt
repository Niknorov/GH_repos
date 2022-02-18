package com.example.icerock_t1.repo.di

import com.example.icerock_t1.repo.data.RepositoriesApi
import com.example.icerock_t1.repo.data.RepositoriesRepositoryImpl
import com.example.icerock_t1.repo.data.RepositoryRemoteDataSource
import com.example.icerock_t1.repo.domain.GetRepositoriesUseCase
import com.example.icerock_t1.repo.domain.RepositoriesRepository
import com.example.icerock_t1.repo.presenatation.RepositoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val repositoriesModule = module {
    single { createRepositoriesApi(get()) }
    single { RepositoryRemoteDataSource(get()) }
    single<RepositoriesRepository> { return@single RepositoriesRepositoryImpl(get()) }
    single { GetRepositoriesUseCase(get()) }
    viewModel { RepositoriesViewModel(get()) }
}

fun createRepositoriesApi(retrofit: Retrofit): RepositoriesApi {
    return retrofit.create(RepositoriesApi::class.java)
}