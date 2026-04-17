package com.example.mobile_programming.presentation.ui.screens.restaurantdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.mobile_programming.presentation.ui.components.RestaurantLocation
import com.example.mobile_programming.presentation.ui.components.RestaurantRating
import com.example.mobile_programming.presentation.ui.components.RestaurantTitle
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.Drink
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDish
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.FoodDishCard
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.RestaurantDetailsTitle
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.DrinkCard

@Composable
fun RestaurantDetailsScreen(
    restaurantId: String,
    allRestaurants: List<Restaurant>,
    onBackClick: () -> Unit,
    onNavigateToDish: (String) -> Unit,
    onNavigateToDrink: (String) -> Unit
) {
    val restaurant = allRestaurants.find { it.id == restaurantId }

    if (restaurant == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = stringResource(R.string.restaurant_not_found))
        }
    } else {
        val topDishes by remember {
            mutableStateOf(HardcodedData.foodDishes.filter { it.restaurantId == restaurantId })
        }

        val topDrinks by remember {
            mutableStateOf(HardcodedData.drinks.filter { it.restaurantId == restaurantId })
        }

        val hasTopDishes by remember { derivedStateOf { topDishes.isNotEmpty() } }
        val hasTopDrinks by remember { derivedStateOf { topDrinks.isNotEmpty() } }

        val onDishClick: (FoodDish) -> Unit = { dish ->
            onNavigateToDish(dish.id)
        }

        val onDrinkClick: (Drink) -> Unit = { drink ->
            onNavigateToDrink(drink.id)
        }

        RestaurantDetailsScreen(
            restaurant = restaurant,
            topDishes = topDishes,
            topDrinks = topDrinks,
            hasTopDishes = hasTopDishes,
            hasTopDrinks = hasTopDrinks,
            onDishClick = onDishClick,
            onDrinkClick = onDrinkClick,
            onBackClick = onBackClick
        )
    }
}

@Composable
private fun RestaurantDetailsScreen(
    restaurant: Restaurant,
    topDishes: List<FoodDish>,
    topDrinks: List<Drink>,
    hasTopDishes: Boolean,
    hasTopDrinks: Boolean,
    onDishClick: (FoodDish) -> Unit,
    onDrinkClick: (Drink) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                onBackClick = onBackClick
            )
        },
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

            if (hasTopDishes) {
                VerticalSpace(dimensionResource(id = R.dimen.height_24))
                RestaurantDetailsTitle(stringResource(R.string.house_specialties))
                VerticalSpace(dimensionResource(id = R.dimen.height_12))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_8))
                ) {
                    items(topDishes) { dish ->
                        FoodDishCard(dish = dish) {
                            onDishClick(dish)
                        }
                    }
                }
            }

            if (!hasTopDishes && !hasTopDrinks) {
                VerticalSpace(dimensionResource(id = R.dimen.height_24))
                Text(stringResource(R.string.no_recommendations), color = Color.Gray)
            }

            if (hasTopDrinks) {
                VerticalSpace(dimensionResource(id = R.dimen.height_24))
                RestaurantDetailsTitle(stringResource(R.string.curated_drinks))
                VerticalSpace(dimensionResource(id = R.dimen.height_12))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_8))
                ) {
                    items(topDrinks) { drink ->
                        DrinkCard(drink = drink) {
                            onDrinkClick(drink)
                        }
                    }
                }
            }
            VerticalSpace(dimensionResource(id = R.dimen.height_16))
        }
    }
}

@Preview(showBackground = true, name = "With items")
@Composable
fun PreviewDetailsScreenWithDishes() {
    val restaurant = HardcodedData.restaurants[0]
    val topDishes = HardcodedData.foodDishes.filter { it.restaurantId == restaurant.id }
    val topDrinks = HardcodedData.drinks.filter { it.restaurantId == restaurant.id }

    RestaurantDetailsScreen(
        restaurant = restaurant,
        topDishes = topDishes,
        topDrinks = topDrinks,
        hasTopDishes = topDishes.isNotEmpty(),
        hasTopDrinks = topDrinks.isNotEmpty(),
        onDishClick = {},
        onDrinkClick = {},
        onBackClick = {}
    )
}

@Preview(showBackground = true, name = "Without items")
@Composable
fun PreviewDetailsScreenWithoutDishes() {
    val restaurant = HardcodedData.restaurants[0]

    RestaurantDetailsScreen(
        restaurant = restaurant,
        topDishes = emptyList(),
        topDrinks = emptyList(),
        hasTopDishes = false,
        hasTopDrinks = false,
        onDishClick = {},
        onDrinkClick = {},
        onBackClick = {}
    )
}