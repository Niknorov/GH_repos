package com.example.icerock_t1.auth.presentation

sealed class AuthState {

    object Ok : AuthState()
    object NotModified : AuthState()
    object Unauthorized : AuthState()
    object Forbidden : AuthState()
    object ErrorNetwork : AuthState()
    object HttpException: AuthState()
    object UserOrTokenError: AuthState()
}