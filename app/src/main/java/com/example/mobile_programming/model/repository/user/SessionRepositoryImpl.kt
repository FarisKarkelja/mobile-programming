package com.example.mobile_programming.model.repository.user

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "session")

class SessionRepositoryImpl(
    private val context: Context
) : SessionRepository {
    private val loggedInUserId = longPreferencesKey("logged_in_user_id")

    override suspend fun saveLoggedInUserId(userId: Long) {
        context.dataStore.edit { preferences ->
            preferences[loggedInUserId] = userId
        }
    }

    override fun observeLoggedInUserId(): Flow<Long?> {
        return context.dataStore.data.map { preferences ->
            preferences[loggedInUserId]
        }
    }

    override suspend fun clearSession() {
        context.dataStore.edit { preferences ->
            preferences.remove(loggedInUserId)
        }
    }
}