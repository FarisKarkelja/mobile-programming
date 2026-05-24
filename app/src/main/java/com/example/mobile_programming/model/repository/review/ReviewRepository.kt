package com.example.mobile_programming.model.repository.review

import com.example.mobile_programming.model.datasource.remote.dto.ReviewDto

interface ReviewRepository {
    suspend fun getReviewsForRestaurant(restaurantId: String): List<ReviewDto>
    suspend fun addReview(review: ReviewDto)
}