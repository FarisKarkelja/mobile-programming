package com.example.mobile_programming.model.repository.food_dish

import com.example.mobile_programming.model.datasource.local.dao.FoodDishDao
import com.example.mobile_programming.model.datasource.local.entity.FoodDishEntity
import javax.inject.Inject

class FoodDishRepositoryImpl @Inject constructor(
    private val foodDishDao: FoodDishDao
) : FoodDishRepository {
    override suspend fun getTopDishesByRestaurant(restaurantId: Long): List<FoodDishEntity> {
        return foodDishDao.getTopDishesByRestaurant(restaurantId)
    }

    override suspend fun getDishById(id: Long): FoodDishEntity? {
        return foodDishDao.getDishById(id)
    }

    override suspend fun insertDish(dish: FoodDishEntity) {
        foodDishDao.insertDish(dish)
    }

    override suspend fun updateDish(dish: FoodDishEntity) {
        foodDishDao.updateDish(dish)
    }

    override suspend fun deleteDish(dish: FoodDishEntity) {
        foodDishDao.deleteDish(dish)
    }
}