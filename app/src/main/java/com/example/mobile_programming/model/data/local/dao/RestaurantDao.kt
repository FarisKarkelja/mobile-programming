package com.example.mobile_programming.model.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mobile_programming.model.data.local.entity.RestaurantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Query(
        """
        SELECT * FROM restaurants
        WHERE category_id = :categoryId 
        AND average_price BETWEEN :startValue AND :endValue
        AND location = :location
        AND rating >= :minRating
    """
    )
    fun getFilteredRestaurants(
        categoryId: Long,
        startValue: Int,
        endValue: Int,
        location: String,
        minRating: Float
    ): Flow<List<RestaurantEntity>>

    @Query("SELECT * FROM restaurants WHERE id = :restaurantId LIMIT 1")
    suspend fun getRestaurantById(restaurantId: Long): RestaurantEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurant: RestaurantEntity)

    @Update
    suspend fun updateRestaurant(restaurant: RestaurantEntity)

    @Delete
    suspend fun deleteRestaurant(restaurant: RestaurantEntity)
}