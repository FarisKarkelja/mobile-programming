package com.example.mobile_programming.presentation.view_model.filters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.filter.FilterRepository
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
class FilterViewModel @Inject constructor(
    private val filterRepository: FilterRepository
) : ViewModel() {
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
            try {
                val filters = filterRepository.getFilters()
                _uiState.value = FilterUiState.Success(
                    locations = filters.locations,
                    budgets = filters.budgets
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = FilterUiState.Error(
                    e.message ?: "Failed to load filters"
                )
            }
        }
    }

    fun resetUiState() {
        loadFilters()
    }
}