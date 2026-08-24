package com.example.mobile_programming.presentation.view_model.food_dish_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.food_dish.FoodDishRepository
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
class FoodDishDetailsViewModel @Inject constructor(
    private val foodDishRepository: FoodDishRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<FoodDishDetailsUiState>(FoodDishDetailsUiState.Init)
    val uiState: StateFlow<FoodDishDetailsUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<FoodDishDetailsNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    private var currentDishId: String = ""

    fun loadDish(dishId: String) {
        currentDishId = dishId
        viewModelScope.launch {
            _uiState.value = FoodDishDetailsUiState.Loading
            try {
                val dishData = foodDishRepository.getDishById(dishId.toLong())
                if (dishData == null) {
                    _uiState.value = FoodDishDetailsUiState.Error("Food dish not found.")
                } else {
                    _uiState.value = FoodDishDetailsUiState.Success(dishData)
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value =
                    FoodDishDetailsUiState.Error(e.message ?: "Failed to load food dish details.")
            }
        }
    }

    fun resetUiState() {
        loadDish(currentDishId)
    }
}