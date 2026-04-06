package com.example.mobile_programming.presentation.ui.screens.restaurants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.ui.components.BottomBar
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.screens.restaurants.components.RestaurantCard
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant

@Composable
fun RestaurantScreen() {
    var restaurants by remember { mutableStateOf(HardcodedData.restaurants) }
    val isRestaurantListEmpty by remember { derivedStateOf { restaurants.isEmpty() } }

    val onFavoriteClick: (String) -> Unit = { id ->
        // TODO: onFavorite logic
    }

    val onDetailsClick: (String) -> Unit = { id ->
        // TODO: Navigation to restaurant details activity
    }

    RestaurantsScreen(
        restaurants = restaurants,
        isRestaurantListEmpty = isRestaurantListEmpty,
        onFavoriteClick = onFavoriteClick,
        onDetailsClick = onDetailsClick
    )
}

@Composable
private fun RestaurantsScreen(
    restaurants: List<Restaurant>,
    isRestaurantListEmpty: Boolean,
    onFavoriteClick: (String) -> Unit,
    onDetailsClick: (String) -> Unit
) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        containerColor = WarmCream
    ) { innerPadding ->
        if (isRestaurantListEmpty) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.no_restaurants_message),
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextPrimary
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_8)),
                contentPadding = PaddingValues(
                    top = dimensionResource(id = R.dimen.padding_16),
                    bottom = dimensionResource(id = R.dimen.padding_16)
                ),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.height_12))
            ) {
                items(restaurants, key = { it.id }) { restaurant ->
                    RestaurantCard(
                        restaurant = restaurant,
                        onFavoriteClick = { onFavoriteClick(restaurant.id) },
                        onDetailsClick = { onDetailsClick(restaurant.id) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRestaurantsScreen() {
    val dummyRestaurants = listOf(
        Restaurant(
            id = "1",
            name = "Test Restoran 1",
            cuisine = "Italijanska",
            description = "Odličan restoran za preview",
            imageResId = R.drawable.restaurant_placeholder,
            isFavorite = true,
            rating = 4.8,
            location = "Centar",
            topDishes = emptyList()
        ),
        Restaurant(
            id = "2",
            name = "Test Restoran 2",
            cuisine = "Meksička",
            description = "Pikantna hrana",
            imageResId = R.drawable.restaurant_placeholder,
            isFavorite = false,
            rating = 4.2,
            location = "Stari Grad",
            topDishes = emptyList()
        )
    )

    RestaurantsScreen(
        restaurants = dummyRestaurants,
        isRestaurantListEmpty = false,
        onFavoriteClick = {},
        onDetailsClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewEmptyRestaurantsScreen() {
    RestaurantsScreen(
        restaurants = emptyList(),
        isRestaurantListEmpty = true,
        onFavoriteClick = {},
        onDetailsClick = {}
    )
}