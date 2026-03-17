package com.example.mobile_programming.presentation.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpace(height: Dp = 12.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun HorizontalSpace(width: Dp = 12.dp) {
    Spacer(modifier = Modifier.width(width))
}