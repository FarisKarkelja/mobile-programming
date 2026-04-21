package com.example.mobile_programming.presentation.view_model.auth.login

sealed interface LoginUiState {
    object Init : LoginUiState
    object Loading : LoginUiState
    data class Success(val isLoggedIn: Boolean) : LoginUiState
    data class Error(val message: String) : LoginUiState
}