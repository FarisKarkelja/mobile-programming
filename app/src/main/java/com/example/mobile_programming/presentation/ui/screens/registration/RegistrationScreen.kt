package com.example.mobile_programming.presentation.ui.screens.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.presentation.ui.components.*
import com.example.mobile_programming.presentation.ui.util.AuthValidators

@Composable
fun RegistrationScreen(
    onRegisterClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    onAppleSignInClick: () -> Unit,
    onNavigateToLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var hasTriedSubmit by remember { mutableStateOf(false) }

    val nameError = if (hasTriedSubmit) AuthValidators.validateFullName(fullName) else null
    val emailError = if (hasTriedSubmit) AuthValidators.validateEmail(email) else null
    val passwordError = if (hasTriedSubmit) AuthValidators.validatePassword(password) else null
    val confirmPasswordError = if (hasTriedSubmit) AuthValidators.validateConfirmPassword(
        password,
        confirmPassword
    ) else null

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        AuthHeader(title = "Create Account", subtitle = "Sign up to get started.")
        VerticalSpace(24.dp)

        AuthTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = "Full Name",
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            isError = nameError != null,
            errorMessage = nameError
        )
        VerticalSpace(16.dp)

        AuthTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            keyboardType = KeyboardType.Email,
            isError = emailError != null,
            errorMessage = emailError
        )
        VerticalSpace(16.dp)

        PasswordTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            isError = passwordError != null,
            errorMessage = passwordError
        )
        VerticalSpace(16.dp)

        PasswordTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirm Password",
            isError = confirmPasswordError != null,
            errorMessage = confirmPasswordError
        )
        VerticalSpace(24.dp)

        AuthPrimaryButton(
            text = "Register",
            onClick = {
                hasTriedSubmit = true
                if (
                    AuthValidators.validateFullName(fullName) == null &&
                    AuthValidators.validateEmail(email) == null &&
                    AuthValidators.validatePassword(password) == null &&
                    AuthValidators.validateConfirmPassword(password, confirmPassword) == null
                ) {
                    onRegisterClick()
                }
            }
        )
        VerticalSpace(24.dp)

        AuthDivider()
        VerticalSpace(24.dp)

        SocialSignInButton(
            text = "Sign up with Google",
            onClick = onGoogleSignInClick,
            icon = { GoogleIcon() })
        VerticalSpace(16.dp)

        SocialSignInButton(
            text = "Sign up with Apple",
            onClick = onAppleSignInClick,
            icon = { AppleIcon() })
        VerticalSpace(24.dp)

        AuthFooterText(
            normalText = "Already have an account?",
            actionText = "Login",
            onActionClick = onNavigateToLogin
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen({}, {}, {}, {})
}