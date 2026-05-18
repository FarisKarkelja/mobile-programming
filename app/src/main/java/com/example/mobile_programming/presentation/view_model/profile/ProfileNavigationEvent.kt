package com.example.mobile_programming.presentation.view_model.profile

sealed interface ProfileNavigationEvent {
    object Navigate : ProfileNavigationEvent
    object NavigateBack : ProfileNavigationEvent
}