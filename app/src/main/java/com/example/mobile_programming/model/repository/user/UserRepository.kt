package com.example.mobile_programming.model.repository.user

import com.example.mobile_programming.presentation.ui.screens.profile.util.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: User): Long
    suspend fun getUserByEmailAndPassword(email: String, password: String): User?
    suspend fun getUserByEmail(email: String): User?
    suspend fun getUserById(id: Long): User?
    fun observeUserById(id: Long): Flow<User?>
    suspend fun updateUser(user: User)
    suspend fun deleteUser(user: User)
}