package com.example.icerock_t1.auth.domain

interface InstallationsRepository {

    suspend fun getInstallations(token: String): List<InstallationsModel>

}