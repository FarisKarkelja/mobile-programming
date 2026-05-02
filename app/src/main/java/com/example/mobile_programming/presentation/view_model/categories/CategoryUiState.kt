package com.example.mobile_programming.presentation.view_model.categories

import com.example.mobile_programming.presentation.ui.screens.categories.util.Category

sealed interface CategoryUiState {
    object Init : CategoryUiState
    object Loading : CategoryUiState
    data class Success(val formattedCategories: List<List<Category>>) : CategoryUiState
    data class Error(val message: String) : CategoryUiState
}