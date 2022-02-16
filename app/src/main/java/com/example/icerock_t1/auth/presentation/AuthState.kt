package com.example.icerock_t1.auth.presentation

enum class AuthState {

    OK,
    NOT_MODIFIED,
    UNAUTHORIZED,
    FORBIDDEN,
    UNSUPPORTED_MEDIA_TYPE,
    ERROR_NETWORK
}