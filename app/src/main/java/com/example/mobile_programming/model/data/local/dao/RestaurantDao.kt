package com.example.mobile_programming.model.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mobile_programming.model.data.local.entity.RestaurantEntity
import com.example.mobile_programming.model.data.local.entity.RestaurantWithFavorite
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Query(
        """
    SELECT r.*, 
    CASE WHEN uf.restaurant_id IS NOT NULL THEN 1 ELSE 0 END as is_favorite
    FROM restaurants r
    LEFT JOIN user_favorites uf 
        ON r.id = uf.restaurant_id AND uf.user_id = :userId
    WHERE r.category_id = :categoryId 
    AND r.average_price BETWEEN :startValue AND :endValue
    AND r.location = :location
    AND r.rating >= :minRating
"""
    )
    fun getFilteredRestaurants(
        userId: Long,
        categoryId: Long,
        startValue: Int,
        endValue: Int,
        location: String,
        minRating: Float
    ): Flow<List<RestaurantWithFavorite>>

    @Query("SELECT * FROM restaurants WHERE id = :restaurantId LIMIT 1")
    suspend fun getRestaurantById(restaurantId: Long): RestaurantEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurant: RestaurantEntity)

    @Update
    suspend fun updateRestaurant(restaurant: RestaurantEntity)

    @Delete
    suspend fun deleteRestaurant(restaurant: RestaurantEntity)
}