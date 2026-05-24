package com.example.mobile_programming.model.datasource.remote.dto

data class ReviewDto(
    val id: String = "",
    val userId: String = "",
    val restaurantId: String = "",
    val comment: String = "",
    val rating: Float = 0f,
    val createdAt: Long = 0L
)