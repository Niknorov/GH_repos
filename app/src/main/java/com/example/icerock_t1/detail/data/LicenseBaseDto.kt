package com.example.icerock_t1.detail.data

import com.google.gson.annotations.SerializedName

data class LicenseBaseDto(


    @SerializedName("name") val name: String,
    @SerializedName("path") val path: String,
    @SerializedName("sha") val sha: String,
    @SerializedName("size") val size: Int,
    @SerializedName("url") val url: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("git_url") val gitUrl: String,
    @SerializedName("download_url") val downloadUrl: String,
    @SerializedName("type") val type: String,
    @SerializedName("content") val content: String,
    @SerializedName("encoding") val encoding: String,
    @SerializedName("_links") val linksDto: LinksLicenseDto,
    @SerializedName("license") val licenseDto: LicenseDto
)


data class LinksLicenseDto(

    @SerializedName("self") val self: String,
    @SerializedName("git") val git: String,
    @SerializedName("html") val html: String
)

data class LicenseDto(

    @SerializedName("key") val key: String,
    @SerializedName("name") val name: String,
    @SerializedName("spdx_id") val spdxId: String,
    @SerializedName("url") val url: String,
    @SerializedName("node_id") val nodeId: String
)