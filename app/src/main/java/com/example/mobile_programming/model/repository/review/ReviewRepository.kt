package com.example.mobile_programming.model.repository.review

import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.Review

interface ReviewRepository {
    suspend fun getReviewsForRestaurant(restaurantId: String): List<Review>
    suspend fun addReview(review: Review)
}