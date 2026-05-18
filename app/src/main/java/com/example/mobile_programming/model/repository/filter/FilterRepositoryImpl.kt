package com.example.mobile_programming.model.repository.filter

import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.filters.util.FilterData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilterRepositoryImpl @Inject constructor() : FilterRepository {
    override suspend fun getFilters(): FilterData = withContext(Dispatchers.IO) {
        FilterData(
            locations = HardcodedData.locations,
            budgets = HardcodedData.budgets
        )
    }
}