package com.example.icerock_t1.repo.data

class RepositoryRemoteDataSource(
    private val repositoriesApi: RepositoriesApi
) {

    suspend fun getRepositories(userName: String): List<RepositoryDto> {

        return repositoriesApi.getRepositories(userName = userName)
    }
}