package com.example.mobile_programming.presentation.navigation.bottomBar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarNavigationItem(
    val titleId: Int,
    val icon: ImageVector,
    val route: String,
)