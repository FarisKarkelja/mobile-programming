package com.example.mobile_programming.presentation.view_model.main

sealed interface MainUiState {
    object Init : MainUiState
    object Loading : MainUiState
    data class Success(val route: String) : MainUiState
    data class Error(val message: String) : MainUiState
}