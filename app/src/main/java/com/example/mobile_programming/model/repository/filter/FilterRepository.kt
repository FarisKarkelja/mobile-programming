package com.example.mobile_programming.model.repository.filter

import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.filters.util.FilterData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

interface FilterRepository {
    suspend fun getFilters(): FilterData
}