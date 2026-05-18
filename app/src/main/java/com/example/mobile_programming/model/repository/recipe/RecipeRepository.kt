package com.example.mobile_programming.model.repository.recipe

import com.example.mobile_programming.model.datasource.network.dto.CreateRecipeDto
import com.example.mobile_programming.model.datasource.network.dto.RecipeDto
import com.example.mobile_programming.model.datasource.network.dto.UpdateRecipeDto

interface RecipeRepository {
    suspend fun getRecipes(userId: Int): List<RecipeDto>
    suspend fun getRecipeById(userId: Int, recipeId: Int): RecipeDto
    suspend fun insertRecipe(recipe: CreateRecipeDto)
    suspend fun updateRecipe(recipeId: Int, recipe: UpdateRecipeDto)
    suspend fun deleteRecipe(recipeId: Int)
}