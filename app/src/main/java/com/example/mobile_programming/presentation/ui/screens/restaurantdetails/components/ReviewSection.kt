package com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.Review

@Composable
fun ReviewSection(
    reviews: List<Review>,
    onAddReview: (comment: String, rating: Float) -> Unit
) {
    var comment by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf(3f) }

    VerticalSpace(height = dimensionResource(R.dimen.height_8))

    if (reviews.isEmpty()) {
        Text(text = "No reviews yet. Be the first!", color = TextPrimary.copy(alpha = 0.5f))
    } else {
        reviews.forEach { review ->
            ReviewItem(review = review)
            VerticalSpace(height = dimensionResource(R.dimen.height_8))
        }
    }

    VerticalSpace(height = dimensionResource(R.dimen.height_16))

    Text(text = "Leave a Review", fontWeight = FontWeight.SemiBold, color = TextPrimary)
    VerticalSpace(height = dimensionResource(R.dimen.height_8))

    OutlinedTextField(
        value = comment,
        onValueChange = { comment = it },
        label = { Text("Comment") },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_12)),
        colors = TextFieldDefaults.colors(
            focusedTextColor = TextPrimary,
            unfocusedTextColor = TextPrimary,
            focusedContainerColor = White,
            unfocusedContainerColor = White
        )
    )

    VerticalSpace(height = dimensionResource(R.dimen.height_8))

    Text(text = "Rating: ${"%.1f".format(rating)}", color = TextPrimary)
    Slider(
        value = rating,
        onValueChange = { rating = it },
        valueRange = 1f..5f,
        steps = 3,
        colors = SliderDefaults.colors(
            thumbColor = SunsetTangerine,
            activeTrackColor = SunsetTangerine
        ),
        modifier = Modifier.fillMaxWidth()
    )

    VerticalSpace(height = dimensionResource(R.dimen.height_8))
    Button(
        onClick = {
            if (comment.isNotBlank()) {
                onAddReview(comment, rating)
                comment = ""
                rating = 3f
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = SunsetTangerine,
            contentColor = White
        ),
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_12)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Submit Review")
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewSectionEmptyPreview() {
    ReviewSection(
        reviews = emptyList(),
        onAddReview = { _, _ -> }
    )
}

@Preview(showBackground = true)
@Composable
fun ReviewSectionWithReviewsPreview() {
    val sampleReviews = listOf(
        Review(
            id = "rev_1",
            restaurantId = "r_10",
            userId = "u_1",
            rating = 5.0f,
            comment = "Amazing food! The chicken tortilla was packed with flavor.",
            createdAt = System.currentTimeMillis()
        ),
        Review(
            id = "rev_2",
            restaurantId = "r_10",
            userId = "u_2",
            rating = 4.0f,
            comment = "Really good service, but the food took a bit long to arrive.",
            createdAt = System.currentTimeMillis()
        )
    )

    ReviewSection(
        reviews = sampleReviews,
        onAddReview = { _, _ -> }
    )
}