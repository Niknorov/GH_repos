package com.example.icerock_t1.detail.domain

data class ReadmeModel(

    val type: String,
    val encoding: String,
    val size: Int,
    val name: String,
    val path: String,
    val content: String,
    val sha: String,
    val url: String,
    val gitUrl: String,
    val htmlUrl: String,
    val downloadUrl: String,
    val links: LinksReadmeModel

)

data class LinksReadmeModel(

    val git: String,
    val self: String,
    val html: String
)


