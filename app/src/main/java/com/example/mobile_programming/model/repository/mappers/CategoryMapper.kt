package com.example.mobile_programming.model.repository.mappers

import com.example.mobile_programming.model.datasource.local.entity.CategoryEntity
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category

fun CategoryEntity.toDomain(): Category {
    return Category(
        id = this.id.toString(),
        name = this.name,
        iconResId = this.imageResId
    )
}

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = this.id.toLongOrNull() ?: 0L,
        name = this.name,
        imageResId = this.iconResId
    )
}