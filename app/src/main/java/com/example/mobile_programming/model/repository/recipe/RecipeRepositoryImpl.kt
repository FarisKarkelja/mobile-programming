package com.example.mobile_programming.model.repository.recipe

import com.example.mobile_programming.model.datasource.network.service.RecipeApiService
import com.example.mobile_programming.model.datasource.network.dto.CreateRecipeDto
import com.example.mobile_programming.model.datasource.network.dto.RecipeDto
import com.example.mobile_programming.model.datasource.network.dto.UpdateRecipeDto
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApiService
) : RecipeRepository {
    override suspend fun getRecipes(userId: Int): List<RecipeDto> {
        return api.getRecipes(userId)
    }

    override suspend fun getRecipeById(userId: Int, recipeId: Int): RecipeDto {
        return api.getRecipeById(userId, recipeId)
    }

    override suspend fun insertRecipe(recipe: CreateRecipeDto) {
        api.insertRecipe(recipe)
    }

    override suspend fun updateRecipe(recipeId: Int, recipe: UpdateRecipeDto) {
        api.updateRecipe(recipeId, recipe)
    }

    override suspend fun deleteRecipe(recipeId: Int) {
        api.deleteRecipe(recipeId)
    }
}