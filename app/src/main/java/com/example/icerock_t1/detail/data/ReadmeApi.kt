package com.example.icerock_t1.detail.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ReadmeApi {

    @GET(value = "/repos/{owner}/{repo}/readme")
    suspend fun getReadme(
        @Path("owner") userName: String,
        @Path("repo") repoName: String
    ): List<ReadmeDto>
}