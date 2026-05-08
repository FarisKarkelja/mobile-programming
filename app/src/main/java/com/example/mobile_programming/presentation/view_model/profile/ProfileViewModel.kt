package com.example.mobile_programming.presentation.view_model.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException
import kotlin.text.toLong

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Init)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private val _navigationEvent = Channel<ProfileNavigationEvent>(Channel.BUFFERED)
    val navigationEvent = _navigationEvent.receiveAsFlow()


    init {
        loadProfile(1)
    }

    fun loadProfile(userId: Int) {
        viewModelScope.launch {
            _uiState.value = ProfileUiState.Loading
            try {
                val userEntity = repository.getUserById(userId.toLong())

                if (userEntity != null) {
                    _uiState.value = ProfileUiState.Success(userEntity.toDomain())
                } else {
                    _uiState.value = ProfileUiState.Error("User not found")
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = ProfileUiState.Error(e.message ?: "Failed to load profile.")
            }
        }
    }

    fun resetUiState() {
        loadProfile(1)
    }
}