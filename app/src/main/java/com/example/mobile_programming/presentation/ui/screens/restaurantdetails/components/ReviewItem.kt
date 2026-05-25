package com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.model.datasource.remote.dto.ReviewDto
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.ui.components.HorizontalSpace
import com.example.mobile_programming.presentation.ui.components.VerticalSpace

@Composable
fun ReviewItem(review: ReviewDto) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_12)),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_12))) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating Star",
                    tint = SunsetTangerine,
                    modifier = Modifier.size(18.dp)
                )
                HorizontalSpace(width = 4.dp)
                Text(
                    text = "%.1f".format(review.rating),
                    color = SunsetTangerine,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            VerticalSpace(height = 4.dp)
            Text(text = review.comment, color = TextPrimary, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewItemPreview() {
    val singleReview = ReviewDto(
        id = "rev_1",
        restaurantId = "r_10",
        userId = "u_1",
        rating = 4.5f,
        comment = "The handmade tortillas were absolute perfection! Highly recommend."
    )
    ReviewItem(review = singleReview)
}