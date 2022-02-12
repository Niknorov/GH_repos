package com.example.icerock_t1.auth.data

import com.example.icerock_t1.auth.data.AuthApi

class RepositoriesRemoteDataSource(
    private val authApi: AuthApi
) {

    suspend fun getRepositories(token: String, id: Int) {

        authApi.getRepos(token, id)
    }
}