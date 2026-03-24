package com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.R

@Composable
fun FoodDishRow(
    name1: String, image1: Int,
    name2: String, image2: Int,
    name3: String, image3: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_8))
    ) {
        Box(modifier = Modifier.weight(1f)) {
            FoodDishCard(dishName = name1, imageResource = image1)
        }
        Box(modifier = Modifier.weight(1f)) {
            FoodDishCard(dishName = name2, imageResource = image2)
        }
        Box(modifier = Modifier.weight(1f)) {
            FoodDishCard(dishName = name3, imageResource = image3)
        }
    }
}