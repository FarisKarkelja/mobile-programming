package com.example.mobile_programming.model.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "restaurants",
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["category_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["category_id"])]
)
data class RestaurantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val cuisine: String,
    @ColumnInfo(name = "category_id")
    val categoryId: Int,
    val description: String,
    @ColumnInfo(name = "image")
    val imageResId: Int,
    val location: String,
    val address: String,
    @ColumnInfo(name = "average_price")
    val avgPrice: Double,
    val rating: Double
)