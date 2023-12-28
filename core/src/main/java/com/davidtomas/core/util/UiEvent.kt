package com.davidtomas.core.util

sealed class UiEvent {
    object Success: UiEvent()
    object NavigateUP: UiEvent()
    data class ShowSnackBar(val message: UiText) : UiEvent()
}
