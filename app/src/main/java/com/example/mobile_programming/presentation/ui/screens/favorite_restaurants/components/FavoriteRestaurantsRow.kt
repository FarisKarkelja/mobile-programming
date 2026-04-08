package com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant

@Composable
fun FavoriteRestaurantsRow(
    restaurants: List<Restaurant>,
    onUnfavoriteClick: (String) -> Unit,
    onDetailsClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.padding_8)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_12))
    ) {
        items(restaurants, key = { it.id }) { restaurant ->
            Box(modifier = Modifier.width(160.dp)) {
                FavoriteRestaurantCard(
                    restaurant = restaurant,
                    onUnfavoriteClick = { onUnfavoriteClick(restaurant.id) },
                    onDetailsClick = { onDetailsClick(restaurant.id) }
                )
            }
        }
    }
}