package com.davidtomas.caloriesapp.navigation

import androidx.navigation.NavController
import com.davidtomas.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}