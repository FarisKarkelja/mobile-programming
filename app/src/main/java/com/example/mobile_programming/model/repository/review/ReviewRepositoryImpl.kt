package com.example.mobile_programming.model.repository.review

import com.example.mobile_programming.model.datasource.remote.dto.ReviewDto
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.mappers.toDto
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.Review
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : ReviewRepository {
    override suspend fun getReviewsForRestaurant(restaurantId: String): List<Review> {
        val snapshot = firestore.collection("reviews")
            .whereEqualTo("restaurantId", restaurantId)
            .get()
            .await()

        return snapshot.documents.mapNotNull { doc ->
            ReviewDto(
                id = doc.id,
                userId = doc.getString("userId") ?: "",
                restaurantId = doc.getString("restaurantId") ?: "",
                comment = doc.getString("comment") ?: "",
                rating = doc.getDouble("rating")?.toFloat() ?: 0f,
                createdAt = doc.getLong("createdAt") ?: 0L
            ).toDomain()
        }
    }

    override suspend fun addReview(review: Review) {
        val reviewDto = review.toDto()
        firestore.collection("reviews").add(reviewDto).await()
    }
}