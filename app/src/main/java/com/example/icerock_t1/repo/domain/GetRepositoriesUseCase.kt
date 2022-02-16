package com.example.icerock_t1.repo.domain

import com.example.icerock_t1.repo.domain.RepositoriesRepository
import com.example.icerock_t1.repo.domain.RepositoryModel

class GetRepositoriesUseCase(
    private val repositoriesRepository: RepositoriesRepository
) {

    suspend operator fun invoke(userName: String): List<RepositoryModel> {

        return repositoriesRepository.getRepositories(userName = userName)
    }
}