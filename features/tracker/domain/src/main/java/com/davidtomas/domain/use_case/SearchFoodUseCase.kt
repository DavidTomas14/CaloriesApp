package com.davidtomas.domain.use_case

import com.davidtomas.domain.model.TrackableFood
import com.davidtomas.domain.repository.TrackerRepository

class SearchFoodUseCase(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 50
    ) : Result<List<TrackableFood>> {
        if (query.isBlank()) {
            return Result.success(emptyList())
        }
        return repository.searchFood(query.trim(), page, pageSize)
    }
}