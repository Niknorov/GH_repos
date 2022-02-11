package com.example.icerock_t1.auth.data.reposDto

import com.google.gson.annotations.SerializedName

data class RepositoriesDto(

    @SerializedName("total_count") val total_count : Int,
    @SerializedName("repositories") val repositories : List<RepositoryDto>
)
