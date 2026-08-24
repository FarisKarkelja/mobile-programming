package com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util

data class Review(
    val id: String,
    val userId: String,
    val restaurantId: String,
    val comment: String,
    val rating: Float,
    val createdAt: Long
)