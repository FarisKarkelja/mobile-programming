package com.example.mobile_programming.presentation.ui.screens.restaurants

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.ui.components.BottomBar
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.screens.restaurants.components.RestaurantCard
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import kotlinx.coroutines.launch

@Composable
fun RestaurantsScreen() {
    var restaurants by remember { mutableStateOf(HardcodedData.restaurants) }
    val isRestaurantListEmpty by remember { derivedStateOf { restaurants.isEmpty() } }

    val listState = rememberLazyListState()
    val showScrollToTop by remember { derivedStateOf { listState.firstVisibleItemIndex > 0 } }
    val coroutineScope = rememberCoroutineScope()

    val onFavoriteClick: (String) -> Unit = { id ->
        // TODO: onFavorite logic
    }

    val onDetailsClick: (String) -> Unit = { id ->
        // TODO: Navigation to restaurant details activity
    }

    val onScrollToTopClick: () -> Unit = {
        coroutineScope.launch {
            listState.animateScrollToItem(index = 0)
        }
    }

    RestaurantsScreen(
        restaurants = restaurants,
        isRestaurantListEmpty = isRestaurantListEmpty,
        listState = listState,
        showScrollToTop = showScrollToTop,
        onFavoriteClick = onFavoriteClick,
        onDetailsClick = onDetailsClick,
        onScrollToTopClick = onScrollToTopClick
    )
}

@Composable
private fun RestaurantsScreen(
    restaurants: List<Restaurant>,
    isRestaurantListEmpty: Boolean,
    listState: LazyListState,
    showScrollToTop: Boolean,
    onFavoriteClick: (String) -> Unit,
    onDetailsClick: (String) -> Unit,
    onScrollToTopClick: () -> Unit
) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        containerColor = WarmCream,
        floatingActionButton = {
            AnimatedVisibility(
                visible = showScrollToTop,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                FloatingActionButton(
                    onClick = onScrollToTopClick,
                    containerColor = SunsetTangerine,
                    contentColor = WarmCream
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = "Scroll to top"
                    )
                }
            }
        }
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
                state = listState,
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

@Preview(showBackground = true, name = "All restaurants")
@Composable
fun PreviewRestaurantsScreen() {
    RestaurantsScreen(
        restaurants = HardcodedData.restaurants,
        isRestaurantListEmpty = false,
        listState = rememberLazyListState(),
        showScrollToTop = false,
        onFavoriteClick = {},
        onDetailsClick = {},
        onScrollToTopClick = {}
    )
}

@Preview(showBackground = true, name = "Empty list")
@Composable
fun PreviewEmptyRestaurantsScreen() {
    RestaurantsScreen(
        restaurants = emptyList(),
        isRestaurantListEmpty = true,
        listState = rememberLazyListState(),
        showScrollToTop = false,
        onFavoriteClick = {},
        onDetailsClick = {},
        onScrollToTopClick = {}
    )
}