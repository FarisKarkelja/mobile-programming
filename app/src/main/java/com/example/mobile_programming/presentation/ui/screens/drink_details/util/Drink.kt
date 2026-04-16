package com.example.mobile_programming.presentation.ui.screens.drink_details.util

data class Drink(
    val id: String,
    val restaurantId: String,
    val name: String,
    val imageResId: Int,
    val price: Double,
    val description: String,
    val isAlcoholic: Boolean,
    val isSugarFree: Boolean
)