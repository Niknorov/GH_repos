package com.example.icerock_t1.detail.di

import com.example.icerock_t1.core.di.NetworkModule
import com.example.icerock_t1.detail.data.DetailApi
import com.example.icerock_t1.detail.data.ReadmeRemoteDataSource
import com.example.icerock_t1.detail.data.ReadmeRepositoryImpl
import com.example.icerock_t1.detail.domain.ReadmeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class ReadmeModule {

    @Singleton
    @Provides
    fun createReadmeApi(retrofit: Retrofit): DetailApi {

        return retrofit.create(DetailApi::class.java)
    }

    @Singleton
    @Provides
    fun provideReadmeRepository(readmeRemoteDataSource: ReadmeRemoteDataSource): ReadmeRepository {
        return ReadmeRepositoryImpl(readmeRemoteDataSource)
    }
}

