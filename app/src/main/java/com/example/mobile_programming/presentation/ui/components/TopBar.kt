package com.example.mobile_programming.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.TextPrimary

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.height_56))
            .background(TextPrimary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.topbar_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxHeight()
        )
    }
}