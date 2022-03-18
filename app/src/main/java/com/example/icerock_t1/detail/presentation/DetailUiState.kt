package com.example.icerock_t1.detail.presentation

sealed class DetailUiState {

    class Success(val detail: List<RepositoryDetailItem>) : DetailUiState()
    object ErrorNetwork : DetailUiState()
    class HttpError(val detail: List<RepositoryDetailItem>) : DetailUiState()
    object Progress: DetailUiState()
    object ReadmeErrorNetwork: DetailUiState()
    object ReadmeHttpError: DetailUiState()
}