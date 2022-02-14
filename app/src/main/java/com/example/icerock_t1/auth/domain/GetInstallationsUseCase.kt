package com.example.icerock_t1.auth.domain

class GetInstallationsUseCase(
    private val installationsRepository: InstallationsRepository
) {

    suspend operator fun invoke(token: String): List<InstallationsModel> {

        return installationsRepository.getInstallations(token)
    }
}