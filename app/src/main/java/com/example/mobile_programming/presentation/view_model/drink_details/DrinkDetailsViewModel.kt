package com.example.mobile_programming.presentation.view_model.drink_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.drink.DrinkRepository
import com.example.mobile_programming.model.repository.mappers.toDomain
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
class DrinkDetailsViewModel @Inject constructor(
    private val drinkRepository: DrinkRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<DrinkDetailsUiState>(DrinkDetailsUiState.Init)
    val uiState: StateFlow<DrinkDetailsUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<DrinkDetailsNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    private var currentDrinkId: String = ""

    fun loadDrink(drinkId: String) {
        currentDrinkId = drinkId
        viewModelScope.launch {
            _uiState.value = DrinkDetailsUiState.Loading
            try {
                val drinkEntity = drinkRepository.getDrinkById(drinkId.toLong())

                if (drinkEntity == null) {
                    _uiState.value = DrinkDetailsUiState.Error("Drink not found")
                } else {
                    _uiState.value = DrinkDetailsUiState.Success(drinkEntity.toDomain())
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = DrinkDetailsUiState.Error(e.message ?: "Failed to load drink")
            }
        }
    }

    fun resetUiState() {
        loadDrink(currentDrinkId)
    }
}