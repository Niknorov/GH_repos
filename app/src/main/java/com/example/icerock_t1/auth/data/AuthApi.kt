package com.example.icerock_t1.auth.data

import com.example.icerock_t1.auth.data.repositoriesDto.RepositoriesDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface AuthApi {

    @GET(value = "/user")
    suspend fun loginWithToken(
        @Header("Authorization") credentials: String
    ): UserDto

}
