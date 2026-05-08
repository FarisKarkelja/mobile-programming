package com.example.mobile_programming.model.repository.mappers

import com.example.mobile_programming.model.data.local.entity.FoodDishEntity
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDish

fun FoodDishEntity.toDomain(): FoodDish {
    return FoodDish(
        id = this.id.toString(),
        restaurantId = this.restaurantId.toString(),
        name = this.name,
        imageResId = this.imageResId,
        price = this.price,
        description = this.description,
        cookingTime = this.cookingTime,
        servingSize = this.servingSize,
        calories = this.calories,
        allergens = this.allergens
    )
}