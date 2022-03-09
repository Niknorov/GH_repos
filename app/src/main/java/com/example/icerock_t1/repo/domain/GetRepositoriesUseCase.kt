package com.example.icerock_t1.repo.domain

import com.example.icerock_t1.user.domain.UserRepository
import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(
    private val repositoriesRepository: RepositoriesRepository,
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(): List<RepositoryModel> {

        val userName = userRepository.getUserName()
        return repositoriesRepository.getRepositories(userName = userName)
    }
}