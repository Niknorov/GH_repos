package com.example.icerock_t1.user.domain

interface UserRepository {

    fun setUserName(userName: String)

    fun getUserName(): String

    fun clearUserName()
}