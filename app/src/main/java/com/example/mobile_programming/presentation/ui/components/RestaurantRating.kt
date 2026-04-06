package com.example.mobile_programming.presentation.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.Gold
import com.example.mobile_programming.presentation.theme.TextPrimary

@Composable
fun RestaurantRating(
    rating: Double,
    textColor: Color = TextPrimary,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    Icon(
        imageVector = Icons.Default.Star,
        contentDescription = "Restaurant Rating",
        tint = Gold,
        modifier = Modifier.size(dimensionResource(id = R.dimen.size_16))
    )
    HorizontalSpace(dimensionResource(id = R.dimen.width_4))
    Text(
        text = rating.toString(),
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        color = textColor
    )
}