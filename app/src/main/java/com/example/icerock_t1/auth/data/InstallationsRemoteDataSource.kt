package com.example.icerock_t1.auth.data

import com.example.icerock_t1.auth.data.AuthApi
import com.example.icerock_t1.auth.data.instDto.InstallationsDto

class InstallationsRemoteDataSource(
    private val authApi: AuthApi
) {

    suspend fun getInstallations(token: String): List<InstallationsDto> {

        return authApi.loginWithToken(token)
    }

}