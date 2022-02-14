package com.example.icerock_t1.auth.data

import com.example.icerock_t1.auth.data.repositoriesDto.RepositoriesDto

class RepositoriesRemoteDataSource(
    private val authApi: AuthApi
) {

    suspend fun getRepositories(token: String, id: Int): List<RepositoriesDto> {

        return authApi.getRepos(token, id)
    }
}