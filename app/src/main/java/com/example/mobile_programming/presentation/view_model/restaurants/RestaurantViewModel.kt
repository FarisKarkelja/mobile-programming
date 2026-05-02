package com.example.mobile_programming.presentation.view_model.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.isWithinBudget
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<RestaurantUiState>(RestaurantUiState.Init)
    val uiState: StateFlow<RestaurantUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<RestaurantNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    private var filteredRestaurants = emptyList<Restaurant>()

    fun loadRestaurants(
        categoryId: String,
        location: String,
        budget: String,
        minRating: Float
    ) {
        viewModelScope.launch {
            _uiState.value = RestaurantUiState.Loading
            val restaurants = HardcodedData.restaurants
            val filtered = restaurants.filter { restaurant ->
                restaurant.categoryId == categoryId &&
                        restaurant.location == location &&
                        restaurant.rating >= minRating &&
                        isWithinBudget(restaurant.avgPrice, budget)
            }
            filteredRestaurants = filtered
            _uiState.value = RestaurantUiState.Success(searchQuery = "", filtered)
        }
    }

    fun onSearchQueryChange(query: String) {
        when (val current = _uiState.value) {
            is RestaurantUiState.Success -> {
                val searched = if (query.isBlank()) {
                    filteredRestaurants
                } else {
                    filteredRestaurants.filter { it.name.contains(query, ignoreCase = true) }
                }
                _uiState.value = current.copy(searchQuery = query, restaurants = searched)
            }

            else -> Unit
        }
    }

    fun onSortAZ() {
        when (val current = _uiState.value) {
            is RestaurantUiState.Success -> _uiState.value = current.copy(
                restaurants = current.restaurants.sortedBy { it.name }
            )

            else -> Unit
        }
    }

    fun onSortZA() {
        when (val current = _uiState.value) {
            is RestaurantUiState.Success -> _uiState.value = current.copy(
                restaurants = current.restaurants.sortedByDescending { it.name }
            )

            else -> Unit
        }
    }

    fun onSortRatingLow() {
        when (val current = _uiState.value) {
            is RestaurantUiState.Success -> _uiState.value = current.copy(
                restaurants = current.restaurants.sortedBy { it.rating }
            )

            else -> Unit
        }
    }

    fun onSortRatingHigh() {
        when (val current = _uiState.value) {
            is RestaurantUiState.Success -> _uiState.value = current.copy(
                restaurants = current.restaurants.sortedByDescending { it.rating }
            )

            else -> Unit
        }
    }

    fun toggleFavorite(restaurantId: String) {
        when (val current = _uiState.value) {
            is RestaurantUiState.Success -> {
                filteredRestaurants = filteredRestaurants.map {
                    if (it.id == restaurantId) it.copy(isFavorite = !it.isFavorite) else it
                }
                _uiState.value = current.copy(
                    restaurants = current.restaurants.map {
                        if (it.id == restaurantId) it.copy(isFavorite = !it.isFavorite) else it
                    }
                )
            }

            else -> Unit
        }
    }

    fun resetUiState() {
        _uiState.value = RestaurantUiState.Init
    }
}
