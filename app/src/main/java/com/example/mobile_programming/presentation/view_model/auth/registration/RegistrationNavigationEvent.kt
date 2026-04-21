package com.example.mobile_programming.presentation.view_model.auth.registration

sealed interface RegistrationNavigationEvent {
    object Navigate : RegistrationNavigationEvent
    object NavigateBack : RegistrationNavigationEvent
}