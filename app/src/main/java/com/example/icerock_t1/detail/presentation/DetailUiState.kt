package com.example.icerock_t1.detail.presentation

sealed class DetailUiState {

    class Success(val detail: List<RepositoryDetailItem>) : DetailUiState()
    object ErrorNetwork : DetailUiState()
    object HttpError : DetailUiState()
    object Progress : DetailUiState()
    class ReadmeErrorNetwork(val detail: List<RepositoryDetailItem>) : DetailUiState()
    class ReadmeHttpError(val detail: List<RepositoryDetailItem>) : DetailUiState()
}