package com.example.mobile_programming.model.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.mobile_programming.model.data.local.entity.UserRestaurantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserRestaurantDao {
    @Query("SELECT * FROM user_favorites WHERE user_id = :userId")
    fun getFavoritesByUserId(userId: Long): Flow<List<UserRestaurantEntity>>

    @Query("INSERT INTO user_favorites (restaurant_id, user_id) VALUES (:restaurantId, :userId)")
    suspend fun insertFavoriteRestaurant(restaurantId: Long, userId: Long)

    @Query("DELETE FROM user_favorites WHERE user_id = :userId AND restaurant_id = :restaurantId")
    suspend fun deleteFavoriteRestaurant(userId: Long, restaurantId: Long)

    @Update
    suspend fun updateFavorite(userRestaurant: UserRestaurantEntity)
}