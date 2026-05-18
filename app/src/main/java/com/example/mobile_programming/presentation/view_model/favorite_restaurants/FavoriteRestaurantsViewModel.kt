package com.example.mobile_programming.presentation.view_model.favorite_restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.category.CategoryRepository
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.user.SessionRepository
import com.example.mobile_programming.model.repository.user_restaurant.UserRestaurantRepository
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

@HiltViewModel
class FavoriteRestaurantsViewModel @Inject constructor(
    private val userRestaurantRepository: UserRestaurantRepository,
    private val sessionRepository: SessionRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<FavoriteRestaurantsUiState>(FavoriteRestaurantsUiState.Init)
    val uiState: StateFlow<FavoriteRestaurantsUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<FavoriteRestaurantsNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    init {
        loadFavorites()
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            _uiState.value = FavoriteRestaurantsUiState.Loading
            val categories = categoryRepository.getAllCategories().first().map { it.toDomain() }
            sessionRepository.observeLoggedInUserId().collect { userId ->
                if (userId != null) {
                    userRestaurantRepository.getFavoriteRestaurantsByUserId(userId = userId)
                        .catch { e ->
                            _uiState.value = FavoriteRestaurantsUiState.Error(
                                e.message ?: "Failed to load favorites"
                            )
                        }
                        .collect { restaurantsWithFavorite ->
                            val restaurants = restaurantsWithFavorite.map { it.toDomain() }
                            _uiState.value =
                                FavoriteRestaurantsUiState.Success(restaurants, categories)
                        }
                }
            }
        }
    }

    fun unfavoriteRestaurant(restaurantId: String) {
        viewModelScope.launch {
            val userId = sessionRepository.observeLoggedInUserId().first()
            if (userId != null) {
                userRestaurantRepository.deleteFavoriteRestaurant(
                    userId = userId,
                    restaurantId = restaurantId.toLong()
                )
            }
        }
    }

    fun resetUiState() {
        loadFavorites()
    }
}