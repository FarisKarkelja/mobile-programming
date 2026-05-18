package com.example.mobile_programming.presentation.view_model.food_dish_details

import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDish

sealed interface FoodDishDetailsUiState {
    object Init : FoodDishDetailsUiState
    object Loading : FoodDishDetailsUiState
    data class Success(val dish: FoodDish) : FoodDishDetailsUiState
    data class Error(val message: String) : FoodDishDetailsUiState
}