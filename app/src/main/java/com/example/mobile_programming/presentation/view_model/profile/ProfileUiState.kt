package com.example.mobile_programming.presentation.view_model.profile

import com.example.mobile_programming.presentation.ui.screens.profile.util.User

sealed interface ProfileUiState {
    object Init : ProfileUiState
    object Loading : ProfileUiState
    data class Success(val profileData: User) : ProfileUiState
    data class Error(val message: String) : ProfileUiState
}