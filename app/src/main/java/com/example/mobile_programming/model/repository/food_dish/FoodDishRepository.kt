package com.example.mobile_programming.model.repository.food_dish

import com.example.mobile_programming.model.data.local.entity.FoodDishEntity
import kotlinx.coroutines.flow.Flow

interface FoodDishRepository {
    fun getTopDishesByRestaurant(restaurantId: Long): Flow<List<FoodDishEntity>>
    suspend fun getDishById(id: Long): FoodDishEntity?
    suspend fun insertDish(dish: FoodDishEntity)
    suspend fun updateDish(dish: FoodDishEntity)
    suspend fun deleteDish(dish: FoodDishEntity)
}