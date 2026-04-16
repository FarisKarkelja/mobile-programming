package com.example.mobile_programming.presentation.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.presentation.theme.TextPrimary

@Composable
fun RestaurantTitle(title: String, fontSize: TextUnit = 26.sp, color: Color = TextPrimary) {
    Text(
        text = title,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        color = color
    )
}