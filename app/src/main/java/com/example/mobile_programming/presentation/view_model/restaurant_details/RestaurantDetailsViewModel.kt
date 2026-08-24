package com.example.mobile_programming.presentation.view_model.restaurant_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.drink.DrinkRepository
import com.example.mobile_programming.model.repository.food_dish.FoodDishRepository
import com.example.mobile_programming.model.repository.restaurant.RestaurantRepository
import com.example.mobile_programming.model.repository.review.ReviewRepository
import com.example.mobile_programming.model.repository.user.SessionRepository
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.Review
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class RestaurantDetailsViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepository,
    private val drinkRepository: DrinkRepository,
    private val foodDishRepository: FoodDishRepository,
    private val reviewRepository: ReviewRepository,
    private val sessionRepository: SessionRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<RestaurantDetailsUiState>(RestaurantDetailsUiState.Init)
    val uiState: StateFlow<RestaurantDetailsUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<RestaurantDetailsNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    private val _uiEvent = Channel<RestaurantDetailsUiEvent>(Channel.BUFFERED)
    val uiEvent = _uiEvent.receiveAsFlow()

    fun loadRestaurantDetails(restaurantId: String) {
        viewModelScope.launch {
            _uiState.value = RestaurantDetailsUiState.Loading
            try {
                val restaurant = restaurantRepository.getRestaurantById(restaurantId.toLong())
                if (restaurant == null) {
                    _uiState.value = RestaurantDetailsUiState.Error("Restaurant not found.")
                } else {
                    val topDishes =
                        foodDishRepository.getTopDishesByRestaurant(restaurantId.toLong())
                    val topDrinks = drinkRepository.getTopDrinksByRestaurant(restaurantId.toLong())
                    val reviews = reviewRepository.getReviewsForRestaurant(restaurantId)
                    _uiState.value = RestaurantDetailsUiState.Success(
                        restaurant = restaurant,
                        topDishes = topDishes,
                        topDrinkData = topDrinks,
                        reviews = reviews
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = RestaurantDetailsUiState.Error(
                    e.message ?: "Failed to load restaurant details."
                )
            }
        }
    }

    fun addReview(restaurantId: String, comment: String, rating: Float) {
        viewModelScope.launch {
            try {
                val userId = sessionRepository.observeLoggedInUserId().first()?.toString() ?: ""

                val currentState = _uiState.value
                if (currentState is RestaurantDetailsUiState.Success) {
                    val alreadyReviewed = currentState.reviews.any { it.userId == userId }
                    if (alreadyReviewed) {
                        _uiEvent.send(RestaurantDetailsUiEvent.ShowToast("You have already submitted a review for this restaurant."))
                        return@launch
                    }
                }

                val review = Review(
                    id = "",
                    userId = userId,
                    restaurantId = restaurantId,
                    comment = comment,
                    rating = rating,
                    createdAt = System.currentTimeMillis()
                )
                reviewRepository.addReview(review)
                loadRestaurantDetails(restaurantId)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value =
                    RestaurantDetailsUiState.Error(e.message ?: "Failed to add review.")
            }
        }
    }

    fun resetUiState() {
        _uiState.value = RestaurantDetailsUiState.Init
    }
}