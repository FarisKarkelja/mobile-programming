package com.example.mobile_programming.presentation.ui.screens.food_dish_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.TextPrimary

@Composable
fun InfoTag(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_24))
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = TextPrimary.copy(alpha = 0.5f),
            fontWeight = FontWeight.Medium
        )
        Text(
            text = value,
            fontSize = 14.sp,
            color = TextPrimary,
            fontWeight = FontWeight.SemiBold
        )
    }
}