package com.example.mobile_programming.model.datasource.local.util

import com.example.mobile_programming.R
import com.example.mobile_programming.model.datasource.local.entity.CategoryEntity

object CategorySeed {
    val defaultCategories = listOf(
        CategoryEntity(id = 1, name = "Local", imageResId = R.drawable.category_1),
        CategoryEntity(id = 2, name = "Quick", imageResId = R.drawable.category_2),
        CategoryEntity(id = 3, name = "BBQ", imageResId = R.drawable.category_3),
        CategoryEntity(id = 4, name = "Pie", imageResId = R.drawable.category_4),
        CategoryEntity(id = 5, name = "Healthy", imageResId = R.drawable.category_5),
        CategoryEntity(id = 6, name = "Global", imageResId = R.drawable.category_6),
        CategoryEntity(id = 7, name = "Sweets", imageResId = R.drawable.category_7)
    )
}