package com.example.mobile_programming.presentation.ui.screens.favorite_restaurants

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.ui.components.BottomBar
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.components.FavoriteRestaurantsCategoryTitle
import com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.components.FavoriteRestaurantsRow

@Composable
fun FavoriteRestaurantsScreen() {
    var restaurants by remember { mutableStateOf(HardcodedData.restaurants) }
    val favorites by remember { derivedStateOf { restaurants.filter { it.isFavorite } } }
    val favoriteCounter by remember { derivedStateOf { favorites.size } }

    val categories by remember { mutableStateOf(HardcodedData.categories) }

    val groupedFavorites by remember {
        derivedStateOf { favorites.groupBy { it.categoryId } }
    }

    val onUnfavoriteClick: (String) -> Unit = { id ->
        // TODO: onUnfavorite logic
    }

    val onDetailsClick: (String) -> Unit = { id ->
        // TODO: Navigation to restaurant details activity
    }

    FavoriteRestaurantsScreen(
        categories = categories,
        favoriteCounter = favoriteCounter,
        groupedFavorites = groupedFavorites,
        onUnfavoriteClick = onUnfavoriteClick,
        onDetailsClick = onDetailsClick
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FavoriteRestaurantsScreen(
    categories: List<Category>,
    favoriteCounter: Int,
    groupedFavorites: Map<String, List<Restaurant>>,
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(bottom = dimensionResource(id = R.dimen.padding_16))
            ) {
                categories.forEach { category ->
                    stickyHeader {
                        FavoriteRestaurantsCategoryTitle(categoryName = category.name)
                    }
                    item {
                        val restaurantsInThatCategory =
                            groupedFavorites.getOrDefault(category.id, emptyList())
                        if (restaurantsInThatCategory.isEmpty()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = dimensionResource(id = R.dimen.padding_24)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(id = R.string.no_category_favorites),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = TextPrimary.copy(alpha = 0.5f)
                                )
                            }
                        } else {
                            FavoriteRestaurantsRow(
                                restaurants = restaurantsInThatCategory,
                                onUnfavoriteClick = onUnfavoriteClick,
                                onDetailsClick = onDetailsClick,
                                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_24))
                            )
                        }
                    }
                }
            }
        }
    }
}

