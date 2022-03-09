package com.example.icerock_t1.user.di

import com.example.icerock_t1.core.di.NetworkModule
import com.example.icerock_t1.user.data.UserLocalDataSource
import com.example.icerock_t1.user.data.UserRepositoryImpl
import com.example.icerock_t1.user.domain.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class UserModule {

    @Singleton
    @Provides
    fun provideUserRepository(userLocalDataSource: UserLocalDataSource): UserRepository {
        return UserRepositoryImpl(userLocalDataSource)
    }

}