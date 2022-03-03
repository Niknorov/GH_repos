package com.example.icerock_t1.detail.presentation

import com.example.icerock_t1.detail.domain.LicenseBaseModel

sealed class DetailUiState {

    class Success(val detail: List<RepositoryDetailItem>) : DetailUiState()
    object ErrorNetwork : DetailUiState()
    class HttpError(val detail: List<RepositoryDetailItem>) : DetailUiState()
    class SuccessLicense(val license: LicenseBaseModel): DetailUiState()
}