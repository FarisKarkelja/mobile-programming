package com.example.mobile_programming.model.repository.review

import com.example.mobile_programming.model.datasource.remote.dto.ReviewDto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : ReviewRepository {
    override suspend fun getReviewsForRestaurant(restaurantId: String): List<ReviewDto> {
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
            )
        }
    }

    override suspend fun addReview(review: ReviewDto) {
        val reviewData = hashMapOf(
            "userId" to review.userId,
            "restaurantId" to review.restaurantId,
            "comment" to review.comment,
            "rating" to review.rating,
            "createdAt" to review.createdAt
        )
        firestore.collection("reviews").add(reviewData).await()
    }
}