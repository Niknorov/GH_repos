package com.example.icerock_t1.user.di

import com.example.icerock_t1.user.data.UserLocalDataSource
import com.example.icerock_t1.user.data.UserRepositoryImpl
import com.example.icerock_t1.user.domain.UserRepository
import org.koin.dsl.module

val userModule = module {
    single { UserLocalDataSource(get()) }
    single<UserRepository> { return@single UserRepositoryImpl(get()) }
}