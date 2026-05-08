package com.example.mobile_programming.model.repository.user_restaurant

import com.example.mobile_programming.model.data.local.dao.UserRestaurantDao
import com.example.mobile_programming.model.data.local.entity.UserRestaurantEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRestaurantRepositoryImpl @Inject constructor(
    private val userRestaurantDao: UserRestaurantDao
) : UserRestaurantRepository {
    override fun getFavoritesByUserId(userId: Long): Flow<List<UserRestaurantEntity>> {
        return userRestaurantDao.getFavoritesByUserId(userId)
    }

    override suspend fun insertFavoriteRestaurant(restaurantId: Long, userId: Long) {
        userRestaurantDao.insertFavoriteRestaurant(restaurantId, userId)
    }

    override suspend fun deleteFavoriteRestaurant(userId: Long, restaurantId: Long) {
        userRestaurantDao.deleteFavoriteRestaurant(userId, restaurantId)
    }

    override suspend fun updateFavorite(userRestaurant: UserRestaurantEntity) {
        userRestaurantDao.updateFavorite(userRestaurant)
    }
}