package com.example.icerock_t1.auth.data.installationsDto

import com.google.gson.annotations.SerializedName


data class InstallationDto(

    @SerializedName("id") val id: Int,
    @SerializedName("account") val accountDto: AccountDto,
    @SerializedName("access_tokens_url") val accessTokensUrl: String,
    @SerializedName("repositories_url") val repositoriesUrl: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("app_id") val appId: Int,
    @SerializedName("target_id") val targetId: Int,
    @SerializedName("target_type") val targetType: String,
    @SerializedName("permissions") val installationPermissionsDto: InstallationPermissionsDto,
    @SerializedName("events") val events: List<String>,
    @SerializedName("single_file_name") val singleFileName: String,
    @SerializedName("has_multiple_single_files") val hasMultipleSingleFiles: Boolean,
    @SerializedName("single_file_paths") val singleFilePaths: List<String>,
    @SerializedName("repository_selection") val repositorySelection: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("app_slug") val appSlug: String,
    @SerializedName("suspended_at") val suspendedAt: String,
    @SerializedName("suspended_by") val suspendedBy: String
)

