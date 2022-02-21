package com.example.icerock_t1.user.domain

import com.example.icerock_t1.user.data.UserLocalDataSource

interface UserRepository {

    fun setUserName(userName: String)

    fun getUserName(): String

    fun clearUserName()
}