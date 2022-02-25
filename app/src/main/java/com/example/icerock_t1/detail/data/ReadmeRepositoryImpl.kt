package com.example.icerock_t1.detail.data

import com.example.icerock_t1.detail.domain.LinksModel
import com.example.icerock_t1.detail.domain.ReadmeModel
import com.example.icerock_t1.detail.domain.ReadmeRepository
import com.example.icerock_t1.repo.domain.RepositoriesRepository
import com.example.icerock_t1.repo.domain.RepositoryModel

class ReadmeRepositoryImpl(
    private val readmeRemoteDataSource: ReadmeRemoteDataSource
) : ReadmeRepository {


    override suspend fun getReadme(userName: String, repoName: String): List<ReadmeModel> {

        return readmeRemoteDataSource.getReadme(userName = userName, repoName = repoName).map {
            ReadmeModel(
                type = it.type,
                encoding = it.encoding,
                size = it.size,
                name = it.name,
                path = it.path,
                content = it.content,
                sha = it.sha,
                url = it.url,
                gitUrl = it.gitUrl,
                htmlUrl = it.htmlUrl,
                downloadUrl = it.downloadUrl,
                links = LinksModel(
                    git = it.links.git,
                    self = it.links.self,
                    html = it.links.html
                )
            )
        }
    }
}