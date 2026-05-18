package com.example.mobile_programming.model.repository.drink

import com.example.mobile_programming.model.datasource.local.dao.DrinkDao
import com.example.mobile_programming.model.datasource.local.entity.DrinkEntity
import javax.inject.Inject

class DrinkRepositoryImpl @Inject constructor(
    private val drinkDao: DrinkDao
) : DrinkRepository {
    override suspend fun getTopDrinksByRestaurant(restaurantId: Long): List<DrinkEntity> {
        return drinkDao.getTopDrinksByRestaurant(restaurantId)
    }

    override suspend fun getDrinkById(id: Long): DrinkEntity? {
        return drinkDao.getDrinkById(id)
    }

    override suspend fun insertDrink(drink: DrinkEntity) {
        drinkDao.insertDrink(drink)
    }

    override suspend fun updateDrink(drink: DrinkEntity) {
        drinkDao.updateDrink(drink)
    }

    override suspend fun deleteDrink(drink: DrinkEntity) {
        drinkDao.deleteDrink(drink)
    }
}