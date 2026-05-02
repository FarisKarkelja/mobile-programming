package com.example.mobile_programming.presentation.view_model.food_dish_details

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
class FoodDishDetailsViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<FoodDishDetailsUiState>(FoodDishDetailsUiState.Init)
    val uiState: StateFlow<FoodDishDetailsUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<FoodDishDetailsNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    fun loadDish(dishId: String) {
        viewModelScope.launch {
            _uiState.value = FoodDishDetailsUiState.Loading
            val dish = HardcodedData.foodDishes.find { it.id == dishId }
            if (dish == null) {
                _uiState.value = FoodDishDetailsUiState.Error("Food dish not found")
            } else {
                _uiState.value = FoodDishDetailsUiState.Success(dish)
            }
        }
    }

    fun resetUiState() {
        _uiState.value = FoodDishDetailsUiState.Init
    }
}