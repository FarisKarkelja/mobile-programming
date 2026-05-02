package com.example.mobile_programming.presentation.view_model.filters

sealed interface FilterUiState {
    object Init : FilterUiState
    object Loading : FilterUiState
    data class Success(val locations: List<String>, val budgets: List<String>) : FilterUiState
    data class Error(val message: String) : FilterUiState
}