package com.example.mobile_programming.model.repository.drink

import com.example.mobile_programming.presentation.ui.screens.drink_details.util.DrinkData

interface DrinkRepository {
    suspend fun getTopDrinksByRestaurant(restaurantId: Long): List<DrinkData>
    suspend fun getDrinkById(id: Long): DrinkData?
    suspend fun insertDrink(drink: DrinkData)
    suspend fun updateDrink(drink: DrinkData)
    suspend fun deleteDrink(drink: DrinkData)
}