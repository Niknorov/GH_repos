package com.example.icerock_t1.detail.domain

import com.example.icerock_t1.detail.data.ReadmeDto

interface ReadmeRepository {

    suspend fun getReadme(userName: String, repoName: String): List<ReadmeModel>
}