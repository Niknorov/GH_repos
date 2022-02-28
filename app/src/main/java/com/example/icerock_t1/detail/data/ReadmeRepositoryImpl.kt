package com.example.icerock_t1.detail.data

import com.example.icerock_t1.detail.domain.LinksModel
import com.example.icerock_t1.detail.domain.ReadmeModel
import com.example.icerock_t1.detail.domain.ReadmeRepository
import com.example.icerock_t1.repo.domain.RepositoriesRepository
import com.example.icerock_t1.repo.domain.RepositoryModel

class ReadmeRepositoryImpl(
    private val readmeRemoteDataSource: ReadmeRemoteDataSource
) : ReadmeRepository {


    override suspend fun getReadme(userName: String, repoName: String): ReadmeModel{

        val readmeDto = readmeRemoteDataSource.getReadme(userName = userName, repoName = repoName)
        return ReadmeModel(
            type = readmeDto.type,
            encoding = readmeDto.encoding,
            size = readmeDto.size,
            name = readmeDto.name,
            path = readmeDto.path,
            content = readmeDto.content,
            sha = readmeDto.sha,
            url = readmeDto.url,
            gitUrl = readmeDto.gitUrl,
            htmlUrl = readmeDto.htmlUrl,
            downloadUrl = readmeDto.downloadUrl,
            links = LinksModel(
                git = readmeDto.links.git,
                self = readmeDto.links.self,
                html = readmeDto.links.html
            )
        )
    }
}