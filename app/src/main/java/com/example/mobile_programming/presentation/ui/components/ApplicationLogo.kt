package com.example.mobile_programming.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.mobile_programming.R

@Composable
fun ApplicationLogo() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo",
        modifier = Modifier.size(dimensionResource(id = R.dimen.size_420))
    )
}