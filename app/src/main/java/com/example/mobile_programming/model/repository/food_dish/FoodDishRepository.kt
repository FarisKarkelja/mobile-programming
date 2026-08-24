package com.example.mobile_programming.model.repository.food_dish

import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDishData

interface FoodDishRepository {
    suspend fun getTopDishesByRestaurant(restaurantId: Long): List<FoodDishData>
    suspend fun getDishById(id: Long): FoodDishData?
    suspend fun insertDish(dish: FoodDishData)
    suspend fun updateDish(dish: FoodDishData)
    suspend fun deleteDish(dish: FoodDishData)
}