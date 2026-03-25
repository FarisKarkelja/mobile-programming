package com.example.mobile_programming.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.White

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.height_56))
            .background(TextPrimary),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Dashboard",
            tint = White
        )

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite Restaurants",
            tint = White
        )

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile",
            tint = White
        )
    }
}