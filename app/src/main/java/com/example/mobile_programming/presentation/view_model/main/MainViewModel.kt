package com.example.mobile_programming.presentation.view_model.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.user.SessionRepository
import com.example.mobile_programming.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sessionRepository: SessionRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Init)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        determineStartDestination()
    }

    fun determineStartDestination() {
        viewModelScope.launch {
            _uiState.value = MainUiState.Loading
            try {
                val userId = sessionRepository.observeLoggedInUserId().first()

                if (userId != null && userId != 0L) {
                    _uiState.value = MainUiState.Success(Screen.Categories.route)
                } else {
                    _uiState.value = MainUiState.Success(Screen.Login.route)
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = MainUiState.Error(e.message ?: "Failed to determine user session.")
            }
        }
    }

    fun resetUiState() {
        determineStartDestination()
    }
}