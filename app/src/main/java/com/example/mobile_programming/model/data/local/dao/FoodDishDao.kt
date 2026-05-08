package com.example.mobile_programming.model.data.local.dao

import androidx.room.*
import com.example.mobile_programming.model.data.local.entity.FoodDishEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDishDao {
    @Query("SELECT * FROM food_dishes WHERE restaurant_id = :restaurantId")
    fun getDishesByRestaurant(restaurantId: Long): Flow<List<FoodDishEntity>>

    @Query("SELECT * FROM food_dishes WHERE id = :id LIMIT 1")
    suspend fun getDishById(id: Long): FoodDishEntity?

    @Insert
    suspend fun insertDish(dish: FoodDishEntity)

    @Update
    suspend fun updateDish(dish: FoodDishEntity)

    @Delete
    suspend fun deleteDish(dish: FoodDishEntity)
}