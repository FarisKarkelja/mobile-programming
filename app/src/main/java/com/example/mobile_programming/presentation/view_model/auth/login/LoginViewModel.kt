package com.example.mobile_programming.presentation.view_model.auth.login

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
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val sessionRepository: SessionRepository,
    private val authRepository: AuthRepository,
    private val googleAuthClient: GoogleAuthClient
) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Init)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<LoginNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()

    fun onLoginClick(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading
            try {
                if (email.isBlank() || password.isBlank()) {
                    _uiState.value = LoginUiState.Error("Please fill in all fields.")
                } else {
                    val user = userRepository.getUserByEmailAndPassword(email, password)
                    if (user == null) {
                        _uiState.value = LoginUiState.Error("Invalid credentials.")
                    } else {
                        val userIdLong = user.id.toLongOrNull() ?: 0L
                        sessionRepository.saveLoggedInUserId(userIdLong)
                        _uiState.value = LoginUiState.Success(isLoggedIn = true)
                        _navigationEvent.send(LoginNavigationEvent.Navigate)
                    }
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = LoginUiState.Error(e.message ?: "Login failed.")
            }
        }
    }

    fun onGoogleLoginClick(context: Context) {
        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading
            try {
                val idToken = googleAuthClient.getGoogleIdToken(context)
                val firebaseUser = authRepository.signInWithGoogle(idToken)

                if (firebaseUser == null || firebaseUser.email.isNullOrBlank()) {
                    _uiState.value = LoginUiState.Error("Google sign-in failed.")
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
                    _uiState.value = LoginUiState.Success(isLoggedIn = true)
                    _navigationEvent.send(LoginNavigationEvent.Navigate)
                } else {
                    _uiState.value = LoginUiState.Error("Failed to create local user.")
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = LoginUiState.Error(
                    e.message ?: "Google login failed. Please try again."
                )
            }
        }
    }

    fun resetUiState() {
        _uiState.value = LoginUiState.Init
    }
}