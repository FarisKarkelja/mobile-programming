package com.example.mobile_programming.presentation.view_model.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.restaurant.RestaurantRepository
import com.example.mobile_programming.model.repository.user.SessionRepository
import com.example.mobile_programming.model.repository.user_restaurant.UserRestaurantRepository
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepository,
    private val userRestaurantRepository: UserRestaurantRepository,
    private val sessionRepository: SessionRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<RestaurantUiState>(RestaurantUiState.Init)
    val uiState: StateFlow<RestaurantUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<RestaurantNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    private var filteredRestaurants = emptyList<Restaurant>()

    fun loadRestaurants(categoryId: String, location: String, budget: String, minRating: Float) {
        viewModelScope.launch {
            _uiState.value = RestaurantUiState.Loading
            val userId = sessionRepository.observeLoggedInUserId().first() ?: 0L
            val (start, end) = parseBudget(budget)
            restaurantRepository.getFilteredRestaurants(
                userId = userId,
                categoryId = categoryId.toLong(),
                startValue = start,
                endValue = end,
                location = location,
                minRating = minRating
            ).catch { e ->
                _uiState.value = RestaurantUiState.Error(e.message ?: "Failed to load restaurants.")
            }.collect { restaurantsWithFavorite ->
                val restaurants = restaurantsWithFavorite.map { it.toDomain() }
                filteredRestaurants = restaurants
                _uiState.value = RestaurantUiState.Success(searchQuery = "", restaurants)
            }
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
        viewModelScope.launch {
            try {
                val userId = sessionRepository.observeLoggedInUserId().first() ?: 0L
                when (val current = _uiState.value) {
                    is RestaurantUiState.Success -> {
                        val restaurant = current.restaurants.find { it.id == restaurantId }
                        if (restaurant != null) {
                            if (restaurant.isFavorite) {
                                userRestaurantRepository.deleteFavoriteRestaurant(
                                    userId = userId,
                                    restaurantId = restaurantId.toLong()
                                )
                            } else {
                                userRestaurantRepository.insertFavoriteRestaurant(
                                    restaurantId = restaurantId.toLong(),
                                    userId = userId
                                )
                            }
                        }
                    }

                    else -> Unit
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value =
                    RestaurantUiState.Error(
                        e.message ?: "Failed to update favorite restaurant's state."
                    )
            }
        }
    }

    private fun parseBudget(budget: String): Pair<Int, Int> {
        return when (budget) {
            "Under 20 BAM" -> Pair(0, 20)
            "20 - 50 BAM" -> Pair(20, 50)
            "50 - 100 BAM" -> Pair(50, 100)
            "100+ BAM" -> Pair(100, Int.MAX_VALUE)
            else -> Pair(0, Int.MAX_VALUE)
        }
    }

    fun resetUiState() {
        _uiState.value = RestaurantUiState.Init
    }
}
