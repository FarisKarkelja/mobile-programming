package com.example.mobile_programming.model.repository

import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import com.example.mobile_programming.presentation.ui.screens.categories.util.formatCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeCategoryRepository {
    suspend fun getCategories(shouldFail: Boolean = false): List<List<Category>> =
        withContext(Dispatchers.IO) {
            delay(2000)

            if (shouldFail) {
                throw IllegalStateException("Failed to load categories.")
            }

            val categories = HardcodedData.categories
            val pattern = listOf(1, 3, 2, 1)
            formatCategories(categories, pattern)
        }
}