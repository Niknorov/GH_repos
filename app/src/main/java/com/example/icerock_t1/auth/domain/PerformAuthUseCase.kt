package com.example.icerock_t1.auth.domain

class PerformAuthUseCase(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(user: String, token: String) {

        authRepository.performAuth(user, token)
    }
}