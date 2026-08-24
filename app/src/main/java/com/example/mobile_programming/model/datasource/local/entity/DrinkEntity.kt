package com.example.mobile_programming.model.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "drinks",
    foreignKeys = [
        ForeignKey(
            entity = RestaurantEntity::class,
            parentColumns = ["id"],
            childColumns = ["restaurant_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["restaurant_id"])]
)
data class DrinkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "restaurant_id")
    val restaurantId: Long,
    val name: String,
    @ColumnInfo(name = "image")
    val imageResId: Int,
    val price: Double,
    val description: String,
    @ColumnInfo(name = "is_alcoholic")
    val isAlcoholic: Boolean,
    @ColumnInfo(name = "is_sugar_free")
    val isSugarFree: Boolean
)