package com.example.mobile_programming.model.repository.user_restaurant

import com.example.mobile_programming.model.data.local.entity.RestaurantWithFavorite
import kotlinx.coroutines.flow.Flow

interface UserRestaurantRepository {
    fun getFavoriteRestaurantsByUserId(userId: Long): Flow<List<RestaurantWithFavorite>>

    suspend fun insertFavoriteRestaurant(restaurantId: Long, userId: Long)
    suspend fun deleteFavoriteRestaurant(userId: Long, restaurantId: Long)
}