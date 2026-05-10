package com.example.mobile_programming.model.di

import android.content.Context
import androidx.room.Room
import com.example.mobile_programming.model.data.local.dao.*
import com.example.mobile_programming.model.data.local.db.GricDatabase
import com.example.mobile_programming.model.data.local.util.DatabaseSeed
import com.example.mobile_programming.model.repository.category.CategoryRepository
import com.example.mobile_programming.model.repository.category.CategoryRepositoryImpl
import com.example.mobile_programming.model.repository.drink.DrinkRepository
import com.example.mobile_programming.model.repository.drink.DrinkRepositoryImpl
import com.example.mobile_programming.model.repository.filter.FilterRepository
import com.example.mobile_programming.model.repository.filter.FilterRepositoryImpl
import com.example.mobile_programming.model.repository.food_dish.FoodDishRepository
import com.example.mobile_programming.model.repository.food_dish.FoodDishRepositoryImpl
import com.example.mobile_programming.model.repository.restaurant.RestaurantRepository
import com.example.mobile_programming.model.repository.restaurant.RestaurantRepositoryImpl
import com.example.mobile_programming.model.repository.user.SessionRepository
import com.example.mobile_programming.model.repository.user.SessionRepositoryImpl
import com.example.mobile_programming.model.repository.user.UserRepository
import com.example.mobile_programming.model.repository.user.UserRepositoryImpl
import com.example.mobile_programming.model.repository.user_restaurant.UserRestaurantRepository
import com.example.mobile_programming.model.repository.user_restaurant.UserRestaurantRepositoryImpl
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
    fun provideRestaurantRepository(restaurantDao: RestaurantDao): RestaurantRepository {
        return RestaurantRepositoryImpl(restaurantDao)
    }

    @Provides
    @Singleton
    fun provideCategoryDao(database: GricDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(categoryDao: CategoryDao): CategoryRepository {
        return CategoryRepositoryImpl(categoryDao)
    }

    @Provides
    @Singleton
    fun provideUserDao(database: GricDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepositoryImpl(userDao)
    }

    @Provides
    @Singleton
    fun provideDrinkDao(database: GricDatabase): DrinkDao {
        return database.drinkDao()
    }

    @Provides
    @Singleton
    fun provideDrinkRepository(drinkDao: DrinkDao): DrinkRepository {
        return DrinkRepositoryImpl(drinkDao)
    }

    @Provides
    @Singleton
    fun provideFoodDishDao(database: GricDatabase): FoodDishDao {
        return database.foodDishDao()
    }

    @Provides
    @Singleton
    fun provideFoodDishRepository(foodDishDao: FoodDishDao): FoodDishRepository {
        return FoodDishRepositoryImpl(foodDishDao)
    }

    @Provides
    @Singleton
    fun provideUserRestaurantDao(database: GricDatabase): UserRestaurantDao {
        return database.userRestaurantDao()
    }

    @Provides
    @Singleton
    fun provideUserRestaurantRepository(userRestaurantDao: UserRestaurantDao): UserRestaurantRepository {
        return UserRestaurantRepositoryImpl(userRestaurantDao)
    }

    @Provides
    @Singleton
    fun provideFilterRepository(): FilterRepository {
        return FilterRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideDatabaseSeeder(
        categoryDao: CategoryDao,
        restaurantDao: RestaurantDao,
        drinkDao: DrinkDao,
        foodDishDao: FoodDishDao
    ): DatabaseSeed {
        return DatabaseSeed(categoryDao, restaurantDao, drinkDao, foodDishDao)
    }

    @Provides
    @Singleton
    fun provideSessionRepository(
        @ApplicationContext context: Context
    ): SessionRepository {
        return SessionRepositoryImpl(context)
    }
}
