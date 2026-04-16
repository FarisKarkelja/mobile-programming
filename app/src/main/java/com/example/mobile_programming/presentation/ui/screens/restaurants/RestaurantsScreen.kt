package com.example.mobile_programming.presentation.ui.screens.restaurants

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.screens.restaurants.components.RestaurantCard
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.screens.restaurants.components.RestaurantSearchBar
import com.example.mobile_programming.presentation.ui.screens.restaurants.components.SortOptionsRow
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.isWithinBudget
import kotlinx.coroutines.launch

@Composable
fun RestaurantsScreen(
    categoryId: String,
    location: String,
    budget: String,
    minRating: Float,
    allRestaurants: List<Restaurant>,
    onToggleFavorite: (String) -> Unit,
    onNavigateToDetails: (String) -> Unit
) {
    var restaurants by remember {
        mutableStateOf(
            allRestaurants.filter { restaurant ->
                restaurant.categoryId == categoryId &&
                        restaurant.location == location &&
                        restaurant.rating >= minRating &&
                        isWithinBudget(restaurant.avgPrice, budget)
            }
        )
    }
    var searchQuery by remember { mutableStateOf("") }

    val queryRestaurants by remember {
        derivedStateOf {
            if (searchQuery.isBlank()) {
                restaurants
            } else {
                restaurants.filter { restaurant ->
                    restaurant.name.contains(
                        searchQuery,
                        ignoreCase = true
                    )
                }
            }
        }
    }

    val isRestaurantListEmpty by remember { derivedStateOf { queryRestaurants.isEmpty() } }

    val listState = rememberLazyListState()
    val showScrollToTop by remember { derivedStateOf { listState.firstVisibleItemIndex > 0 } }
    val coroutineScope = rememberCoroutineScope()

    val onSearchQueryChange: (String) -> Unit = { searchQuery = it }

    val onFavoriteClick: (String) -> Unit = { id ->
        onToggleFavorite(id)
    }

    val onDetailsClick: (String) -> Unit = { id ->
        onNavigateToDetails(id)
    }

    val onSortAZClick: () -> Unit = {
        restaurants = restaurants.sortedBy { it.name }
    }

    val onSortZAClick: () -> Unit = {
        restaurants = restaurants.sortedByDescending { it.name }
    }

    val onSortRatingLowClick: () -> Unit = {
        restaurants = restaurants.sortedBy { it.rating }
    }

    val onSortRatingHighClick: () -> Unit = {
        restaurants = restaurants.sortedByDescending { it.rating }
    }

    val onScrollToTopClick: () -> Unit = {
        coroutineScope.launch {
            listState.animateScrollToItem(index = 0)
        }
    }

    RestaurantsScreen(
        restaurants = queryRestaurants,
        isRestaurantListEmpty = isRestaurantListEmpty,
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        listState = listState,
        showScrollToTop = showScrollToTop,
        onFavoriteClick = onFavoriteClick,
        onDetailsClick = onDetailsClick,
        onScrollToTopClick = onScrollToTopClick,
        onSortAZClick = onSortAZClick,
        onSortZAClick = onSortZAClick,
        onSortRatingLowClick = onSortRatingLowClick,
        onSortRatingHighClick = onSortRatingHighClick
    )
}

@Composable
private fun RestaurantsScreen(
    restaurants: List<Restaurant>,
    isRestaurantListEmpty: Boolean,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    listState: LazyListState,
    showScrollToTop: Boolean,
    onFavoriteClick: (String) -> Unit,
    onDetailsClick: (String) -> Unit,
    onScrollToTopClick: () -> Unit,
    onSortAZClick: () -> Unit,
    onSortZAClick: () -> Unit,
    onSortRatingLowClick: () -> Unit,
    onSortRatingHighClick: () -> Unit
) {
    Scaffold(
        topBar = { TopBar() },
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
                        contentDescription = stringResource(R.string.scroll_to_top)
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            RestaurantSearchBar(
                searchQuery = searchQuery,
                onSearchQueryChange = onSearchQueryChange
            )
            SortOptionsRow(
                onSortAZClick = onSortAZClick,
                onSortZAClick = onSortZAClick,
                onSortRatingLowClick = onSortRatingLowClick,
                onSortRatingHighClick = onSortRatingHighClick
            )
            if (isRestaurantListEmpty) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
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
}

@Preview(showBackground = true, name = "All restaurants")
@Composable
fun PreviewRestaurantsScreen() {
    RestaurantsScreen(
        restaurants = HardcodedData.restaurants,
        isRestaurantListEmpty = false,
        searchQuery = "",
        onSearchQueryChange = {},
        listState = rememberLazyListState(),
        showScrollToTop = false,
        onFavoriteClick = {},
        onDetailsClick = {},
        onScrollToTopClick = {},
        onSortAZClick = {},
        onSortZAClick = {},
        onSortRatingLowClick = {},
        onSortRatingHighClick = {}
    )
}

@Preview(showBackground = true, name = "Empty list")
@Composable
fun PreviewEmptyRestaurantsScreen() {
    RestaurantsScreen(
        restaurants = emptyList(),
        isRestaurantListEmpty = true,
        searchQuery = "Unknown",
        onSearchQueryChange = {},
        listState = rememberLazyListState(),
        showScrollToTop = false,
        onFavoriteClick = {},
        onDetailsClick = {},
        onScrollToTopClick = {},
        onSortAZClick = {},
        onSortZAClick = {},
        onSortRatingLowClick = {},
        onSortRatingHighClick = {}
    )
}