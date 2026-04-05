package com.example.mobile_programming.presentation.ui.screens.restaurants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.R
import com.example.mobile_programming.data.Restaurant
import com.example.mobile_programming.presentation.ui.components.BottomBar
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.screens.restaurants.components.RestaurantCard
import com.example.mobile_programming.presentation.theme.WarmCream

@Composable
fun RestaurantsScreen() {
    var restaurants by remember { mutableStateOf(restaurantsList) }
}

@Composable
private fun RestaurantsScreen(
    restaurants: List<Restaurant>,
    isEmptyState: Boolean,
    onFavoriteToggle: (Int) -> Unit,
    onDetailsClick: (Int) -> Unit
) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        containerColor = WarmCream
    ) { innerPadding ->
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
            items(10) {
                RestaurantCard()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRestaurantsScreen() {
    RestaurantsScreen()
}