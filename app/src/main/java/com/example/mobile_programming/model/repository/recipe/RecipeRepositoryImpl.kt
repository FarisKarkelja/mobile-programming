package com.example.mobile_programming.model.repository.recipe

import com.example.mobile_programming.model.datasource.network.service.RecipeApiService
import com.example.mobile_programming.model.datasource.network.mapper.toDomain
import com.example.mobile_programming.model.datasource.network.mapper.mapToCreateRecipeDto
import com.example.mobile_programming.model.datasource.network.mapper.mapToUpdateRecipeDto
import com.example.mobile_programming.presentation.ui.screens.recipes.util.Recipe
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApiService
) : RecipeRepository {
    override suspend fun getRecipes(userId: Int): List<Recipe> {
        return api.getRecipes(userId).map { it.toDomain() }
    }

    override suspend fun getRecipeById(userId: Int, recipeId: Int): Recipe {
        return api.getRecipeById(userId, recipeId).toDomain()
    }

    override suspend fun insertRecipe(
        name: String,
        userId: Int,
        ingredients: String,
        instructions: String,
        cookingTime: String
    ) {
        val dto = mapToCreateRecipeDto(name, userId, ingredients, instructions, cookingTime)
        api.insertRecipe(dto)
    }

    override suspend fun updateRecipe(
        recipeId: Int,
        name: String,
        userId: Int,
        ingredients: String,
        instructions: String,
        cookingTime: String
    ) {
        val dto = mapToUpdateRecipeDto(name, userId, ingredients, instructions, cookingTime)
        api.updateRecipe(recipeId, dto)
    }

    override suspend fun deleteRecipe(recipeId: Int) {
        api.deleteRecipe(recipeId)
    }
}