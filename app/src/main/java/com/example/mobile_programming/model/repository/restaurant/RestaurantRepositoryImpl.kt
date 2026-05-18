package com.example.mobile_programming.model.repository.restaurant

import com.example.mobile_programming.model.datasource.local.dao.RestaurantDao
import com.example.mobile_programming.model.datasource.local.entity.RestaurantEntity
import com.example.mobile_programming.model.datasource.local.util.RestaurantWithFavorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val restaurantDao: RestaurantDao
) : RestaurantRepository {
    override fun getFilteredRestaurants(
        userId: Long,
        categoryId: Long,
        startValue: Int,
        endValue: Int,
        location: String,
        minRating: Float
    ): Flow<List<RestaurantWithFavorite>> {
        return restaurantDao.getFilteredRestaurants(
            userId,
            categoryId,
            startValue,
            endValue,
            location,
            minRating
        )
    }

    override suspend fun getRestaurantById(restaurantId: Long): RestaurantEntity? {
        return restaurantDao.getRestaurantById(restaurantId)
    }

    override suspend fun insertRestaurant(restaurant: RestaurantEntity) {
        restaurantDao.insertRestaurant(restaurant)
    }

    override suspend fun updateRestaurant(restaurant: RestaurantEntity) {
        restaurantDao.updateRestaurant(restaurant)
    }

    override suspend fun deleteRestaurant(restaurant: RestaurantEntity) {
        restaurantDao.deleteRestaurant(restaurant)
    }
}