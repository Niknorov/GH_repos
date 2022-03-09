package com.example.icerock_t1.auth.di

import com.example.icerock_t1.auth.data.AuthApi
import com.example.icerock_t1.auth.data.AuthRemoteDataSource
import com.example.icerock_t1.auth.data.AuthRepositoryImpl
import com.example.icerock_t1.auth.domain.AuthRepository
import com.example.icerock_t1.core.di.NetworkModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class AuthModule {

    @Singleton
    @Provides
    fun createAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Singleton
    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
        return AuthRepositoryImpl(authRemoteDataSource)
    }
}




