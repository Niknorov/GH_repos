package com.example.icerock_t1.auth.data

import com.example.icerock_t1.auth.domain.*

class InstallationsRepositoryImpl(
    private val installationsRemoteDataSource: InstallationsRemoteDataSource
) : InstallationsRepository {


    override suspend fun getInstallations(token: String): List<InstallationsModel> {


        return installationsRemoteDataSource.getInstallations(token).map { installationsDto ->
            InstallationsModel(
                totalCount = installationsDto.totalCount,
                installations = installationsDto.installations.map {
                    InstallationModel(
                        id = it.id,
                        accountModel = AccountModel(
                            login = it.accountDto.login,
                            id = it.accountDto.id,
                            nodeId = it.accountDto.nodeId,
                            avatarUrl = it.accountDto.avatarUrl,
                            gravatarId = it.accountDto.gravatarId,
                            url = it.accountDto.url,
                            htmlUrl = it.accountDto.gravatarId,
                            followersUrl = it.accountDto.followersUrl,
                            followingUrl = it.accountDto.followingUrl,
                            gistsUrl = it.accountDto.gistsUrl,
                            starredUrl = it.accountDto.starredUrl,
                            subscriptionsUrl = it.accountDto.subscriptionsUrl,
                            organizationsUrl = it.accountDto.organizationsUrl,
                            reposUrl = it.accountDto.reposUrl,
                            eventsUrl = it.accountDto.eventsUrl,
                            receivedEventsUrl = it.accountDto.receivedEventsUrl,
                            type = it.accountDto.type,
                            siteAdmin = it.accountDto.siteAdmin
                        ),
                        accessTokensUrl = it.accessTokensUrl,
                        repositoriesUrl = it.repositoriesUrl,
                        htmlUrl = it.htmlUrl,
                        appId = it.appId,
                        targetId = it.targetId,
                        targetType = it.targetType,
                        installationPermissionsModel = InstallationPermissionsModel(
                            checks = it.installationPermissionsDto.checks,
                            metadata = it.installationPermissionsDto.metadata,
                            contents = it.installationPermissionsDto.contents
                        ),
                        events = it.events,
                        singleFileName = it.singleFileName,
                        hasMultipleSingleFiles = it.hasMultipleSingleFiles,
                        singleFilePaths = it.singleFilePaths,
                        repositorySelection = it.repositorySelection,
                        createdAt = it.createdAt,
                        updatedAt = it.updatedAt,
                        appSlug = it.appSlug,
                        suspendedAt = it.suspendedAt,
                        suspendedBy = it.suspendedBy

                    )
                }
            )
        }
    }
}