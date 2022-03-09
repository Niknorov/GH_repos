package com.example.icerock_t1.splash.domain

import com.example.icerock_t1.user.domain.UserRepository
import javax.inject.Inject

class DetermineUserAuthorizedUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke(): Boolean {

        return userRepository.getUserName().isNotBlank()
    }
}