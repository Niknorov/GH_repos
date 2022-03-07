package com.example.icerock_t1.user.domain

class ClearUserUseCase(
    private val userRepository: UserRepository
) {

    operator fun invoke(): String {

        return userRepository.clearUserName().toString()
    }
}