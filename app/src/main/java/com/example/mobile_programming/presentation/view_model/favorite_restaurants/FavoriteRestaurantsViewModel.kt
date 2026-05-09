package com.example.mobile_programming.presentation.view_model.favorite_restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.user.SessionRepository
import com.example.mobile_programming.model.repository.user_restaurant.UserRestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteRestaurantsViewModel @Inject constructor(
    private val userRestaurantRepository: UserRestaurantRepository,
    private val sessionRepository: SessionRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<FavoriteRestaurantsUiState>(FavoriteRestaurantsUiState.Init)
    val uiState: StateFlow<FavoriteRestaurantsUiState> = _uiState.asStateFlow()

    init {
        loadFavorites()
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            _uiState.value = FavoriteRestaurantsUiState.Loading
            sessionRepository.observeLoggedInUserId().collect { userId ->
                val id = userId ?: return@collect
                userRestaurantRepository.getFavoriteRestaurantsByUserId(userId = id)
                    .catch { e ->
                        _uiState.value = FavoriteRestaurantsUiState.Error(
                            e.message ?: "Failed to load favorites"
                        )
                    }
                    .collect { restaurantsWithFavorite ->
                        val restaurants = restaurantsWithFavorite.map { it.toDomain() }
                        _uiState.value = FavoriteRestaurantsUiState.Success(restaurants)
                    }
            }
        }
    }

    fun unfavoriteRestaurant(restaurantId: String) {
        viewModelScope.launch {
            val userId = sessionRepository.observeLoggedInUserId().first() ?: return@launch
            userRestaurantRepository.deleteFavoriteRestaurant(
                userId = userId,
                restaurantId = restaurantId.toLong()
            )
        }
    }

    fun resetUiState() {
        loadFavorites()
    }
}