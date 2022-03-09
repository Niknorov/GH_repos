package com.example.icerock_t1.user.data

import com.example.icerock_t1.user.domain.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {

    override fun setUserName(userName: String) {
        return userLocalDataSource.setUserName(userName = userName)
    }

    override fun getUserName(): String {

        return userLocalDataSource.getUserName()
    }

    override fun clearUserName() {

        return userLocalDataSource.clearUserName()
    }
}