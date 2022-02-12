package com.example.icerock_t1.auth.domain

data class InstallationsModel(

    val total_count: Int,
    val installations: List<InstallationModel>
)

data class InstallationModel(

    val id: Int,
    val accountDto: AccountModel,
    val access_tokens_url: String,
    val repositories_url: String,
    val html_url: String,
    val app_id: Int,
    val target_id: Int,
    val target_type: String,
    val permissionsInstModel: PermissionsInstModel,
    val events: List<String>,
    val single_file_name: String,
    val has_multiple_single_files: Boolean,
    val single_file_paths: List<String>,
    val repository_selection: String,
    val created_at: String,
    val updated_at: String,
    val app_slug: String,
    val suspended_at: String,
    val suspended_by: String
)

data class PermissionsInstModel(
    val checks: String,
    val metadata: String,
    val contents: String
)

data class AccountModel(

    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val events_url: String,
    val received_events_url: String,
    val type: String,
    val site_admin: Boolean
)

