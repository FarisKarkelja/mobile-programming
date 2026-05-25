package com.example.mobile_programming.presentation.ui.screens.restaurants.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.R

@Composable
fun SortOptionsRow(
    onSortAZClick: () -> Unit,
    onSortZAClick: () -> Unit,
    onSortRatingLowClick: () -> Unit,
    onSortRatingHighClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.padding_8),
                vertical = dimensionResource(id = R.dimen.padding_8)
            ),
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.padding_8),
            Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LexicographicSortButton(
            text = "A - Z",
            onClick = onSortAZClick
        )
        LexicographicSortButton(
            text = "Z - A",
            onClick = onSortZAClick
        )
        RatingSortButton(
            text = "Low",
            onClick = onSortRatingLowClick
        )
        RatingSortButton(
            text = "High",
            onClick = onSortRatingHighClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SortOptionsRowPreview() {
    SortOptionsRow(
        onSortAZClick = {},
        onSortZAClick = {},
        onSortRatingLowClick = {},
        onSortRatingHighClick = {}
    )
}