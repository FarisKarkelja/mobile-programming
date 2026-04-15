package com.example.mobile_programming.presentation.ui.screens.food_dish_details

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
fun FoodDishDetailsScreen(
    dishId: String,
    onBackClick: () -> Unit
) {
    val dish = HardcodedData.foodDishes.find { it.id == dishId } ?: return

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.food_dish),
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
                painter = painterResource(id = dish.imageResId),
                contentDescription = dish.name,
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
                    text = dish.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Text(
                    text = "${dish.price} BAM", // Ili valuta koju koristis
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.height_16)))
            Text(
                text = dish.description,
                fontSize = 16.sp,
                color = TextPrimary.copy(alpha = 0.8f),
                lineHeight = 24.sp
            )
        }
    }
}