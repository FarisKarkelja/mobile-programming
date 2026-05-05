package com.example.mobile_programming.model.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class RestaurantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val cuisine: String,
    @ColumnInfo(name = "category_id")
    val categoryId: String,
    val description: String,
    @ColumnInfo(name = "image")
    val imageResId: Int,
    val location: String,
    val address: String,
    @ColumnInfo(name = "average_price")
    val avgPrice: Double,
    val rating: Double,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false
)