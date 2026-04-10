package com.example.mobile_programming.presentation.ui.screens.categories.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.ui.components.VerticalSpace

@Composable
fun CategoryCircle(
    title: String,
    iconResource: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.size_100))
            .shadow(dimensionResource(id = R.dimen.elevation_8), CircleShape)
            .clip(CircleShape)
            .background(SunsetTangerine)
            .clickable { onClick() }
            .padding(dimensionResource(id = R.dimen.padding_8))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconResource),
                contentDescription = title,
                modifier = Modifier.size(dimensionResource(id = R.dimen.size_36))
            )
            VerticalSpace(dimensionResource(id = R.dimen.height_6))
            Text(
                text = title.uppercase(),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = White,
                lineHeight = 14.sp
            )
        }
    }
}