package com.example.icerock_t1.utils

sealed interface TextState

class ValidatedText(val text: String, val valid: Boolean): TextState
class NotValidatedText(val text: String) : TextState