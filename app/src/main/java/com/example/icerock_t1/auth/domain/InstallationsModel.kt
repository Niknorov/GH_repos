package com.example.icerock_t1.auth.domain

data class InstallationsModel(

    val totalCount: Int,
    val installations: List<InstallationModel>
)

data class InstallationModel(

    val id: Int,
    val accountModel: AccountModel,
    val accessTokensUrl: String,
    val repositoriesUrl: String,
    val htmlUrl: String,
    val appId: Int,
    val targetId: Int,
    val targetType: String,
    val installationPermissionsModel: InstallationPermissionsModel,
    val events: List<String>,
    val singleFileName: String,
    val hasMultipleSingleFiles: Boolean,
    val singleFilePaths: List<String>,
    val repositorySelection: String,
    val createdAt: String,
    val updatedAt: String,
    val appSlug: String,
    val suspendedAt: String,
    val suspendedBy: String
)

data class InstallationPermissionsModel(
    val checks: String,
    val metadata: String,
    val contents: String
)

data class AccountModel(

    val login: String,
    val id: Int,
    val nodeId: String,
    val avatarUrl: String,
    val gravatarId: String,
    val url: String,
    val htmlUrl: String,
    val followersUrl: String,
    val followingUrl: String,
    val gistsUrl: String,
    val starredUrl: String,
    val subscriptionsUrl: String,
    val organizationsUrl: String,
    val reposUrl: String,
    val eventsUrl: String,
    val receivedEventsUrl: String,
    val type: String,
    val siteAdmin: Boolean
)

