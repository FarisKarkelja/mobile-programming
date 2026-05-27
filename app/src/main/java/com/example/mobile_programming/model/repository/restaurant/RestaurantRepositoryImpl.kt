package com.example.mobile_programming.model.repository.restaurant

import com.example.mobile_programming.model.datasource.local.dao.RestaurantDao
import com.example.mobile_programming.model.datasource.local.util.RestaurantWithFavorite
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.mappers.toEntity
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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
    ): Flow<List<Restaurant>> {
        return restaurantDao.getFilteredRestaurants(
            userId,
            categoryId,
            startValue,
            endValue,
            location,
            minRating
        ).map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun getRestaurantById(restaurantId: Long): Restaurant? {
        return restaurantDao.getRestaurantById(restaurantId)?.toDomain()
    }

    override suspend fun insertRestaurant(restaurant: Restaurant) {
        restaurantDao.insertRestaurant(restaurant.toEntity())
    }

    override suspend fun updateRestaurant(restaurant: Restaurant) {
        restaurantDao.updateRestaurant(restaurant.toEntity())
    }

    override suspend fun deleteRestaurant(restaurant: Restaurant) {
        restaurantDao.deleteRestaurant(restaurant.toEntity())
    }
}