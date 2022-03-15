package com.example.icerock_t1.repo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoryDto(

    @SerialName("id") val id: Int,
    @SerialName("node_id") val nodeId: String,
    @SerialName("name") val name: String,
    @SerialName("full_name") val fullName: String,
    @SerialName("owner") val ownerDto: OwnerDto,
    @SerialName("private") val private: Boolean,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("description") val description: String?,
    @SerialName("fork") val fork: Boolean,
    @SerialName("url") val url: String,
    @SerialName("archive_url") val archiveUrl: String,
    @SerialName("assignees_url") val assigneesUrl: String,
    @SerialName("blobs_url") val blobsUrl: String,
    @SerialName("branches_url") val branchesUrl: String,
    @SerialName("collaborators_url") val collaboratorsUrl: String,
    @SerialName("comments_url") val commentsUrl: String,
    @SerialName("commits_url") val commitsUrl: String,
    @SerialName("compare_url") val compareUrl: String,
    @SerialName("contents_url") val contentsUrl: String,
    @SerialName("contributors_url") val contributorsUrl: String,
    @SerialName("deployments_url") val deploymentsUrl: String,
    @SerialName("downloads_url") val downloadsUrl: String,
    @SerialName("events_url") val eventsUrl: String,
    @SerialName("forks_url") val forksUrl: String,
    @SerialName("git_commits_url") val gitCommitsUrl: String,
    @SerialName("git_refs_url") val gitRefsUrl: String,
    @SerialName("git_tags_url") val gitTagsUrl: String,
    @SerialName("git_url") val gitUrl: String,
    @SerialName("issue_comment_url") val issueCommentUrl: String,
    @SerialName("issue_events_url") val issueEventsUrl: String,
    @SerialName("issues_url") val issuesUrl: String,
    @SerialName("keys_url") val keysUrlsUrl: String,
    @SerialName("labels_url") val labelsUrl: String,
    @SerialName("languages_url") val languagesUrl: String,
    @SerialName("merges_url") val mergesUrl: String,
    @SerialName("milestones_url") val milestonesUrl: String,
    @SerialName("notifications_url") val notificationsUrl: String,
    @SerialName("pulls_url") val pullsUrl: String,
    @SerialName("releases_url") val releasesUrl: String,
    @SerialName("ssh_url") val sshUrl: String,
    @SerialName("stargazers_url") val stargazersUrl: String,
    @SerialName("statuses_url") val statusesUrl: String,
    @SerialName("subscribers_url") val subscribersUrl: String,
    @SerialName("subscription_url") val subscriptionUrl: String,
    @SerialName("tags_url") val tagsUrl: String,
    @SerialName("teams_url") val teamsUrl: String,
    @SerialName("trees_url") val treesUrl: String,
    @SerialName("clone_url") val cloneUrl: String,
    @SerialName("mirror_url") val mirrorUrl: String?,
    @SerialName("hooks_url") val hooksUrl: String,
    @SerialName("svn_url") val svnUrl: String,
    @SerialName("homepage") val homepage: String?,
    @SerialName("language") val language: String?,
    @SerialName("forks_count") val forksCount: Int,
    @SerialName("stargazers_count") val stargazersCount: Int,
    @SerialName("watchers_count") val watchersCount: Int,
    @SerialName("size") val size: Int,
    @SerialName("default_branch") val defaultBranch: String,
    @SerialName("open_issues_count") val openIssuesCount: Int,
    @SerialName("is_template") val isTemplate: Boolean,
    @SerialName("topics") val topics: List<String>,
    @SerialName("has_issues") val hasIssues: Boolean,
    @SerialName("has_projects") val hasProjects: Boolean,
    @SerialName("has_wiki") val hasWiki: Boolean,
    @SerialName("has_pages") val hasPages: Boolean,
    @SerialName("has_downloads") val hasDownloads: Boolean,
    @SerialName("archived") val archived: Boolean,
    @SerialName("disabled") val disabled: Boolean,
    @SerialName("visibility") val visibility: String,
    @SerialName("pushed_at") val pushedAt: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("permissions") val permissionsDto: PermissionsDto? = null,
    @SerialName("template_repository") val templateRepository: String? = null
)

@Serializable
data class OwnerDto(

    @SerialName("login") val login: String,
    @SerialName("id") val id: Int,
    @SerialName("node_id") val nodeId: String,
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("gravatar_id") val gravatarId: String,
    @SerialName("url") val url: String,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("followers_url") val followersUrl: String,
    @SerialName("following_url") val followingUrl: String,
    @SerialName("gists_url") val gistsUrl: String,
    @SerialName("starred_url") val starredUrl: String,
    @SerialName("subscriptions_url") val subscriptionsUrl: String,
    @SerialName("organizations_url") val organizationsUrl: String,
    @SerialName("repos_url") val reposUrl: String,
    @SerialName("events_url") val eventsUrl: String,
    @SerialName("received_events_url") val receivedEventsUrl: String,
    @SerialName("type") val type: String,
    @SerialName("site_admin") val siteAdmin: Boolean
)

@Serializable
data class PermissionsDto(

    @SerialName("admin") val admin: Boolean,
    @SerialName("push") val push: Boolean,
    @SerialName("pull") val pull: Boolean
)