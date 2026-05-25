package com.example.mobile_programming.model.repository.mappers

import com.example.mobile_programming.model.datasource.local.entity.DrinkEntity
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.DrinkData

fun DrinkEntity.toDomain(): DrinkData {
    return DrinkData(
        id = this.id.toString(),
        restaurantId = this.restaurantId.toString(),
        name = this.name,
        imageResId = this.imageResId,
        price = this.price,
        description = this.description,
        isAlcoholic = this.isAlcoholic,
        isSugarFree = this.isSugarFree
    )
}