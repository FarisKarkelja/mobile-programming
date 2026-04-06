package com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.FoodDish

@Composable
fun FoodDishRow(dishes: List<FoodDish>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_8))
    ) {
        for (i in 0 until 3) {
            Box(modifier = Modifier.weight(1f)) {
                if (i < dishes.size) {
                    FoodDishCard(dish = dishes[i])
                }
            }
        }
    }
}