package com.example.icerock_t1.detail.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class RepoNameDataSource(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("repoName", Context.MODE_PRIVATE)

    fun setRepoName(repoName: String) {

        sharedPreferences.edit {
            putString("repoName", repoName)
        }
    }

    fun getRepoName(): String {

        return sharedPreferences.getString("repoName", "").orEmpty()
    }
}