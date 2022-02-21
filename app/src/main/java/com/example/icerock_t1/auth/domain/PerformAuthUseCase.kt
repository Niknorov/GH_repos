package com.example.icerock_t1.auth.domain

import com.example.icerock_t1.user.domain.UserRepository

class PerformAuthUseCase(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user: String, token: String) {

        userRepository.setUserName(user)
        authRepository.performAuth(user, token)
    }
}