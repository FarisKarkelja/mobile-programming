package com.example.mobile_programming.presentation.view_model.recipe_details

import com.example.mobile_programming.presentation.ui.screens.recipes.util.Recipe

sealed interface RecipeDetailsUiState {
    object Init : RecipeDetailsUiState
    object Loading : RecipeDetailsUiState
    data class Success(val recipe: Recipe) : RecipeDetailsUiState
    data class Error(val message: String) : RecipeDetailsUiState
}