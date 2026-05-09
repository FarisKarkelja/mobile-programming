package com.example.mobile_programming.model.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class RestaurantWithFavorite(
    @Embedded val restaurant: RestaurantEntity,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean
)
