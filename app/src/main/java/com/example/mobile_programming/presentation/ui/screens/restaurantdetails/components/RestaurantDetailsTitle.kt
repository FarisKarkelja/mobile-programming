package com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.presentation.theme.TextPrimary

@Composable
fun RestaurantDetailsTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = TextPrimary
    )
}