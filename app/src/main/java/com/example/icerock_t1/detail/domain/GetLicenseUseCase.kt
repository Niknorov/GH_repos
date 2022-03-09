package com.example.icerock_t1.detail.domain

import com.example.icerock_t1.repo.domain.RepositoriesRepository
import com.example.icerock_t1.user.domain.UserRepository
import javax.inject.Inject

class GetLicenseUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val readmeRepository: ReadmeRepository
) {

    suspend operator fun invoke(repoName: String): LicenseBaseModel {

        val userName = userRepository.getUserName()
        return readmeRepository.getLicense(userName = userName, repoName = repoName)
    }
}