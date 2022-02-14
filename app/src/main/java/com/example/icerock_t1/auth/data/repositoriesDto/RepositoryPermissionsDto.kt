package com.example.icerock_t1.auth.data.repositoriesDto

import com.google.gson.annotations.SerializedName

data class RepositoryPermissionsDto(

    @SerializedName("admin") val admin: Boolean,
    @SerializedName("push") val push: Boolean,
    @SerializedName("pull") val pull: Boolean

)
