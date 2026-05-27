package com.example.mobile_programming.presentation.view_model.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.user.SessionRepository
import com.example.mobile_programming.model.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val sessionRepository: SessionRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Init)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<ProfileNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    init {
        loadProfile()
    }

    fun loadProfile() {
        viewModelScope.launch {
            _uiState.value = ProfileUiState.Loading
            val userId = sessionRepository.observeLoggedInUserId().first()
            if (userId == null) {
                _uiState.value = ProfileUiState.Error("No active session.")
            } else {
                userRepository.observeUserById(userId)
                    .catch { e ->
                        _uiState.value =
                            ProfileUiState.Error(e.message ?: "Failed to load user profile.")
                    }
                    .collect { user ->
                        if (user == null) {
                            _uiState.value = ProfileUiState.Error("User not found.")
                        } else {
                            _uiState.value = ProfileUiState.Success(user)
                        }
                    }
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            try {
                sessionRepository.clearSession()
                _navigationEvent.send(ProfileNavigationEvent.NavigateBack)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = ProfileUiState.Error(e.message ?: "Logout process failed.")
            }
        }
    }

    fun resetUiState() {
        loadProfile()
    }
}