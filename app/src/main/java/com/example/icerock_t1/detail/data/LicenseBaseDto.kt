package com.example.icerock_t1.detail.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LicenseBaseDto(


    @SerialName("name") val name: String,
    @SerialName("path") val path: String,
    @SerialName("sha") val sha: String,
    @SerialName("size") val size: Int,
    @SerialName("url") val url: String,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("git_url") val gitUrl: String,
    @SerialName("download_url") val downloadUrl: String,
    @SerialName("type") val type: String,
    @SerialName("content") val content: String,
    @SerialName("encoding") val encoding: String,
    @SerialName("_links") val linksDto: LinksLicenseDto,
    @SerialName("license") val licenseDto: LicenseDto
)

@Serializable
data class LinksLicenseDto(

    @SerialName("self") val self: String,
    @SerialName("git") val git: String,
    @SerialName("html") val html: String
)

@Serializable
data class LicenseDto(

    @SerialName("key") val key: String,
    @SerialName("name") val name: String,
    @SerialName("spdx_id") val spdxId: String,
    @SerialName("url") val url: String,
    @SerialName("node_id") val nodeId: String
)