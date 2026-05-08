package com.example.mobile_programming.model.data.local.dao

import androidx.room.*
import com.example.mobile_programming.model.data.local.entity.DrinkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DrinkDao {
    @Query("SELECT * FROM drinks WHERE restaurant_id = :restaurantId LIMIT 5")
    fun getTopDrinksByRestaurant(restaurantId: Long): Flow<List<DrinkEntity>>

    @Query("SELECT * FROM drinks WHERE id = :id LIMIT 1")
    suspend fun getDrinkById(id: Long): DrinkEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrink(drink: DrinkEntity)

    @Update
    suspend fun updateDrink(drink: DrinkEntity)

    @Delete
    suspend fun deleteDrink(drink: DrinkEntity)
}