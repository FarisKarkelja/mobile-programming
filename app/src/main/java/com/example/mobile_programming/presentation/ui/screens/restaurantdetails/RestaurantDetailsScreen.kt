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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobile_programming.R
import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.model.datasource.remote.dto.ReviewDto
import com.example.mobile_programming.presentation.theme.*
import com.example.mobile_programming.presentation.ui.components.RestaurantLocation
import com.example.mobile_programming.presentation.ui.components.RestaurantRating
import com.example.mobile_programming.presentation.ui.components.RestaurantTitle
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.DrinkData
import com.example.mobile_programming.presentation.ui.screens.error.ErrorScreen
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDishData
import com.example.mobile_programming.presentation.ui.screens.loading.LoadingScreen
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.FoodDishCard
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.RestaurantDetailsTitle
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.DrinkCard
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.ReviewSection
import com.example.mobile_programming.presentation.view_model.restaurant_details.RestaurantDetailsUiState
import com.example.mobile_programming.presentation.view_model.restaurant_details.RestaurantDetailsViewModel

@Composable
fun RestaurantDetailsScreen(
    restaurantId: String,
    viewModel: RestaurantDetailsViewModel,
    onBackClick: () -> Unit,
    onNavigateToDish: (String) -> Unit,
    onNavigateToDrink: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(restaurantId) {
        viewModel.loadRestaurantDetails(restaurantId)
    }

    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        viewModel.loadRestaurantDetails(restaurantId)
    }

    when (val state = uiState) {
        is RestaurantDetailsUiState.Loading -> LoadingScreen()
        is RestaurantDetailsUiState.Error -> ErrorScreen(
            state.message,
            onRetry = { viewModel.resetUiState() })

        is RestaurantDetailsUiState.Success -> RestaurantDetailsScreen(
            restaurant = state.restaurant,
            topDishes = state.topDishes,
            topDrinkData = state.topDrinkData,
            hasTopDishes = state.topDishes.isNotEmpty(),
            hasTopDrinks = state.topDrinkData.isNotEmpty(),
            reviews = state.reviews,
            onAddReview = { comment, rating ->
                viewModel.addReview(restaurantId, comment, rating)
            },
            onDishClick = { onNavigateToDish(it.id) },
            onDrinkClick = { onNavigateToDrink(it.id) },
            onBackClick = onBackClick
        )

        else -> Unit
    }
}

@Composable
private fun RestaurantDetailsScreen(
    restaurant: Restaurant,
    topDishes: List<FoodDishData>,
    topDrinkData: List<DrinkData>,
    hasTopDishes: Boolean,
    hasTopDrinks: Boolean,
    reviews: List<ReviewDto>,
    onAddReview: (comment: String, rating: Float) -> Unit,
    onDishClick: (FoodDishData) -> Unit,
    onDrinkClick: (DrinkData) -> Unit,
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
                    items(topDrinkData) { drink ->
                        DrinkCard(drinkData = drink) {
                            onDrinkClick(drink)
                        }
                    }
                }
            }
            VerticalSpace(dimensionResource(id = R.dimen.height_24))
            RestaurantDetailsTitle("Reviews")
            VerticalSpace(dimensionResource(id = R.dimen.height_12))
            ReviewSection(
                reviews = reviews,
                onAddReview = onAddReview
            )
            VerticalSpace(dimensionResource(id = R.dimen.height_16))
            VerticalSpace(dimensionResource(id = R.dimen.height_16))
        }
    }
}

@Preview(showBackground = true, name = "With items")
@Composable
fun PreviewDetailsScreenWithDishes() {
    val restaurant = HardcodedData.restaurants[0]
    val topDishes = HardcodedData.foodDishData.filter { it.restaurantId == restaurant.id }
    val topDrinks = HardcodedData.drinkData.filter { it.restaurantId == restaurant.id }

    RestaurantDetailsScreen(
        restaurant = restaurant,
        topDishes = topDishes,
        topDrinkData = topDrinks,
        hasTopDishes = topDishes.isNotEmpty(),
        hasTopDrinks = topDrinks.isNotEmpty(),
        reviews = emptyList(),
        onAddReview = { _, _ -> },
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
        topDrinkData = emptyList(),
        hasTopDishes = false,
        hasTopDrinks = false,
        reviews = emptyList(),
        onAddReview = { _, _ -> },
        onDishClick = {},
        onDrinkClick = {},
        onBackClick = {}
    )
}