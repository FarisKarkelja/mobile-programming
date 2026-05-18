package com.example.mobile_programming.model.datasource.network.service

import com.example.mobile_programming.model.datasource.network.dto.CreateRecipeDto
import com.example.mobile_programming.model.datasource.network.dto.RecipeDto
import com.example.mobile_programming.model.datasource.network.dto.UpdateRecipeDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RecipeApiService {
    @GET("recipes/{userId}")
    suspend fun getRecipes(@Path("userId") userId: Int): List<RecipeDto>

    @GET("recipes/{userId}/{recipeId}")
    suspend fun getRecipeById(
        @Path("userId") userId: Int,
        @Path("recipeId") recipeId: Int
    ): RecipeDto

    @POST("recipes/")
    suspend fun insertRecipe(@Body recipe: CreateRecipeDto): RecipeDto

    @PUT("recipes/{recipeId}")
    suspend fun updateRecipe(
        @Path("recipeId") recipeId: Int,
        @Body recipe: UpdateRecipeDto
    ): RecipeDto

    @DELETE("recipes/{recipeId}")
    suspend fun deleteRecipe(@Path("recipeId") recipeId: Int): Response<Unit>
}