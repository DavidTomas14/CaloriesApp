package com.davidtomas.presentation.screens.search

import com.davidtomas.domain.model.MealType
import com.davidtomas.domain.model.TrackableFood
import java.time.LocalDate

sealed class SearchEvent {
    data class OnQueryChanged(val query: String): SearchEvent()
    object  OnSearch: SearchEvent()
    data class OnToggleTrackableFood(val food: TrackableFood): SearchEvent()
    data class OnAmountForFoodChange(
        val food: TrackableFood,
        val amount: String
    ): SearchEvent()
    data class OnTrackFoodClick(
        val food: TrackableFood,
        val mealType: MealType,
        val date: LocalDate
    ): SearchEvent()

    data class OnSearchFocusChange(val isFocused: Boolean): SearchEvent()
}
