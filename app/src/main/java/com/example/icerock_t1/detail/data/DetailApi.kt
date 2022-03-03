package com.example.icerock_t1.detail.data

import retrofit2.http.GET
import retrofit2.http.Path

interface DetailApi {

    @GET(value = "/repos/{owner}/{repo}/readme")
    suspend fun getReadme(
        @Path("owner") userName: String,
        @Path("repo") repoName: String
    ): ReadmeDto


    @GET (value = "/repos/{owner}/{repo}/license")
    suspend fun getLicense(
        @Path("owner") userName: String,
        @Path("repo") repoName: String
    ) : LicenseBaseDto
}