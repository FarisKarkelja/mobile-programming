package com.example.mobile_programming.presentation.ui.screens.drink_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.TopBar

@Composable
fun DrinkDetailsScreen(
    drinkId: String,
    onBackClick: () -> Unit
) {
    val drink = HardcodedData.drinks.find { it.id == drinkId } ?: return

    Scaffold(
        topBar = {
            TopBar(
                stringResource(id = R.string.drink),
                onBackClick = onBackClick
            )
        },
        containerColor = WarmCream
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(dimensionResource(id = R.dimen.padding_16))
        ) {
            Image(
                painter = painterResource(id = drink.imageResId),
                contentDescription = drink.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.height_250))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.corner_12))),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.height_20)))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = drink.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Text(
                    text = "${drink.price} BAM",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.height_16)))
            Text(
                text = drink.description,
                fontSize = 16.sp,
                color = TextPrimary.copy(alpha = 0.8f),
                lineHeight = 24.sp
            )
        }
    }
}