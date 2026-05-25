package com.example.mobile_programming.presentation.view_model.restaurant_details

import com.example.mobile_programming.model.datasource.remote.dto.ReviewDto
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.DrinkData
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDishData
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant

sealed interface RestaurantDetailsUiState {
    object Init : RestaurantDetailsUiState
    object Loading : RestaurantDetailsUiState
    data class Success(
        val restaurant: Restaurant,
        val topDishes: List<FoodDishData>,
        val topDrinkData: List<DrinkData>,
        val reviews: List<ReviewDto>
    ) : RestaurantDetailsUiState

    data class Error(val message: String) : RestaurantDetailsUiState
}