package com.example.icerock_t1.detail.presentation

sealed class RepositoryDetailItem {


    class StatsItem(
        val stargazersCount: Int,
        val forksCount: Int,
        val watchersCount: Int,
        val license: String,
        val url: String,
    ) : RepositoryDetailItem()

    class ReadmeItem(
        val content: String
    ) : RepositoryDetailItem()
}