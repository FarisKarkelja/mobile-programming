package com.example.mobile_programming.presentation.view_model.drink_details

import com.example.mobile_programming.presentation.ui.screens.drink_details.util.Drink

sealed interface DrinkDetailsUiState {
    object Init : DrinkDetailsUiState
    object Loading : DrinkDetailsUiState
    data class Success(val drink: Drink) : DrinkDetailsUiState
    data class Error(val message: String) : DrinkDetailsUiState
}