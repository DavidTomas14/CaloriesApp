package com.davidtomas.domain.use_case

import com.davidtomas.domain.model.TrackedFood
import com.davidtomas.domain.repository.TrackerRepository

class DeleteTrackedFoodUseCase(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(trackedFood: TrackedFood) {
        return repository.deleteTrackedFood(trackedFood)
    }
}