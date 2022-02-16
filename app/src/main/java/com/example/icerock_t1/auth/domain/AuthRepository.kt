package com.example.icerock_t1.auth.domain

interface AuthRepository {

    suspend fun performAuth(user: String, token: String): UserModel

}