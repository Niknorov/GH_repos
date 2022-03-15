package com.example.icerock_t1.detail.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReadmeDto(

    @SerialName("type") val type: String,
    @SerialName("encoding") val encoding: String,
    @SerialName("size") val size: Int,
    @SerialName("name") val name: String,
    @SerialName("path") val path: String,
    @SerialName("content") val content: String,
    @SerialName("sha") val sha: String,
    @SerialName("url") val url: String,
    @SerialName("git_url") val gitUrl: String,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("download_url") val downloadUrl: String,
    @SerialName("_links") val linksLicense: LinksReadmeDto

)

@Serializable
data class LinksReadmeDto(

    @SerialName("git") val git: String,
    @SerialName("self") val self: String,
    @SerialName("html") val html: String
)

