package com.example.mobile_programming.model.repository

import com.example.mobile_programming.presentation.ui.screens.profile.util.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeProfileRepository {
    suspend fun getProfile(shouldFail: Boolean = false): User = withContext(Dispatchers.IO) {
        delay(2000)

        if (shouldFail) {
            throw IllegalStateException("Failed to load profile.")
        }

        User(
            id = "1",
            fullName = "Jane Doe",
            email = "jane@example.com",
            password = "Jane!!123"
        )
    }
}