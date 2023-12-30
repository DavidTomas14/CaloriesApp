package com.davidtomas.presentation.screens.tracker_overview

import com.davidtomas.domain.model.TrackedFood

sealed class TrackerOverviewEvent {
    object OnNextDayClick: TrackerOverviewEvent()
    object OnPreviousDayClick: TrackerOverviewEvent()

    data class OnToggleMealClick(val mealUi: MealUi): TrackerOverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent()

}
