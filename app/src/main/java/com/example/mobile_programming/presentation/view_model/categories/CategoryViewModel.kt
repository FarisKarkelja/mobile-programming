package com.example.mobile_programming.presentation.view_model.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.data.local.util.CategorySeed
import com.example.mobile_programming.model.repository.category.CategoryRepository
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.presentation.ui.screens.categories.util.formatCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<CategoryUiState>(CategoryUiState.Init)
    val uiState: StateFlow<CategoryUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<CategoryNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    private val pattern = listOf(1, 3, 2, 1)

    init {
        loadCategories()
    }

    fun loadCategories() {
        viewModelScope.launch {
            _uiState.value = CategoryUiState.Loading

            repository.getAllCategories()
                .catch { e ->
                    _uiState.value = CategoryUiState.Error(e.message ?: "Failed to load categories")
                }
                .collect { entities ->
                    if (entities.isEmpty()) {
                        seedDatabase()
                    } else {
                        val domainCategories = entities.map { it.toDomain() }
                        val formatted = formatCategories(domainCategories, pattern)
                        _uiState.value = CategoryUiState.Success(formatted)
                    }
                }
        }
    }

    private fun seedDatabase() {
        viewModelScope.launch {
            CategorySeed.defaultCategories.forEach { entity ->
                repository.insertCategory(entity)
            }
        }
    }

    fun resetUiState() {
        loadCategories()
    }
}