package com.example.icerock_t1.repo.data

import com.example.icerock_t1.repo.domain.OwnerModel
import com.example.icerock_t1.repo.domain.PermissionsModel
import com.example.icerock_t1.repo.domain.RepositoriesRepository
import com.example.icerock_t1.repo.domain.RepositoryModel

class RepositoriesRepositoryImpl(
    private val repositoryRemoteDataSource: RepositoryRemoteDataSource
) : RepositoriesRepository {

    override suspend fun getRepositories(userName: String): List<RepositoryModel> {

        return repositoryRemoteDataSource.getRepositories(userName = userName).map {
            RepositoryModel(
                id = it.id,
                nodeId = it.nodeId,
                name = it.name,
                fullName = it.fullName,
                ownerDto = OwnerModel(
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
                gitUrl = it.gitUrl,
                gitCommitsUrl = it.gitCommitsUrl,
                gitRefsUrl = it.gitRefsUrl,
                gitTagsUrl = it.gitTagsUrl,
                issuesUrl = it.issuesUrl,
                issueCommentUrl = it.issueCommentUrl,
                issueEventsUrl = it.issueEventsUrl,
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
                openIssuesCount = it.openIssuesCount,
                isTemplate = it.isTemplate,
                topics = it.topics,
                hasIssues = it.hasIssues,
                hasProjects = it.hasProjects,
                hasWiki = it.hasWiki,
                hasPages = it.hasPages,
                hasDownloads = it.hasDownloads,
                archived = it.archived,
                disabled = it.disabled,
                visibility = it.visibility,
                pushedAt = it.pushedAt,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt,
                permissionsDto = PermissionsModel(
                    admin = it.permissionsDto.admin,
                    push = it.permissionsDto.push,
                    pull = it.permissionsDto.pull
                ),
                templateRepository = it.templateRepository
            )
        }
    }
}