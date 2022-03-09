package com.example.icerock_t1.repo.data

import javax.inject.Inject

class RepositoryRemoteDataSource @Inject constructor(
    private val repositoriesApi: RepositoriesApi
) {

    suspend fun getRepositories(userName: String): List<RepositoryDto> {

        return repositoriesApi.getRepositories(userName = userName)
    }

    suspend fun getRepository(userName: String, repoName: String): RepositoryDto {

        return repositoriesApi.getRepository(userName = userName, repoName = repoName)
    }


}