package com.example.icerock_t1.auth.data

import com.example.icerock_t1.auth.domain.*

class RepositoriesRepositoryImpl(
    private val repositoriesRemoteDataSource: RepositoriesRemoteDataSource
) : RepositoriesRepository {

    override suspend fun getRepository(token: String, id: Int): List<RepositoriesModel> {


        return repositoriesRemoteDataSource.getRepositories(token, id).map { repositoriesDto ->
            RepositoriesModel(
                totalCount = repositoriesDto.totalCount,
                repositories = repositoriesDto.repositories.map {
                    RepositoryModel(
                        id = it.id,
                        nodeId = it.nodeId,
                        name = it.name,
                        fullName = it.fullName,
                        ownerModel = OwnerModel(
                            login = it.ownerDto.login,
                            id = it.ownerDto.id,
                            nodeId = it.ownerDto.nodeId,
                            avatarUrl = it.ownerDto.avatarUrl,
                            gravatarId = it.ownerDto.gravatarId,
                            url = it.ownerDto.url,
                            htmlUrl = it.ownerDto.htmlUrl,
                            followersUrl = it.ownerDto.followersUrl,
                            followingUrl = it.ownerDto.followingUrl,
                            gistsUrl = it.ownerDto.gistsUrl,
                            starredUrl = it.ownerDto.starredUrl,
                            subscriptionsUrl = it.ownerDto.subscriptionsUrl,
                            organizationsUrl = it.ownerDto.organizationsUrl,
                            reposUrl = it.ownerDto.reposUrl,
                            eventsUrl = it.ownerDto.eventsUrl,
                            receivedEventsUrl = it.ownerDto.receivedEventsUrl,
                            type = it.ownerDto.type,
                            siteAdmin = it.ownerDto.siteAdmin
                        ),
                        private = it.private,
                        htmlUrl = it.htmlUrl,
                        description = it.description,
                        fork = it.fork,
                        url = it.url,
                        archived = it.archived,
                        archiveUrl = it.archiveUrl,
                        assigneesUrl = it.assigneesUrl,
                        blobsUrl = it.blobsUrl,
                        branchesUrl = it.branchesUrl,
                        collaboratorsUrl = it.collaboratorsUrl,
                        commentsUrl = it.commentsUrl,
                        commitsUrl = it.commitsUrl,
                        compareUrl = it.compareUrl,
                        contentsUrl = it.contentsUrl,
                        contributorsUrl = it.contributorsUrl,
                        deploymentsUrl = it.deploymentsUrl,
                        downloadsUrl = it.downloadsUrl,
                        eventsUrl = it.eventsUrl,
                        forksUrl = it.forksUrl,
                        gitCommitsUrl = it.gitCommitsUrl,
                        gitRefsUrl = it.gitRefsUrl,
                        gitTagsUrl = it.gitTagsUrl,
                        gitUrl = it.gitUrl,
                        issueCommentUrl = it.issueCommentUrl,
                        issueEventsUrl = it.issueEventsUrl,
                        issuesUrl = it.issuesUrl,
                        keysUrlsUrl = it.keysUrlsUrl,
                        labelsUrl = it.labelsUrl,
                        languagesUrl = it.languagesUrl,
                        mergesUrl = it.mergesUrl,
                        milestonesUrl = it.milestonesUrl,
                        notificationsUrl = it.notificationsUrl,
                        pullsUrl = it.pullsUrl,
                        releasesUrl = it.releasesUrl,
                        sshUrl = it.sshUrl,
                        stargazersUrl = it.stargazersUrl,
                        statusesUrl = it.statusesUrl,
                        subscribersUrl = it.subscribersUrl,
                        subscriptionUrl = it.subscriptionUrl,
                        tagsUrl = it.tagsUrl,
                        teamsUrl = it.teamsUrl,
                        treesUrl = it.treesUrl,
                        cloneUrl = it.cloneUrl,
                        mirrorUrl = it.mirrorUrl,
                        hooksUrl = it.hooksUrl,
                        svnUrl = it.svnUrl,
                        homepage = it.homepage,
                        language = it.language,
                        forksCount = it.forksCount,
                        stargazersCount = it.stargazersCount,
                        watchersCount = it.watchersCount,
                        size = it.size,
                        defaultBranch = it.defaultBranch,
                        openIssues = it.openIssues,
                        openIssuesCount = it.openIssuesCount,
                        isTemplate = it.isTemplate,
                        topics = it.topics,
                        hasIssues = it.hasIssues,
                        hasProjects = it.hasProjects,
                        hasWiki = it.hasWiki,
                        hasPages = it.hasPages,
                        hasDownloads = it.hasDownloads,
                        disabled = it.disabled,
                        visibility = it.visibility,
                        pushedAt = it.pushedAt,
                        createdAt = it.createdAt,
                        updatedAt = it.updatedAt,
                        repositoryPermissionsModel = RepositoryPermissionsModel(
                            admin = it.repositoryPermissionsDto.admin,
                            push = it.repositoryPermissionsDto.push,
                            pull = it.repositoryPermissionsDto.pull
                        ),
                        allowAutoMerge = it.allowAutoMerge,
                        allowRebaseMerge = it.allowRebaseMerge,
                        templateRepository = it.templateRepository,
                        tempCloneToken = it.tempCloneToken,
                        allowSquashMerge = it.allowSquashMerge,
                        deleteBranchOnMerge = it.deleteBranchOnMerge,
                        allowMergeCommit = it.allowMergeCommit,
                        subscribersCount = it.subscribersCount,
                        networkCount = it.networkCount,
                        licenseModel = LicenseModel(
                            key = it.licenseDto.key,
                            name = it.licenseDto.name,
                            url = it.licenseDto.url,
                            spdxId = it.licenseDto.spdxId,
                            nodeId = it.licenseDto.nodeId,
                            htmlUrl = it.licenseDto.htmlUrl
                        ),
                        forks = it.forks,
                        watchers = it.watchers
                    )
                }
            )

        }

    }
}