package com.example.mobile_programming.model.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.mobile_programming.model.data.local.util.RestaurantWithFavorite
import kotlinx.coroutines.flow.Flow

@Dao
interface UserRestaurantDao {
    @Query(
        """
    SELECT r.*, 1 as is_favorite
    FROM restaurants r
    INNER JOIN user_favorites uf ON r.id = uf.restaurant_id
    WHERE uf.user_id = :userId
    """
    )
    fun getFavoriteRestaurantsByUserId(userId: Long): Flow<List<RestaurantWithFavorite>>

    @Query("INSERT INTO user_favorites (restaurant_id, user_id) VALUES (:restaurantId, :userId)")
    suspend fun insertFavoriteRestaurant(restaurantId: Long, userId: Long)

    @Query("DELETE FROM user_favorites WHERE user_id = :userId AND restaurant_id = :restaurantId")
    suspend fun deleteFavoriteRestaurant(userId: Long, restaurantId: Long)
}