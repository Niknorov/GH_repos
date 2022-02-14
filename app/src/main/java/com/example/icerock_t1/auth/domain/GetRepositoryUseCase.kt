package com.example.icerock_t1.auth.domain

class GetRepositoryUseCase(
    private val repositoriesRepository: RepositoriesRepository
) {

    suspend operator fun invoke(token: String, id: Int): List<RepositoriesModel> {

        return repositoriesRepository.getRepository(token, id)
    }


}