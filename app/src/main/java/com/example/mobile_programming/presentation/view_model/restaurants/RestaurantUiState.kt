package com.example.mobile_programming.presentation.view_model.restaurants

import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant

sealed interface RestaurantUiState {
    object Init : RestaurantUiState
    object Loading : RestaurantUiState
    data class Success(val searchQuery: String, val restaurants: List<Restaurant>) :
        RestaurantUiState

    data class Error(val message: String) : RestaurantUiState
}