package com.example.mobile_programming.presentation.view_model.recipes

sealed interface RecipeNavigationEvent {
    object Navigate : RecipeNavigationEvent
    object NavigateBack : RecipeNavigationEvent
}