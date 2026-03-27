package com.example.mobile_programming.presentation.ui.util

import android.util.Patterns

object AuthValidators {
    fun validateEmail(email: String): String? {
        if (email.isBlank()) {
            return "Email cannot be empty"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "Invalid email format"
        }
        return null
    }

    fun validatePassword(password: String): String? {
        if (password.isBlank()) {
            return "Password cannot be empty"
        }
        if (password.length < 6) {
            return "Password must be at least 6 characters long"
        }
        return null
    }

    fun validateFullName(fullName: String): String? {
        if (fullName.isBlank()) {
            return "Full name cannot be empty"
        }
        return null
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): String? {
        if (confirmPassword.isBlank()) {
            return "Confirm password cannot be empty"
        }
        if (password != confirmPassword) {
            return "Passwords do not match"
        }
        return null
    }
}