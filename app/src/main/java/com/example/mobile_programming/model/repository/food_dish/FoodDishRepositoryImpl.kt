package com.example.mobile_programming.model.repository.food_dish

import com.example.mobile_programming.model.datasource.local.dao.FoodDishDao
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.mappers.toEntity
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDishData
import javax.inject.Inject

class FoodDishRepositoryImpl @Inject constructor(
    private val foodDishDao: FoodDishDao
) : FoodDishRepository {

    override suspend fun getTopDishesByRestaurant(restaurantId: Long): List<FoodDishData> {
        return foodDishDao.getTopDishesByRestaurant(restaurantId).map { it.toDomain() }
    }

    override suspend fun getDishById(id: Long): FoodDishData? {
        return foodDishDao.getDishById(id)?.toDomain()
    }

    override suspend fun insertDish(dish: FoodDishData) {
        foodDishDao.insertDish(dish.toEntity())
    }

    override suspend fun updateDish(dish: FoodDishData) {
        foodDishDao.updateDish(dish.toEntity())
    }

    override suspend fun deleteDish(dish: FoodDishData) {
        foodDishDao.deleteDish(dish.toEntity())
    }
}