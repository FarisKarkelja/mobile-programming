package com.example.mobile_programming.model.repository

import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDish
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FoodDishRepository {
    suspend fun getFoodDish(dishId: String, shouldFail: Boolean = false): FoodDish? = withContext(
        Dispatchers.IO
    ) {
        delay(1500)

        if (shouldFail) {
            throw IllegalStateException("Failed to load food dish.")
        }

        HardcodedData.foodDishes.find { it.id == dishId }
    }
}