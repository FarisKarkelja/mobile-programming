package com.example.mobile_programming.presentation.view_model.recipe_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.datasource.network.mapper.toDomain
import com.example.mobile_programming.model.repository.recipe.RecipeRepository
import com.example.mobile_programming.model.repository.user.SessionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val sessionRepository: SessionRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<RecipeDetailsUiState>(RecipeDetailsUiState.Init)
    val uiState: StateFlow<RecipeDetailsUiState> = _uiState.asStateFlow()

    fun loadRecipe(recipeId: String) {
        viewModelScope.launch {
            _uiState.value = RecipeDetailsUiState.Loading
            try {
                val userId = sessionRepository.observeLoggedInUserId().first() ?: 0L
                val recipe = recipeRepository.getRecipeById(userId.toInt(), recipeId.toInt())
                _uiState.value = RecipeDetailsUiState.Success(recipe.toDomain())
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value =
                    RecipeDetailsUiState.Error(e.message ?: "Failed to load recipe details.")
            }
        }
    }

    fun resetUiState() {
        loadRecipe("")
    }
}