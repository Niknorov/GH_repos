package com.example.icerock_t1.auth.data

import com.example.icerock_t1.auth.data.installationsDto.InstallationsDto
import com.example.icerock_t1.auth.data.repositoriesDto.RepositoriesDto
import retrofit2.http.*

interface AuthApi {

    @GET(value = "/user/installations")
    suspend fun loginWithToken(
        @Header("Authorization") token: String
    ): List<InstallationsDto>

    @GET(value = "/user/installations/{installation_id}/repositories")
    suspend fun getRepos(
        @Header("Authorization") token: String,
        @Path("installation_id") id: Int
    ): List<RepositoriesDto>
}
