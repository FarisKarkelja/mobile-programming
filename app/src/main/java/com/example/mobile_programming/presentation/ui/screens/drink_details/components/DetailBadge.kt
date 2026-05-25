package com.example.mobile_programming.presentation.ui.screens.drink_details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.TextPrimary

@Composable
fun DetailBadge(text: String) {
    Surface(
        color = TextPrimary.copy(alpha = 0.08f),
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_8))
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = dimensionResource(R.dimen.padding_10),
                vertical = dimensionResource(R.dimen.padding_4)
            ),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimary.copy(alpha = 0.8f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailBadgePreview() {
    DetailBadge(text = "Gazirano")
}