package com.example.icerock_t1.auth.domain

interface RepositoriesRepository {


    suspend fun getRepository(): List<RepositoriesModel>
}