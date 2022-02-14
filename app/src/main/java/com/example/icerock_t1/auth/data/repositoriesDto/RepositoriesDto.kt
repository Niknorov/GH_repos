package com.example.icerock_t1.auth.data.repositoriesDto

import com.google.gson.annotations.SerializedName

data class RepositoriesDto(

    @SerializedName("total_count") val totalCount : Int,
    @SerializedName("repositories") val repositories : List<RepositoryDto>
)
