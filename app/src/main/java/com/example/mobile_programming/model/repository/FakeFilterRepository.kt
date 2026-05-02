package com.example.mobile_programming.model.repository

import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.filters.util.FilterData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeFilterRepository {
    suspend fun getFilters(shouldFail: Boolean = false): FilterData = withContext(Dispatchers.IO) {
        delay(1500)

        if (shouldFail) {
            throw IllegalStateException("Failed to load filters.")
        }

        FilterData(
            locations = HardcodedData.locations,
            budgets = HardcodedData.budgets
        )
    }
}