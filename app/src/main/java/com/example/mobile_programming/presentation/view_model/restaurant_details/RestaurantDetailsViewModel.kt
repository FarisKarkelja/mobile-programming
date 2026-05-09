package com.example.mobile_programming.presentation.view_model.restaurant_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.drink.DrinkRepository
import com.example.mobile_programming.model.repository.food_dish.FoodDishRepository
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.restaurant.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailsViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepository,
    private val drinkRepository: DrinkRepository,
    private val foodDishRepository: FoodDishRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<RestaurantDetailsUiState>(RestaurantDetailsUiState.Init)
    val uiState: StateFlow<RestaurantDetailsUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<RestaurantDetailsNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    fun loadRestaurantDetails(restaurantId: String) {
        viewModelScope.launch {
            _uiState.value = RestaurantDetailsUiState.Loading
            try {
                val restaurant = restaurantRepository.getRestaurantById(restaurantId.toLong())
                if (restaurant == null) {
                    _uiState.value = RestaurantDetailsUiState.Error("Restaurant not found")
                    return@launch
                }
                val topDishes = foodDishRepository.getTopDishesByRestaurant(restaurantId.toLong())
                    .map { it.toDomain() }
                val topDrinks = drinkRepository.getTopDrinksByRestaurant(restaurantId.toLong())
                    .map { it.toDomain() }
                _uiState.value = RestaurantDetailsUiState.Success(
                    restaurant = restaurant.toDomain(),
                    topDishes = topDishes,
                    topDrinks = topDrinks
                )
            } catch (e: Exception) {
                _uiState.value = RestaurantDetailsUiState.Error(e.message ?: "Failed to load")
            }
        }
    }

    fun resetUiState() {
        _uiState.value = RestaurantDetailsUiState.Init
    }
}