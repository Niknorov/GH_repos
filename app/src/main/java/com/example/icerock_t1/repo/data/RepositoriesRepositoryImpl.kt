package com.example.icerock_t1.repo.data

import com.example.icerock_t1.repo.domain.RepositoriesRepository
import com.example.icerock_t1.repo.domain.RepositoryModel

class RepositoriesRepositoryImpl(
    private val repositoryRemoteDataSource: RepositoryRemoteDataSource,
    private val repositoryConverter: RepositoryConverter
) : RepositoriesRepository {

    override suspend fun getRepositories(userName: String): List<RepositoryModel> {

        return repositoryRemoteDataSource.getRepositories(userName = userName).map {
            repositoryConverter.convert(it)
        }
    }

    override suspend fun getRepository(userName: String, repoName: String): RepositoryModel {

        val repositoryDto = repositoryRemoteDataSource.getRepository(userName, repoName)
        return repositoryConverter.convert(repositoryDto)
    }
}