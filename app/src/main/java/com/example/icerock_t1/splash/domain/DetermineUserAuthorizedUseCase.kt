package com.example.icerock_t1.splash.domain

import com.example.icerock_t1.user.domain.UserRepository

class DetermineUserAuthorizedUseCase(
    private val userRepository: UserRepository
) {

    operator fun invoke(): Boolean {

        return userRepository.getUserName().isNotBlank()
    }
}