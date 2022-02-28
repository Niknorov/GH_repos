package com.example.icerock_t1.repo.data

import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoriesApi {

    @GET(value = "/users/{username}/repos")
    suspend fun getRepositories(
        @Path("username") userName: String,
    ): List<RepositoryDto>

    @GET(value = "/repos/{owner}/{repo}")
    suspend fun getRepository(
        @Path("owner") userName: String,
        @Path("repo") repoName: String
    ): RepositoryDto
}