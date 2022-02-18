package com.example.icerock_t1.auth.data

import retrofit2.http.GET
import retrofit2.http.Header

interface AuthApi {

    @GET(value = "/user")
    suspend fun loginWithToken(
        @Header("Authorization") credentials: String
    ): UserDto

}
