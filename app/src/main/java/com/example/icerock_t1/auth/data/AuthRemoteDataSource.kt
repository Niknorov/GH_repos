package com.example.icerock_t1.auth.data

import okhttp3.Credentials
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApi: AuthApi
) {

    suspend fun performAuth(user: String, token: String): UserDto {

        val credentials = Credentials.basic(user, token)
        return authApi.loginWithToken(credentials)
    }
}