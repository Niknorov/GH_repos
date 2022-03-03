package com.example.icerock_t1.detail.data

class ReadmeRemoteDataSource(
    private val detailApi: DetailApi
) {

    suspend fun getReadme(userName: String, repoName: String): ReadmeDto {

        return detailApi.getReadme(userName = userName, repoName = repoName)
    }

    suspend fun getLicense(userName: String, repoName: String): LicenseBaseDto {

        return detailApi.getLicense(userName = userName, repoName = repoName)
    }
}