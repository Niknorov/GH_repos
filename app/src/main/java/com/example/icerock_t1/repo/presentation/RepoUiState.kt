package com.example.icerock_t1.repo.presentation

import com.example.icerock_t1.repo.domain.RepositoryModel

sealed class RepoUiState {

    class Success(val repositories: List<RepositoryModel>) : RepoUiState()

    object ErrorNetwork : RepoUiState()
    object HttpException : RepoUiState()
}