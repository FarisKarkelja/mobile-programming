package com.example.mobile_programming.presentation.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.R

@Composable
fun VerticalSpace(height: Dp = dimensionResource(id = R.dimen.height_12)) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun HorizontalSpace(width: Dp = dimensionResource(id = R.dimen.height_12)) {
    Spacer(modifier = Modifier.width(width))
}