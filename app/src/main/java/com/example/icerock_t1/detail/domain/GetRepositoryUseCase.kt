package com.example.icerock_t1.detail.domain

import com.example.icerock_t1.repo.domain.RepositoriesRepository
import com.example.icerock_t1.repo.domain.RepositoryModel
import com.example.icerock_t1.user.domain.UserRepository
import javax.inject.Inject

class GetRepositoryUseCase @Inject constructor(
    private val repositoriesRepository: RepositoriesRepository,
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(repoName: String): RepositoryModel {

        val userName = userRepository.getUserName()
        return repositoriesRepository.getRepository(userName = userName, repoName = repoName)
    }
}