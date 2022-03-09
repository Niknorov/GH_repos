package com.example.icerock_t1.auth.data

import com.example.icerock_t1.auth.domain.AuthRepository
import com.example.icerock_t1.auth.domain.PlanModel
import com.example.icerock_t1.auth.domain.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
) : AuthRepository {

    override suspend fun performAuth(user: String, token: String): UserModel {

        val userDto = authRemoteDataSource.performAuth(user, token)
        return UserModel(
            login = userDto.login,
            id = userDto.id,
            nodeId = userDto.nodeId,
            avatarUrl = userDto.avatarUrl,
            gravatarId = userDto.gravatarId,
            url = userDto.url,
            htmlUrl = userDto.htmlUrl,
            followersUrl = userDto.followersUrl,
            followingUrl = userDto.followingUrl,
            gistsUrl = userDto.gistsUrl,
            starredUrl = userDto.starredUrl,
            subscriptionsUrl = userDto.subscriptionsUrl,
            organizationsUrl = userDto.organizationsUrl,
            reposUrl = userDto.reposUrl,
            eventsUrl = userDto.eventsUrl,
            receivedEventsUrl = userDto.receivedEventsUrl,
            type = userDto.type,
            siteAdmin = userDto.siteAdmin,
            name = userDto.name,
            company = userDto.company,
            blog = userDto.blog,
            location = userDto.location,
            email = userDto.email,
            hireable = userDto.hireable,
            bio = userDto.bio,
            twitterUsername = userDto.twitterUsername,
            publicRepos = userDto.publicRepos,
            publicGists = userDto.publicGists,
            followers = userDto.followers,
            following = userDto.following,
            createdAt = userDto.createdAt,
            updatedAt = userDto.updatedAt,
            privateGists = userDto.privateGists,
            totalPrivateRepos = userDto.totalPrivateRepos,
            ownedPrivateRepos = userDto.ownedPrivateRepos,
            diskUsage = userDto.diskUsage,
            collaborators = userDto.collaborators,
            twoFactorAuthentication = userDto.twoFactorAuthentication,
            plan = userDto.plan?.let {
                PlanModel(
                    name = it.name,
                    space = userDto.plan.space,
                    privateRepos = userDto.plan.privateRepos,
                    collaborators = userDto.plan.collaborators
                )
            }
        )
    }
}