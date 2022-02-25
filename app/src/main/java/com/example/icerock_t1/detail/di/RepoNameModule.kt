package com.example.icerock_t1.detail.di

import com.example.icerock_t1.detail.data.RepoNameDataSource
import com.example.icerock_t1.detail.data.RepoNameRepositoryImpl
import com.example.icerock_t1.detail.domain.RepoNameRepository
import org.koin.dsl.module

val repoNameModule = module {
    single { RepoNameDataSource(get()) }
    single<RepoNameRepository> { return@single RepoNameRepositoryImpl(get()) }
}