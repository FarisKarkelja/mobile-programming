package com.example.mobile_programming.presentation.view_model.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class CategoryViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<CategoryUiState>(CategoryUiState.Init)
    val uiState: StateFlow<CategoryUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<CategoryNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    private val repository = CategoryRepository()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            _uiState.value = CategoryUiState.Loading
            try {
                val categories = repository.getCategories()
                _uiState.value = CategoryUiState.Success(categories)
            } catch (e: CancellationException) {
                throw e
            } catch (e: IllegalStateException) {
                _uiState.value = CategoryUiState.Error(
                    e.message ?: "Failed to load categories."
                )
            }
        }
    }

    fun resetUiState() {
        loadCategories()
    }
}