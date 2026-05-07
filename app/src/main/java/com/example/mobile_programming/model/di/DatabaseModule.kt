package com.example.mobile_programming.model.di

import android.content.Context
import androidx.room.Room
import com.example.mobile_programming.model.data.local.dao.*
import com.example.mobile_programming.model.data.local.db.GricDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): GricDatabase {
        return Room.databaseBuilder(
            context,
            GricDatabase::class.java,
            "gric_database"
        )
            .fallbackToDestructiveMigration(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideRestaurantDao(database: GricDatabase): RestaurantDao {
        return database.restaurantDao()
    }

    @Provides
    @Singleton
    fun provideCategoryDao(database: GricDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: GricDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideDrinkDao(database: GricDatabase): DrinkDao {
        return database.drinkDao()
    }

    @Provides
    @Singleton
    fun provideFoodDishDao(database: GricDatabase): FoodDishDao {
        return database.foodDishDao()
    }

    @Provides
    @Singleton
    fun provideUserRestaurantDao(database: GricDatabase): UserRestaurantDao {
        return database.userRestaurantDao()
    }
}
