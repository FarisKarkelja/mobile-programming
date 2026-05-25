package com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDishData

@Composable
fun FoodDishCard(dish: FoodDishData, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.width_140))
            .height(dimensionResource(id = R.dimen.height_140))
            .clickable { onClick() },
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.elevation_2))
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = dish.imageResId),
                contentDescription = dish.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )

            Text(
                text = dish.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_4)),
                textAlign = TextAlign.Center,
                maxLines = 2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodDishCardPreview() {
    val sampleDish = FoodDishData(
        id = "fd_1",
        restaurantId = "r_10",
        name = "Chicken Tortilla",
        imageResId = R.drawable.meal_3,
        price = 8.50,
        description = "Grilled chicken with peppers and onions wrapped in a soft tortilla.",
        cookingTime = "15 mins",
        servingSize = "350g",
        calories = "450 kcal",
        allergens = emptyList()
    )

    FoodDishCard(
        dish = sampleDish,
        onClick = {}
    )
}