package com.example.icerock_t1.auth.data

import android.net.wifi.hotspot2.pps.Credential
import okhttp3.Credentials

class AuthRemoteDataSource(
    private val authApi: AuthApi
) {

    suspend fun performAuth(user: String, token: String): UserDto {

        val credentials = Credentials.basic(user, token)
        return authApi.loginWithToken(credentials)
    }
}