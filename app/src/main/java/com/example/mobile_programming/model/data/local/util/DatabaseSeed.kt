package com.example.mobile_programming.model.data.local.util

import com.example.mobile_programming.model.data.local.dao.CategoryDao
import com.example.mobile_programming.model.data.local.dao.DrinkDao
import com.example.mobile_programming.model.data.local.dao.FoodDishDao
import com.example.mobile_programming.model.data.local.dao.RestaurantDao
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DatabaseSeed @Inject constructor(
    private val categoryDao: CategoryDao,
    private val restaurantDao: RestaurantDao,
    private val drinkDao: DrinkDao,
    private val foodDishDao: FoodDishDao
) {
    suspend fun seed() {
        if (categoryDao.getAllCategories().first().isEmpty()) {
            CategorySeed.defaultCategories.forEach { categoryDao.insertCategory(it) }
            RestaurantSeed.defaultRestaurants.forEach { restaurantDao.insertRestaurant(it) }
            DrinkSeed.defaultDrinks.forEach { drinkDao.insertDrink(it) }
            FoodDishSeed.defaultFoodDishes.forEach { foodDishDao.insertDish(it) }
        }
    }
}