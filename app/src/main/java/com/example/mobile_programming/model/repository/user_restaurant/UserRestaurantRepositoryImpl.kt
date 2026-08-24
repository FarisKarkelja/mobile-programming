package com.example.mobile_programming.model.repository.user_restaurant

import com.example.mobile_programming.model.datasource.local.dao.UserRestaurantDao
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRestaurantRepositoryImpl @Inject constructor(
    private val userRestaurantDao: UserRestaurantDao
) : UserRestaurantRepository {
    override fun getFavoriteRestaurantsByUserId(userId: Long): Flow<List<Restaurant>> {
        return userRestaurantDao.getFavoriteRestaurantsByUserId(userId).map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun insertFavoriteRestaurant(restaurantId: Long, userId: Long) {
        userRestaurantDao.insertFavoriteRestaurant(restaurantId, userId)
    }

    override suspend fun deleteFavoriteRestaurant(userId: Long, restaurantId: Long) {
        userRestaurantDao.deleteFavoriteRestaurant(userId, restaurantId)
    }
}