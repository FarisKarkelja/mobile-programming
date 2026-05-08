package com.example.mobile_programming.model.repository.drink

import com.example.mobile_programming.model.data.local.entity.DrinkEntity
import kotlinx.coroutines.flow.Flow

interface DrinkRepository {
    fun getTopDrinksByRestaurant(restaurantId: Long): Flow<List<DrinkEntity>>
    suspend fun getDrinkById(id: Long): DrinkEntity?
    suspend fun insertDrink(drink: DrinkEntity)
    suspend fun updateDrink(drink: DrinkEntity)
    suspend fun deleteDrink(drink: DrinkEntity)
}