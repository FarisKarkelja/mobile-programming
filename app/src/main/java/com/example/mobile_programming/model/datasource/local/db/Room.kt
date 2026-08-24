package com.example.mobile_programming.model.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mobile_programming.model.datasource.local.dao.*
import com.example.mobile_programming.model.datasource.local.entity.*
import com.example.mobile_programming.model.datasource.local.util.Converters

@Database(
    entities = [RestaurantEntity::class, CategoryEntity::class, DrinkEntity::class, FoodDishEntity::class, UserEntity::class, UserRestaurantEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class GricDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun restaurantDao(): RestaurantDao
    abstract fun categoryDao(): CategoryDao
    abstract fun drinkDao(): DrinkDao
    abstract fun foodDishDao(): FoodDishDao
    abstract fun userRestaurantDao(): UserRestaurantDao
}
