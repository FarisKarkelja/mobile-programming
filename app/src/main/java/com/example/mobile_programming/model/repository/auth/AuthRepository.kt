package com.example.mobile_programming.model.repository.auth

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun register(email: String, password: String)
    suspend fun login(email: String, password: String)
    suspend fun logout()
    suspend fun getCurrentUserId(): String?
    suspend fun signInWithGoogle(idToken: String): FirebaseUser?
}