package com.example.icerock_t1.repo.domain

interface RepositoriesRepository {

    suspend fun getRepositories(userName: String): List<RepositoryModel>

    suspend fun getRepository(userName: String, repoName: String): RepositoryModel
}