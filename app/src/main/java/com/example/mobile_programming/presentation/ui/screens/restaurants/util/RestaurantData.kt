package com.example.mobile_programming.presentation.ui.screens.restaurants.util

import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.FoodDish

data class Restaurant(
    val id: String,
    val name: String,
    val cuisine: String,
    val description: String,
    val imageResId: Int,
    val location: String,
    val rating: Double,
    val isFavorite : Boolean = false,
    val topDishes: List<FoodDish>
)