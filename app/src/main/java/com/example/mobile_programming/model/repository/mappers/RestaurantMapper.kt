package com.example.mobile_programming.model.repository.mappers

import com.example.mobile_programming.model.data.local.entity.RestaurantEntity
import com.example.mobile_programming.model.data.local.util.RestaurantWithFavorite
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant

fun RestaurantEntity.toDomain(): Restaurant {
    return Restaurant(
        id = this.id.toString(),
        name = this.name,
        cuisine = this.cuisine,
        categoryId = this.categoryId.toString(),
        description = this.description,
        imageResId = this.imageResId,
        location = this.location,
        address = this.address,
        avgPrice = this.avgPrice,
        rating = this.rating,
        isFavorite = false
    )
}

fun RestaurantWithFavorite.toDomain(): Restaurant {
    return Restaurant(
        id = this.restaurant.id.toString(),
        name = this.restaurant.name,
        cuisine = this.restaurant.cuisine,
        categoryId = this.restaurant.categoryId.toString(),
        description = this.restaurant.description,
        imageResId = this.restaurant.imageResId,
        location = this.restaurant.location,
        address = this.restaurant.address,
        avgPrice = this.restaurant.avgPrice,
        rating = this.restaurant.rating,
        isFavorite = this.isFavorite
    )
}