package com.example.mobile_programming.model.repository.mappers

import com.example.mobile_programming.model.data.local.entity.RestaurantEntity
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
        rating = this.rating
    )
}