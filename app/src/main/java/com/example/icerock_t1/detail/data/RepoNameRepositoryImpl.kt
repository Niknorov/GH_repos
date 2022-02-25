package com.example.icerock_t1.detail.data

import com.example.icerock_t1.detail.domain.RepoNameRepository

class RepoNameRepositoryImpl(
    private val repoNameDataSource: RepoNameDataSource
) : RepoNameRepository {

    override fun setRepoName(repoName: String) {

        return repoNameDataSource.setRepoName(repoName = repoName)
    }

    override fun getRepoName(): String {

        return repoNameDataSource.getRepoName()
    }
}