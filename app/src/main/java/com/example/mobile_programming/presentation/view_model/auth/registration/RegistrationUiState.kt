package com.example.mobile_programming.presentation.view_model.auth.registration

sealed interface RegistrationUiState {
    object Init : RegistrationUiState
    object Loading : RegistrationUiState
    object Success : RegistrationUiState
    data class Error(val message: String) : RegistrationUiState
}