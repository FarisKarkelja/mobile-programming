package com.example.mobile_programming.presentation.ui.screens.favorite_restaurants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.components.FavoriteRestaurantCard
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import androidx.compose.foundation.lazy.grid.items

@Composable
fun FavoriteRestaurantsScreen() {
    var restaurants by remember { mutableStateOf(HardcodedData.restaurants) }
    val favorites by remember { derivedStateOf { restaurants.filter { it.isFavorite } } }
    val favoriteCounter by remember { derivedStateOf { favorites.size } }

    val onUnfavoriteClick: (String) -> Unit = { id ->
        // TODO: onUnfavorite logic
    }

    val onDetailsClick: (String) -> Unit = { id ->
        // TODO: Navigation to restaurant details activity
    }

    FavoriteRestaurantsScreen(
        favorites = favorites,
        favoriteCounter = favoriteCounter,
        onUnfavoriteClick = onUnfavoriteClick,
        onDetailsClick = onDetailsClick
    )
}

@Composable
private fun FavoriteRestaurantsScreen(
    favorites: List<Restaurant>,
    favoriteCounter: Int,
    onUnfavoriteClick: (String) -> Unit,
    onDetailsClick: (String) -> Unit
) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        containerColor = WarmCream
    ) { innerPadding ->
        if (favoriteCounter == 0) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.favorite_restaurants_message),
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextPrimary
                )
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_8)),
                contentPadding = PaddingValues(
                    top = dimensionResource(id = R.dimen.padding_16),
                    bottom = dimensionResource(id = R.dimen.padding_16)
                ),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_12)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_12))
            ) {
                items(favorites, key = { it.id }) { restaurant ->
                    FavoriteRestaurantCard(
                        restaurant = restaurant,
                        onUnfavoriteClick = { onUnfavoriteClick(restaurant.id) },
                        onDetailsClick = { onDetailsClick(restaurant.id) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFavoriteRestaurantsScreen() {
    FavoriteRestaurantsScreen()
}