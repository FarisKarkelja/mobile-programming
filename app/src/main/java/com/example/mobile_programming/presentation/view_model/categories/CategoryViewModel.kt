package com.example.mobile_programming.presentation.view_model.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.categories.util.formatCategories
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<CategoryUiState>(CategoryUiState.Init)
    val uiState: StateFlow<CategoryUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<CategoryNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            _uiState.value = CategoryUiState.Loading
            val categories = HardcodedData.categories
            val pattern = listOf(1, 3, 2, 1)
            val formattedCategories = formatCategories(categories, pattern)
            _uiState.value = CategoryUiState.Success(formattedCategories)
        }
    }

    fun resetUiState() {
        _uiState.value = CategoryUiState.Init
    }
}