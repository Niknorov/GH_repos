package com.example.icerock_t1.auth.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto (

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
    @SerialName("site_admin") val siteAdmin: Boolean,
    @SerialName("name") val name: String?,
    @SerialName("company") val company: String?,
    @SerialName("blog") val blog: String,
    @SerialName("location") val location: String?,
    @SerialName("email") val email: String?,
    @SerialName("hireable") val hireable: Boolean?,
    @SerialName("bio") val bio: String?,
    @SerialName("twitter_username") val twitterUsername: String?,
    @SerialName("public_repos") val publicRepos: Int,
    @SerialName("public_gists") val publicGists: Int,
    @SerialName("followers") val followers: Int,
    @SerialName("following") val following: Int,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("private_gists") val privateGists: Int?= null,
    @SerialName("total_private_repos") val totalPrivateRepos: Int?= null,
    @SerialName("owned_private_repos") val ownedPrivateRepos: Int?= null,
    @SerialName("disk_usage") val diskUsage: Int?= null,
    @SerialName("collaborators") val collaborators: Int?= null,
    @SerialName("two_factor_authentication") val twoFactorAuthentication: Boolean?= null,
    @SerialName("plan") val plan: Plan? = null
)

@Serializable
data class Plan(

    @SerialName("name") val name: String,
    @SerialName("space") val space: Int,
    @SerialName("private_repos") val privateRepos: Int,
    @SerialName("collaborators") val collaborators: Int
)