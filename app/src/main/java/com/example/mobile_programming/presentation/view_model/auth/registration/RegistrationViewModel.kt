package com.example.mobile_programming.presentation.view_model.auth.registration

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.auth.AuthRepository
import com.example.mobile_programming.model.repository.user.SessionRepository
import com.example.mobile_programming.model.repository.user.UserRepository
import com.example.mobile_programming.presentation.ui.screens.profile.util.User
import com.example.mobile_programming.presentation.util.GoogleAuthClient
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
class RegistrationViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val sessionRepository: SessionRepository,
    private val authRepository: AuthRepository,
    private val googleAuthClient: GoogleAuthClient
) : ViewModel() {
    private val _uiState = MutableStateFlow<RegistrationUiState>(RegistrationUiState.Init)
    val uiState: StateFlow<RegistrationUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<RegistrationNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    fun onRegisterClick(fullName: String, email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = RegistrationUiState.Loading
            try {
                if (fullName.isBlank() || email.isBlank() || password.isBlank()) {
                    _uiState.value = RegistrationUiState.Error("Please fill in all fields.")
                } else {
                    val existingUser = userRepository.getUserByEmail(email)
                    if (existingUser != null) {
                        _uiState.value = RegistrationUiState.Error("Email already in use.")
                    } else {
                        val newUser = User(
                            id = "0",
                            fullName = fullName,
                            email = email,
                            password = password
                        )
                        userRepository.insertUser(newUser)
                        _uiState.value = RegistrationUiState.Success
                        _navigationEvent.send(RegistrationNavigationEvent.Navigate)
                    }
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = RegistrationUiState.Error(e.message ?: "Registration failed.")
            }
        }
    }

    fun onGoogleRegisterClick(context: Context) {
        viewModelScope.launch {
            _uiState.value = RegistrationUiState.Loading
            try {
                val idToken = googleAuthClient.getGoogleIdToken(context)
                val firebaseUser = authRepository.signInWithGoogle(idToken)

                if (firebaseUser == null || firebaseUser.email.isNullOrBlank()) {
                    _uiState.value = RegistrationUiState.Error("Google sign-up failed.")
                    return@launch
                }
                val email = firebaseUser.email.orEmpty()
                val fullName = firebaseUser.displayName ?: "Google User"

                var localUser = userRepository.getUserByEmail(email)
                if (localUser == null) {
                    val newGoogleUser = User(
                        id = "0",
                        fullName = fullName,
                        email = email,
                        password = "GOOGLE_SIGN_IN"
                    )
                    userRepository.insertUser(newGoogleUser)
                    localUser = userRepository.getUserByEmail(email)
                }

                if (localUser != null) {
                    val userIdLong = localUser.id.toLongOrNull() ?: 0L
                    sessionRepository.saveLoggedInUserId(userIdLong)
                    _uiState.value = RegistrationUiState.Success
                    _navigationEvent.send(RegistrationNavigationEvent.Navigate)
                } else {
                    _uiState.value = RegistrationUiState.Error("Failed to create local user.")
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = RegistrationUiState.Error(
                    e.message ?: "Google registration failed. Please try again."
                )
            }
        }
    }

    fun resetUiState() {
        _uiState.value = RegistrationUiState.Init
    }
}