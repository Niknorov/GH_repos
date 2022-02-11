package com.example.icerock_t1.auth.data.loginDto

import com.google.gson.annotations.SerializedName


data class InstallationDto(

    @SerializedName("id") val id: Int,
    @SerializedName("account") val accountDto: AccountDto,
    @SerializedName("access_tokens_url") val access_tokens_url: String,
    @SerializedName("repositories_url") val repositories_url: String,
    @SerializedName("html_url") val html_url: String,
    @SerializedName("app_id") val app_id: Int,
    @SerializedName("target_id") val target_id: Int,
    @SerializedName("target_type") val target_type: String,
    @SerializedName("permissions") val permissionsDto: PermissionsDto,
    @SerializedName("events") val events: List<String>,
    @SerializedName("single_file_name") val single_file_name: String,
    @SerializedName("has_multiple_single_files") val has_multiple_single_files: Boolean,
    @SerializedName("single_file_paths") val single_file_paths: List<String>,
    @SerializedName("repository_selection") val repository_selection: String,
    @SerializedName("created_at") val created_at: String,
    @SerializedName("updated_at") val updated_at: String,
    @SerializedName("app_slug") val app_slug: String,
    @SerializedName("suspended_at") val suspended_at: String,
    @SerializedName("suspended_by") val suspended_by: String
)

