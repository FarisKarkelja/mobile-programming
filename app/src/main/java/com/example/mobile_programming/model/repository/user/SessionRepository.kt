package com.example.mobile_programming.model.repository.user

import kotlinx.coroutines.flow.Flow

interface SessionRepository {
    suspend fun saveLoggedInUserId(userId: Long)
    fun observeLoggedInUserId(): Flow<Long?>
    suspend fun clearSession()
}