package com.example.mobile_programming.presentation.navigation.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.FavoriteBorder
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.navigation.Screen

object BottomBarNavigationItems {
    val items = listOf(
        BottomBarNavigationItem(
            titleId = R.string.explore,
            icon = Icons.Outlined.Explore,
            route = Screen.Categories.route
        ),
        BottomBarNavigationItem(
            titleId = R.string.favorites,
            icon = Icons.Outlined.FavoriteBorder,
            route = Screen.FavoriteRestaurants.route
        ),
        BottomBarNavigationItem(
            titleId = R.string.profile,
            icon = Icons.Outlined.AccountCircle,
            route = Screen.Profile.route
        )
    )
}