package com.davidtomas.domain.di

import com.davidtomas.core.domain.preferences.Preferences
import com.davidtomas.domain.repository.TrackerRepository
import com.davidtomas.domain.use_case.CalculateMealNutrientsUseCase
import com.davidtomas.domain.use_case.DeleteTrackedFoodUseCase
import com.davidtomas.domain.use_case.GetFoodsForDateUseCase
import com.davidtomas.domain.use_case.SearchFoodUseCase
import com.davidtomas.domain.use_case.TrackFoodUseCase
import com.davidtomas.domain.use_case.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFoodUseCase = TrackFoodUseCase(repository),
            searchFoodUseCase = SearchFoodUseCase(repository),
            getFoodsForDateUseCase = GetFoodsForDateUseCase(repository),
            deleteTrackedFoodUseCase = DeleteTrackedFoodUseCase(repository),
            calculateMealNutrientsUseCase = CalculateMealNutrientsUseCase(preferences)
        )
    }
}