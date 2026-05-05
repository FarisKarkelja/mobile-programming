package com.example.mobile_programming.model.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.ALLERGENS

@Entity(tableName = "food_dishes")
data class FoodDishEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    // FK constraint logic
    val restaurantId: String,
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
    val allergens: List<ALLERGENS>
)

enum class ALLERGENS {
    GLUTEN_FREE,
    LACTOSE_FREE,
    VEGETARIAN,
    VEGAN,
    HALAL
}
