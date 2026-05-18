package com.example.mobile_programming.model.repository.category

import com.example.mobile_programming.model.datasource.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategories(): Flow<List<CategoryEntity>>
    suspend fun getCategoryById(id: Long): CategoryEntity?
    suspend fun insertCategory(category: CategoryEntity)
    suspend fun updateCategory(category: CategoryEntity)
    suspend fun deleteCategory(category: CategoryEntity)
}