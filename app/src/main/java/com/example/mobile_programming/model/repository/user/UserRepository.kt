package com.example.mobile_programming.model.repository.user

import com.example.mobile_programming.model.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: UserEntity): Long
    suspend fun getUserByEmailAndPassword(email: String, password: String): UserEntity?
    suspend fun getUserByEmail(email: String): UserEntity?
    suspend fun getUserById(id: Long): UserEntity?
    fun observeUserById(id: Long): Flow<UserEntity?>
    suspend fun updateUser(user: UserEntity)
    suspend fun deleteUser(user: UserEntity)
}