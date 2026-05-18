package com.example.mobile_programming.model.repository.food_dish

import com.example.mobile_programming.model.datasource.local.entity.FoodDishEntity

interface FoodDishRepository {
    suspend fun getTopDishesByRestaurant(restaurantId: Long): List<FoodDishEntity>
    suspend fun getDishById(id: Long): FoodDishEntity?
    suspend fun insertDish(dish: FoodDishEntity)
    suspend fun updateDish(dish: FoodDishEntity)
    suspend fun deleteDish(dish: FoodDishEntity)
}