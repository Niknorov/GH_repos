package com.example.icerock_t1.repo.data

import com.example.icerock_t1.repo.domain.OwnerModel
import com.example.icerock_t1.repo.domain.PermissionsModel
import com.example.icerock_t1.repo.domain.RepositoryModel
import javax.inject.Inject

class RepositoryConverter @Inject constructor (){

    fun convert(repositoryDto: RepositoryDto): RepositoryModel {

        return RepositoryModel(
            id = repositoryDto.id,
            nodeId = repositoryDto.nodeId,
            name = repositoryDto.name,
            fullName = repositoryDto.fullName,
            ownerDto = OwnerModel(
                login = repositoryDto.ownerDto.login,
                id = repositoryDto.ownerDto.id,
                nodeId = repositoryDto.ownerDto.nodeId,
                avatarUrl = repositoryDto.ownerDto.avatarUrl,
                gravatarId = repositoryDto.ownerDto.gravatarId,
                url = repositoryDto.ownerDto.url,
                htmlUrl = repositoryDto.ownerDto.htmlUrl,
                followersUrl = repositoryDto.ownerDto.followersUrl,
                followingUrl = repositoryDto.ownerDto.followingUrl,
                gistsUrl = repositoryDto.ownerDto.gistsUrl,
                starredUrl = repositoryDto.ownerDto.starredUrl,
                subscriptionsUrl = repositoryDto.ownerDto.subscriptionsUrl,
                organizationsUrl = repositoryDto.ownerDto.organizationsUrl,
                reposUrl = repositoryDto.ownerDto.reposUrl,
                eventsUrl = repositoryDto.ownerDto.eventsUrl,
                receivedEventsUrl = repositoryDto.ownerDto.receivedEventsUrl,
                type = repositoryDto.ownerDto.type,
                siteAdmin = repositoryDto.ownerDto.siteAdmin
            ),
            private = repositoryDto.private,
            htmlUrl = repositoryDto.htmlUrl,
            description = repositoryDto.description,
            fork = repositoryDto.fork,
            url = repositoryDto.url,
            archiveUrl = repositoryDto.archiveUrl,
            assigneesUrl = repositoryDto.assigneesUrl,
            blobsUrl = repositoryDto.blobsUrl,
            branchesUrl = repositoryDto.branchesUrl,
            collaboratorsUrl = repositoryDto.collaboratorsUrl,
            commentsUrl = repositoryDto.commentsUrl,
            commitsUrl = repositoryDto.commitsUrl,
            compareUrl = repositoryDto.compareUrl,
            contentsUrl = repositoryDto.contentsUrl,
            contributorsUrl = repositoryDto.contributorsUrl,
            deploymentsUrl = repositoryDto.deploymentsUrl,
            downloadsUrl = repositoryDto.downloadsUrl,
            eventsUrl = repositoryDto.eventsUrl,
            forksUrl = repositoryDto.forksUrl,
            gitUrl = repositoryDto.gitUrl,
            gitCommitsUrl = repositoryDto.gitCommitsUrl,
            gitRefsUrl = repositoryDto.gitRefsUrl,
            gitTagsUrl = repositoryDto.gitTagsUrl,
            issuesUrl = repositoryDto.issuesUrl,
            issueCommentUrl = repositoryDto.issueCommentUrl,
            issueEventsUrl = repositoryDto.issueEventsUrl,
            keysUrlsUrl = repositoryDto.keysUrlsUrl,
            labelsUrl = repositoryDto.labelsUrl,
            languagesUrl = repositoryDto.languagesUrl,
            mergesUrl = repositoryDto.mergesUrl,
            milestonesUrl = repositoryDto.milestonesUrl,
            notificationsUrl = repositoryDto.notificationsUrl,
            pullsUrl = repositoryDto.pullsUrl,
            releasesUrl = repositoryDto.releasesUrl,
            sshUrl = repositoryDto.sshUrl,
            stargazersUrl = repositoryDto.stargazersUrl,
            statusesUrl = repositoryDto.statusesUrl,
            subscribersUrl = repositoryDto.subscribersUrl,
            subscriptionUrl = repositoryDto.subscriptionUrl,
            tagsUrl = repositoryDto.tagsUrl,
            teamsUrl = repositoryDto.teamsUrl,
            treesUrl = repositoryDto.treesUrl,
            cloneUrl = repositoryDto.cloneUrl,
            mirrorUrl = repositoryDto.mirrorUrl,
            hooksUrl = repositoryDto.hooksUrl,
            svnUrl = repositoryDto.svnUrl,
            homepage = repositoryDto.homepage,
            language = repositoryDto.language,
            forksCount = repositoryDto.forksCount,
            stargazersCount = repositoryDto.stargazersCount,
            watchersCount = repositoryDto.watchersCount,
            size = repositoryDto.size,
            defaultBranch = repositoryDto.defaultBranch,
            openIssuesCount = repositoryDto.openIssuesCount,
            isTemplate = repositoryDto.isTemplate,
            topics = repositoryDto.topics,
            hasIssues = repositoryDto.hasIssues,
            hasProjects = repositoryDto.hasProjects,
            hasWiki = repositoryDto.hasWiki,
            hasPages = repositoryDto.hasPages,
            hasDownloads = repositoryDto.hasDownloads,
            archived = repositoryDto.archived,
            disabled = repositoryDto.disabled,
            visibility = repositoryDto.visibility,
            pushedAt = repositoryDto.pushedAt,
            createdAt = repositoryDto.createdAt,
            updatedAt = repositoryDto.updatedAt,
            permissionsDto = repositoryDto.permissionsDto?.let {
                PermissionsModel(
                    admin = it.admin,
                    push = it.push,
                    pull = it.pull
                )
            },
            templateRepository = repositoryDto.templateRepository
        )


    }
}