package com.example.mobile_programming.model.repository.category

import com.example.mobile_programming.model.datasource.local.dao.CategoryDao
import com.example.mobile_programming.model.datasource.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryRepository {
    override fun getAllCategories(): Flow<List<CategoryEntity>> {
        return categoryDao.getAllCategories()
    }

    override suspend fun getCategoryById(id: Long): CategoryEntity? {
        return categoryDao.getCategoryById(id)
    }

    override suspend fun insertCategory(category: CategoryEntity) {
        categoryDao.insertCategory(category)
    }

    override suspend fun updateCategory(category: CategoryEntity) {
        categoryDao.updateCategory(category)
    }

    override suspend fun deleteCategory(category: CategoryEntity) {
        categoryDao.deleteCategory(category)
    }
}