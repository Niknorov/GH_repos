package com.example.icerock_t1.detail.di

import com.example.icerock_t1.detail.data.ReadmeApi
import com.example.icerock_t1.detail.data.ReadmeRemoteDataSource
import com.example.icerock_t1.detail.data.ReadmeRepositoryImpl
import com.example.icerock_t1.detail.domain.GetReadmeUseCase
import com.example.icerock_t1.detail.domain.ReadmeRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val readmeModule = module {
    single { createReadmeApi(get()) }
    single { ReadmeRemoteDataSource(get()) }
    single<ReadmeRepository> { return@single ReadmeRepositoryImpl(get()) }
    single { GetReadmeUseCase(get(), get(), get()) }
}

fun createReadmeApi(retrofit: Retrofit): ReadmeApi {

    return retrofit.create(ReadmeApi::class.java)
}