package com.example.icerock_t1.detail.domain

interface RepoNameRepository {

    fun setRepoName(repoName: String)

    fun getRepoName(): String

}