package com.example.mobile_programming.model.repository.user_restaurant

import com.example.mobile_programming.model.data.local.entity.UserRestaurantEntity
import kotlinx.coroutines.flow.Flow

interface UserRestaurantRepository {
    fun getFavoritesByUserId(userId: Long): Flow<List<UserRestaurantEntity>>
    suspend fun insertFavoriteRestaurant(restaurantId: Long, userId: Long)
    suspend fun deleteFavoriteRestaurant(userId: Long, restaurantId: Long)
    suspend fun updateFavorite(userRestaurant: UserRestaurantEntity)
}