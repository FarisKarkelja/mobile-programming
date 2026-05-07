package com.example.mobile_programming.model.repository

import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.Drink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DrinkRepository {
    suspend fun getDrink(drinkId: String, shouldFail: Boolean = false): Drink? =
        withContext(Dispatchers.IO) {
            delay(1500)

            if (shouldFail) {
                throw IllegalStateException("Failed to load drink.")
            }

            HardcodedData.drinks.find { it.id == drinkId }
        }
}