package com.example.mobile_programming.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.White

@Composable
fun RestaurantLocation(
    location: String,
    modifier: Modifier = Modifier,
    iconTint: Color = White,
    textColor: Color = White,
    fontSize: TextUnit = 12.sp
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "Restaurant Location",
            tint = iconTint,
            modifier = Modifier.size(dimensionResource(id = R.dimen.size_18))
        )
        HorizontalSpace(dimensionResource(id = R.dimen.width_4))
        Text(
            text = location,
            fontSize = fontSize,
            color = textColor
        )
    }
}