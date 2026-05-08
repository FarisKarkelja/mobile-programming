package com.example.mobile_programming.model.repository.drink

import com.example.mobile_programming.model.data.local.dao.DrinkDao
import com.example.mobile_programming.model.data.local.entity.DrinkEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DrinkRepositoryImpl @Inject constructor(
    private val drinkDao: DrinkDao
) : DrinkRepository {
    override fun getTopDrinksByRestaurant(restaurantId: Long): Flow<List<DrinkEntity>> {
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