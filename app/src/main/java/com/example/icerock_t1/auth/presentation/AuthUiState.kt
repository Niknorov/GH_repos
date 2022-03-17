package com.example.icerock_t1.auth.presentation

sealed class AuthUiState {

    object Ok : AuthUiState()
    object NotModified : AuthUiState()
    object Unauthorized : AuthUiState()
    object Forbidden : AuthUiState()
    object ErrorNetwork : AuthUiState()
    object HttpException: AuthUiState()
    object UserOrTokenError: AuthUiState()
}