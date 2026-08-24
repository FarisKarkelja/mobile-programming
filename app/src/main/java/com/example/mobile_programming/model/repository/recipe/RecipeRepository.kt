package com.example.mobile_programming.model.repository.recipe

import com.example.mobile_programming.presentation.ui.screens.recipes.util.Recipe

interface RecipeRepository {
    suspend fun getRecipes(userId: Int): List<Recipe>
    suspend fun getRecipeById(userId: Int, recipeId: Int): Recipe
    suspend fun insertRecipe(
        name: String,
        userId: Int,
        ingredients: String,
        instructions: String,
        cookingTime: String
    )

    suspend fun updateRecipe(
        recipeId: Int,
        name: String,
        userId: Int,
        ingredients: String,
        instructions: String,
        cookingTime: String
    )

    suspend fun deleteRecipe(recipeId: Int)
}