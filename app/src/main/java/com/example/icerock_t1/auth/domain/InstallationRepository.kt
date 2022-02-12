package com.example.icerock_t1.auth.domain

interface InstallationRepository {

    suspend fun getInstallations(): List<InstallationsModel>


}