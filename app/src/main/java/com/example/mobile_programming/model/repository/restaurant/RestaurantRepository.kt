package com.example.mobile_programming.model.repository.restaurant

import com.example.mobile_programming.model.data.local.entity.RestaurantEntity
import com.example.mobile_programming.model.data.local.entity.RestaurantWithFavorite
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    fun getFilteredRestaurants(
        userId: Long,
        categoryId: Long,
        startValue: Int,
        endValue: Int,
        location: String,
        minRating: Float
    ): Flow<List<RestaurantWithFavorite>>

    suspend fun getRestaurantById(restaurantId: Long): RestaurantEntity?
    suspend fun insertRestaurant(restaurant: RestaurantEntity)
    suspend fun updateRestaurant(restaurant: RestaurantEntity)
    suspend fun deleteRestaurant(restaurant: RestaurantEntity)
}