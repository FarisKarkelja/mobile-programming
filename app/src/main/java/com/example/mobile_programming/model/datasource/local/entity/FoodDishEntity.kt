package com.example.mobile_programming.model.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.mobile_programming.model.datasource.local.util.Allergens

@Entity(
    tableName = "food_dishes",
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
data class FoodDishEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "restaurant_id")
    val restaurantId: Long,
    val name: String,
    @ColumnInfo(name = "image")
    val imageResId: Int,
    val price: Double,
    val description: String,
    @ColumnInfo(name = "cooking_time")
    val cookingTime: String,
    @ColumnInfo(name = "serving_size")
    val servingSize: String,
    val calories: String,
    val allergens: List<Allergens>
)
