package com.example.mobile_programming.presentation.view_model.favorite_restaurants

import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant

sealed interface FavoriteRestaurantsUiState {
    object Init : FavoriteRestaurantsUiState
    object Loading : FavoriteRestaurantsUiState
    data class Success(val restaurants: List<Restaurant>, val categories: List<Category>) :
        FavoriteRestaurantsUiState

    data class Error(val message: String) : FavoriteRestaurantsUiState
}