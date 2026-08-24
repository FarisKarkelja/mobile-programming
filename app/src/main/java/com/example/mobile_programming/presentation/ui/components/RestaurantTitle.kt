package com.example.mobile_programming.presentation.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showBackground = true)
@Composable
fun RestaurantTitleDefaultPreview() {
    RestaurantTitle(title = "Restaurant Title")
}

@Preview(showBackground = true)
@Composable
fun RestaurantTitleCustomPreview() {
    RestaurantTitle(
        title = "Gourmet Restoran",
        fontSize = 32.sp,
        color = Color.Red
    )
}