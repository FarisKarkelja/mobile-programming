package com.example.mobile_programming.presentation.ui.screens.profile.components

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.WarmCream

@Composable
fun LogoutButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = SunsetTangerine,
    textColor: Color = WarmCream
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.height_50)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}