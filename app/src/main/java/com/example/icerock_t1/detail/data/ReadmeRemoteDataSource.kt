package com.example.icerock_t1.detail.data

class ReadmeRemoteDataSource(
    private val readmeApi: ReadmeApi
) {

    suspend fun getReadme(userName: String, repoName: String): List<ReadmeDto> {

        return readmeApi.getReadme(userName = userName, repoName = repoName)
    }
}