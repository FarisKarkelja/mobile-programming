package com.example.mobile_programming.model.datasource.local.util

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.example.mobile_programming.model.datasource.local.entity.RestaurantEntity

data class RestaurantWithFavorite(
    @Embedded val restaurant: RestaurantEntity,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean
)