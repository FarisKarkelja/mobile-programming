package com.example.mobile_programming.model.repository.food_dish

import com.example.mobile_programming.model.data.local.dao.FoodDishDao
import com.example.mobile_programming.model.data.local.entity.FoodDishEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodDishRepositoryImpl @Inject constructor(
    private val foodDishDao: FoodDishDao
) : FoodDishRepository {
    override fun getDishesForRestaurant(restaurantId: Long): Flow<List<FoodDishEntity>> {
        return foodDishDao.getDishesByRestaurant(restaurantId)
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