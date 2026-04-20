package com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream

@Composable
fun FavoriteRestaurantsCategoryTitle(
    categoryName: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(TextPrimary)
            .padding(
                horizontal = dimensionResource(id = R.dimen.padding_16),
                vertical = dimensionResource(id = R.dimen.padding_12)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = categoryName.uppercase(),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = WarmCream
        )
    }
}