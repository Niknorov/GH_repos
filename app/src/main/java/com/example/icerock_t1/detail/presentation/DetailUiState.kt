package com.example.icerock_t1.detail.presentation

sealed class DetailUiState {

    class Success(val detail: List<RepositoryDetailItem>) : DetailUiState()
    object ErrorNetwork : DetailUiState()
}