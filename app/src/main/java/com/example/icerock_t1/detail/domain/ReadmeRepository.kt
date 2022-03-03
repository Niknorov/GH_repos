package com.example.icerock_t1.detail.domain

interface ReadmeRepository {

    suspend fun getReadme(userName: String, repoName: String): ReadmeModel

    suspend fun getLicense(userName: String, repoName: String): LicenseBaseModel
}