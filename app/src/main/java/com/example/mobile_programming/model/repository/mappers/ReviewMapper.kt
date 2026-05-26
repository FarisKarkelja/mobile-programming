package com.example.mobile_programming.model.repository.mappers

import com.example.mobile_programming.model.datasource.remote.dto.ReviewDto
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.Review

fun ReviewDto.toDomain(): Review {
    return Review(
        id = this.id,
        userId = this.userId,
        restaurantId = this.restaurantId,
        comment = this.comment,
        rating = this.rating,
        createdAt = this.createdAt
    )
}

fun Review.toDto(): ReviewDto {
    return ReviewDto(
        id = this.id,
        userId = this.userId,
        restaurantId = this.restaurantId,
        comment = this.comment,
        rating = this.rating,
        createdAt = this.createdAt
    )
}