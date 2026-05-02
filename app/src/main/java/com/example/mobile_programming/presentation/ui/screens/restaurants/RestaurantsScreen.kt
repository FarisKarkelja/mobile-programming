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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobile_programming.R
import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.screens.restaurants.components.RestaurantCard
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.screens.error.ErrorScreen
import com.example.mobile_programming.presentation.ui.screens.loading.LoadingScreen
import com.example.mobile_programming.presentation.ui.screens.restaurants.components.RestaurantSearchBar
import com.example.mobile_programming.presentation.ui.screens.restaurants.components.SortOptionsRow
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.presentation.view_model.restaurants.RestaurantUiState
import com.example.mobile_programming.presentation.view_model.restaurants.RestaurantViewModel
import kotlinx.coroutines.launch

@Composable
fun RestaurantsScreen(
    categoryId: String,
    location: String,
    budget: String,
    minRating: Float,
    viewModel: RestaurantViewModel,
    onNavigateToDetails: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(categoryId, location, budget, minRating) {
        viewModel.loadRestaurants(categoryId, location, budget, minRating)
    }

    val listState = rememberLazyListState()
    val showScrollToTop by remember { derivedStateOf { listState.firstVisibleItemIndex > 0 } }
    val coroutineScope = rememberCoroutineScope()

    when (val state = uiState) {
        is RestaurantUiState.Loading -> LoadingScreen()
        is RestaurantUiState.Error -> ErrorScreen(
            state.message,
            onRetry = { viewModel.resetUiState() })

        is RestaurantUiState.Success -> RestaurantsScreen(
            restaurants = state.restaurants,
            isRestaurantListEmpty = state.restaurants.isEmpty(),
            searchQuery = state.searchQuery,
            onSearchQueryChange = viewModel::onSearchQueryChange,
            listState = listState,
            showScrollToTop = showScrollToTop,
            onFavoriteClick = { viewModel.toggleFavorite(it) },
            onDetailsClick = onNavigateToDetails,
            onScrollToTopClick = { coroutineScope.launch { listState.animateScrollToItem(0) } },
            onSortAZClick = { viewModel.onSortAZ() },
            onSortZAClick = { viewModel.onSortZA() },
            onSortRatingLowClick = { viewModel.onSortRatingLow() },
            onSortRatingHighClick = { viewModel.onSortRatingHigh() }
        )

        else -> Unit
    }
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