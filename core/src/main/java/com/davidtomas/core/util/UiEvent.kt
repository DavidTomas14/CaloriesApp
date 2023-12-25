package com.davidtomas.core.util

sealed class UiEvent {
    data class Navigate(val route: String): UiEvent()
    object NavigateUP: UiEvent()
}
