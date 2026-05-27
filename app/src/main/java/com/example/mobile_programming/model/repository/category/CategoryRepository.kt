package com.example.mobile_programming.model.repository.category

import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategories(): Flow<List<Category>>
    suspend fun getCategoryById(id: Long): Category?
    suspend fun insertCategory(category: Category)
    suspend fun updateCategory(category: Category)
    suspend fun deleteCategory(category: Category)
}