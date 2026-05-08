package com.example.mobile_programming.presentation.view_model.auth.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.mappers.mapRegisterInputToEntity
import com.example.mobile_programming.model.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: UserRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<RegistrationUiState>(RegistrationUiState.Init)
    val uiState: StateFlow<RegistrationUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<RegistrationNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    fun onRegisterClick(fullName: String, email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = RegistrationUiState.Loading
            try {
                val existingUser = repository.getUserByEmail(email)
                if (existingUser != null) {
                    _uiState.value = RegistrationUiState.Error("Email already exists.")
                    return@launch
                }

                val newUser = mapRegisterInputToEntity(fullName, email, password)
                repository.insertUser(newUser)

                _uiState.value = RegistrationUiState.Success
                _navigationEvent.send(RegistrationNavigationEvent.Navigate)
            } catch (e: Exception) {
                _uiState.value = RegistrationUiState.Error(e.message ?: "Registration failed.")
            }
        }
    }

    fun resetUiState() {
        _uiState.value = RegistrationUiState.Init
    }
}