package com.example.icerock_t1.detail.domain

import com.example.icerock_t1.user.domain.UserRepository

class GetReadmeUseCase(
    private val readmeRepository: ReadmeRepository,
    private val userRepository: UserRepository,
    private val repoNameRepository: RepoNameRepository
) {

    suspend operator fun invoke(): List<ReadmeModel> {

        val userName = userRepository.getUserName()
        val repoName = repoNameRepository.getRepoName()
        return readmeRepository.getReadme(userName = userName, repoName = repoName)
    }

}