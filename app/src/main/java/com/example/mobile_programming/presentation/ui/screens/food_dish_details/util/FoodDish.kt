package com.example.mobile_programming.presentation.ui.screens.food_dish_details.util

enum class ALLERGENS {
    GLUTEN_FREE,
    LACTOSE_FREE,
    VEGETARIAN,
    VEGAN,
    HALAL
}

data class FoodDish(
    val id: String,
    val restaurantId: String,
    val name: String,
    val imageResId: Int,
    val price: Double,
    val description: String,
    val cookingTime: String,
    val servingSize: String,
    val calories: String,
    val allergens: List<ALLERGENS>
)
