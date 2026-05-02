package com.example.mobile_programming.presentation.view_model.restaurant_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.HardcodedData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailsViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<RestaurantDetailsUiState>(RestaurantDetailsUiState.Init)
    val uiState: StateFlow<RestaurantDetailsUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<RestaurantDetailsNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    fun loadRestaurantDetails(restaurantId: String) {
        viewModelScope.launch {
            _uiState.value = RestaurantDetailsUiState.Loading
            val restaurant = HardcodedData.restaurants.find { it.id == restaurantId }
            if (restaurant == null) {
                _uiState.value = RestaurantDetailsUiState.Error("Restaurant not found")
            } else {
                val topDishes = HardcodedData.foodDishes.filter { it.restaurantId == restaurantId }
                val topDrinks = HardcodedData.drinks.filter { it.restaurantId == restaurantId }
                _uiState.value = RestaurantDetailsUiState.Success(
                    restaurant = restaurant,
                    topDishes = topDishes,
                    topDrinks = topDrinks
                )
            }
        }
    }

    fun resetUiState() {
        _uiState.value = RestaurantDetailsUiState.Init
    }
}