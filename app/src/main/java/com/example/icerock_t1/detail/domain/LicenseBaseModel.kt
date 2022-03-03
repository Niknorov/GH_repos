package com.example.icerock_t1.detail.domain

data class LicenseBaseModel(

    val name: String,
    val path: String,
    val sha: String,
    val size: Int,
    val url: String,
    val htmlUrl: String,
    val gitUrl: String,
    val downloadUrl: String,
    val type: String,
    val content: String,
    val encoding: String,
    val LinksModel: LinksLicenseModel,
    val licenseModel: LicenseModel
)


data class LinksLicenseModel(

    val self: String,
    val git: String,
    val html: String
)

data class LicenseModel(

    val key: String,
    val name: String,
    val spdxId: String,
    val url: String,
    val nodeId: String
)