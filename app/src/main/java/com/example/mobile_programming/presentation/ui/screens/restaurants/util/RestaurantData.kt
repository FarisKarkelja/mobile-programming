package com.example.mobile_programming.presentation.ui.screens.restaurants.util

data class Restaurant(
    val id: String,
    val name: String,
    val cuisine: String,
    val categoryId: String,
    val description: String,
    val imageResId: Int,
    val location: String,
    val rating: Double,
    val isFavorite: Boolean = false
)