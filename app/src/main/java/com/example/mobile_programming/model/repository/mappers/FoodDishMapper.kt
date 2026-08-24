package com.example.mobile_programming.model.repository.mappers

import com.example.mobile_programming.model.datasource.local.entity.FoodDishEntity
import com.example.mobile_programming.model.datasource.local.util.Allergens
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.Allergen
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDishData

fun FoodDishEntity.toDomain(): FoodDishData {
    return FoodDishData(
        id = this.id.toString(),
        restaurantId = this.restaurantId.toString(),
        name = this.name,
        imageResId = this.imageResId,
        price = this.price,
        description = this.description,
        cookingTime = this.cookingTime,
        servingSize = this.servingSize,
        calories = this.calories,
        allergens = this.allergens.map { Allergen.valueOf(it.name) }
    )
}

fun FoodDishData.toEntity(): FoodDishEntity {
    return FoodDishEntity(
        id = this.id.toLongOrNull() ?: 0L,
        restaurantId = this.restaurantId.toLongOrNull() ?: 0L,
        name = this.name,
        imageResId = this.imageResId,
        price = this.price,
        description = this.description,
        cookingTime = this.cookingTime,
        servingSize = this.servingSize,
        calories = this.calories,
        allergens = this.allergens.map { Allergens.valueOf(it.name) }
    )
}