package com.example.mobile_programming.presentation.ui.screens.restaurantdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.theme.*
import com.example.mobile_programming.presentation.ui.components.BottomBar
import com.example.mobile_programming.presentation.ui.components.RestaurantLocation
import com.example.mobile_programming.presentation.ui.components.RestaurantRating
import com.example.mobile_programming.presentation.ui.components.RestaurantTitle
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.FoodDishRow
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.RestaurantDetailsTitle
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant

@Composable
fun RestaurantDetailsScreen() {
    var restaurant by remember { mutableStateOf(HardcodedData.restaurants.first()) }

    RestaurantDetailsScreen(
        restaurant = restaurant
    )
}

@Composable
private fun RestaurantDetailsScreen(
    restaurant: Restaurant
) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        containerColor = WarmCream
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = dimensionResource(id = R.dimen.padding_16))
                .verticalScroll(rememberScrollState())
        ) {
            VerticalSpace(dimensionResource(id = R.dimen.height_16))
            Image(
                painter = painterResource(id = restaurant.imageResId),
                contentDescription = restaurant.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.height_250))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.corner_12))),
                contentScale = ContentScale.Crop
            )

            VerticalSpace(dimensionResource(id = R.dimen.height_20))
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .fillMaxWidth(0.8f)
                ) {
                    RestaurantTitle(title = restaurant.name)
                    VerticalSpace(dimensionResource(id = R.dimen.height_2))
                    Text(
                        text = restaurant.cuisine,
                        fontSize = 16.sp,
                        color = Color.Gray
                    )

                    VerticalSpace(dimensionResource(id = R.dimen.height_8))
                    RestaurantLocation(
                        location = restaurant.location,
                        iconTint = SunsetTangerine,
                        textColor = TextPrimary,
                        fontSize = 14.sp
                    )
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .background(
                            color = TextPrimary,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12))
                        )
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.padding_10),
                            vertical = dimensionResource(id = R.dimen.padding_6)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RestaurantRating(rating = restaurant.rating, textColor = White)
                }
            }
            VerticalSpace(dimensionResource(id = R.dimen.height_24))
            RestaurantDetailsTitle(stringResource(R.string.about_title))

            VerticalSpace(dimensionResource(id = R.dimen.height_8))
            Text(
                text = restaurant.description,
                fontSize = 15.sp,
                color = TextPrimary,
                lineHeight = 22.sp
            )

            if (restaurant.topDishes.isNotEmpty()) {
                VerticalSpace(dimensionResource(id = R.dimen.height_24))
                RestaurantDetailsTitle(stringResource(R.string.recommended_title))
                VerticalSpace(dimensionResource(id = R.dimen.height_12))

                restaurant.topDishes.chunked(3).forEach { rowDishes ->
                    FoodDishRow(dishes = rowDishes)
                    VerticalSpace(dimensionResource(id = R.dimen.height_12))
                }
            } else {
                VerticalSpace(dimensionResource(id = R.dimen.height_24))
                Text("No recommendations available.", color = Color.Gray)
            }

            VerticalSpace(dimensionResource(id = R.dimen.height_16))
        }
    }
}

@Preview(showBackground = true, name = "With recommended food dishes")
@Composable
fun PreviewDetailsScreenWithDishes() {
    RestaurantDetailsScreen(
        restaurant = HardcodedData.restaurants[0]
    )
}

@Preview(showBackground = true, name = "Without recommended food dishes")
@Composable
fun PreviewDetailsScreenWithoutDishes() {
    RestaurantDetailsScreen(
        restaurant = HardcodedData.restaurants[5]
    )
}