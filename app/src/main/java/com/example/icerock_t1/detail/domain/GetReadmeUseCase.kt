package com.example.icerock_t1.detail.domain

import com.example.icerock_t1.user.domain.UserRepository
import javax.inject.Inject

class GetReadmeUseCase @Inject constructor(
    private val readmeRepository: ReadmeRepository,
    private val userRepository: UserRepository,
) {

    suspend operator fun invoke(repoName: String): ReadmeModel {

        val userName = userRepository.getUserName()
        return readmeRepository.getReadme(userName = userName, repoName = repoName)
    }

}