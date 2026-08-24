package com.example.mobile_programming.model.repository.drink

import com.example.mobile_programming.model.datasource.local.dao.DrinkDao
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.mappers.toEntity
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.DrinkData
import javax.inject.Inject

class DrinkRepositoryImpl @Inject constructor(
    private val drinkDao: DrinkDao
) : DrinkRepository {

    override suspend fun getTopDrinksByRestaurant(restaurantId: Long): List<DrinkData> {
        return drinkDao.getTopDrinksByRestaurant(restaurantId).map { it.toDomain() }
    }

    override suspend fun getDrinkById(id: Long): DrinkData? {
        return drinkDao.getDrinkById(id)?.toDomain()
    }

    override suspend fun insertDrink(drink: DrinkData) {
        drinkDao.insertDrink(drink.toEntity())
    }

    override suspend fun updateDrink(drink: DrinkData) {
        drinkDao.updateDrink(drink.toEntity())
    }

    override suspend fun deleteDrink(drink: DrinkData) {
        drinkDao.deleteDrink(drink.toEntity())
    }
}