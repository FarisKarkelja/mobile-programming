package com.example.mobile_programming.presentation.view_model.filters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.data.HardcodedData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<FilterUiState>(FilterUiState.Init)
    val uiState: StateFlow<FilterUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<FilterNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    init {
        loadFilters()
    }

    private fun loadFilters() {
        viewModelScope.launch {
            _uiState.value = FilterUiState.Loading
            _uiState.value = FilterUiState.Success(
                locations = HardcodedData.locations,
                budgets = HardcodedData.budgets
            )
        }
    }

    fun resetUiState() {
        _uiState.value = FilterUiState.Init
    }
}