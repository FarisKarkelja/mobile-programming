package com.example.mobile_programming.presentation.view_model.recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.recipe.RecipeRepository
import com.example.mobile_programming.model.repository.user.SessionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val sessionRepository: SessionRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<RecipeUiState>(RecipeUiState.Init)
    val uiState: StateFlow<RecipeUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<RecipeNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    init {
        loadRecipes()
    }

    fun loadRecipes() {
        viewModelScope.launch {
            _uiState.value = RecipeUiState.Loading
            try {
                val userId = sessionRepository.observeLoggedInUserId().first() ?: 0L
                val recipes = recipeRepository.getRecipes(userId.toInt())
                _uiState.value = RecipeUiState.Success(recipes)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = RecipeUiState.Error(e.message ?: "Failed to load recipes.")
            }
        }
    }

    fun insertRecipe(
        name: String,
        ingredients: String,
        instructions: String,
        cookingTime: String
    ) {
        viewModelScope.launch {
            _uiState.value = RecipeUiState.Loading
            try {
                val userId = sessionRepository.observeLoggedInUserId().first() ?: 0L
                recipeRepository.insertRecipe(
                    name,
                    userId.toInt(),
                    ingredients,
                    instructions,
                    cookingTime
                )
                loadRecipes()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = RecipeUiState.Error(e.message ?: "Failed to add recipe.")
            }
        }
    }

    fun updateRecipe(
        recipeId: String,
        name: String,
        ingredients: String,
        instructions: String,
        cookingTime: String
    ) {
        viewModelScope.launch {
            _uiState.value = RecipeUiState.Loading
            try {
                val userId = sessionRepository.observeLoggedInUserId().first() ?: 0L
                recipeRepository.updateRecipe(
                    recipeId.toInt(),
                    name,
                    userId.toInt(),
                    ingredients,
                    instructions,
                    cookingTime
                )
                loadRecipes()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value =
                    RecipeUiState.Error(e.localizedMessage ?: "Failed to update recipe.")
            }
        }
    }

    fun deleteRecipe(recipeId: String) {
        viewModelScope.launch {
            _uiState.value = RecipeUiState.Loading
            try {
                recipeRepository.deleteRecipe(recipeId.toInt())
                loadRecipes()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = RecipeUiState.Error(e.message ?: "Failed to delete recipe.")
            }
        }
    }

    fun resetUiState() {
        loadRecipes()
    }
}