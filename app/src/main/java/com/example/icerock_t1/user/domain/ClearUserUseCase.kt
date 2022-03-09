package com.example.icerock_t1.user.domain

import javax.inject.Inject

class ClearUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke(): String {

        return userRepository.clearUserName().toString()
    }
}