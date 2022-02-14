package com.example.icerock_t1.auth.data

import com.example.icerock_t1.auth.data.installationsDto.InstallationsDto

class InstallationsRemoteDataSource(
    private val authApi: AuthApi
) {

    suspend fun getInstallations(token: String): List<InstallationsDto> {

        return authApi.loginWithToken(token)
    }

}