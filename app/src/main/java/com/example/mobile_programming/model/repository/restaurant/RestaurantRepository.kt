package com.example.mobile_programming.model.repository.restaurant

import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    fun getFilteredRestaurants(
        userId: Long,
        categoryId: Long,
        startValue: Int,
        endValue: Int,
        location: String,
        minRating: Float
    ): Flow<List<Restaurant>>

    suspend fun getRestaurantById(restaurantId: Long): Restaurant?
    suspend fun insertRestaurant(restaurant: Restaurant)
    suspend fun updateRestaurant(restaurant: Restaurant)
    suspend fun deleteRestaurant(restaurant: Restaurant)
}