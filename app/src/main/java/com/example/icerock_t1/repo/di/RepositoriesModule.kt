package com.example.icerock_t1.repo.di

import com.example.icerock_t1.core.di.NetworkModule
import com.example.icerock_t1.repo.data.RepositoriesApi
import com.example.icerock_t1.repo.data.RepositoriesRepositoryImpl
import com.example.icerock_t1.repo.data.RepositoryConverter
import com.example.icerock_t1.repo.data.RepositoryRemoteDataSource
import com.example.icerock_t1.repo.domain.RepositoriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Singleton
    @Provides
    fun createRepositoriesApi(retrofit: Retrofit): RepositoriesApi {
        return retrofit.create(RepositoriesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepositoriesRepository(
        repositoryRemoteDataSource: RepositoryRemoteDataSource,
        repositoryConverter: RepositoryConverter
    ): RepositoriesRepository {
        return RepositoriesRepositoryImpl(repositoryRemoteDataSource, repositoryConverter)
    }
}

