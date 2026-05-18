package com.example.mobile_programming.presentation.view_model.recipes

import com.example.mobile_programming.presentation.ui.screens.recipes.util.Recipe

sealed interface RecipeUiState {
    object Init : RecipeUiState
    object Loading : RecipeUiState
    data class Success(val recipes: List<Recipe>) : RecipeUiState
    data class Error(val message: String) : RecipeUiState
}