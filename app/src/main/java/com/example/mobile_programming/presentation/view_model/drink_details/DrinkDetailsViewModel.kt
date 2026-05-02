package com.example.mobile_programming.presentation.view_model.drink_details

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
class DrinkDetailsViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<DrinkDetailsUiState>(DrinkDetailsUiState.Init)
    val uiState: StateFlow<DrinkDetailsUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<DrinkDetailsNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    fun loadDrink(drinkId: String) {
        viewModelScope.launch {
            _uiState.value = DrinkDetailsUiState.Loading
            val drink = HardcodedData.drinks.find { it.id == drinkId }
            if (drink == null) {
                _uiState.value = DrinkDetailsUiState.Error("Drink not found")
            } else {
                _uiState.value = DrinkDetailsUiState.Success(drink)
            }
        }
    }

    fun resetUiState() {
        _uiState.value = DrinkDetailsUiState.Init
    }
}