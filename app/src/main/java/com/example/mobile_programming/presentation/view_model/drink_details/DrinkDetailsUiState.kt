package com.example.mobile_programming.presentation.view_model.drink_details

import com.example.mobile_programming.presentation.ui.screens.drink_details.util.DrinkData

sealed interface DrinkDetailsUiState {
    object Init : DrinkDetailsUiState
    object Loading : DrinkDetailsUiState
    data class Success(val drinkData: DrinkData) : DrinkDetailsUiState
    data class Error(val message: String) : DrinkDetailsUiState
}