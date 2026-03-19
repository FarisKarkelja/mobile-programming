package com.example.mobile_programming.presentation.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.presentation.ui.components.*
import com.example.mobile_programming.presentation.ui.util.AuthValidators

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    onAppleSignInClick: () -> Unit,
    onNavigateToRegister: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var hasTriedSubmit by remember { mutableStateOf(false) }

    val emailError = if (hasTriedSubmit) AuthValidators.validateEmail(email) else null
    val passwordError = if (hasTriedSubmit) AuthValidators.validatePassword(password) else null

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        AuthHeader(title = "Welcome Back", subtitle = "Log in to your account to continue.")
        VerticalSpace(24.dp)

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
            isError = passwordError != null,
            errorMessage = passwordError
        )
        VerticalSpace(24.dp)

        AuthPrimaryButton(
            text = "Login",
            onClick = {
                hasTriedSubmit = true
                if (AuthValidators.validateEmail(email) == null && AuthValidators.validatePassword(
                        password
                    ) == null
                ) {
                    onLoginClick()
                }
            }
        )
        VerticalSpace(24.dp)

        AuthDivider()
        VerticalSpace(24.dp)

        SocialSignInButton(
            text = "Sign in with Google",
            onClick = onGoogleSignInClick,
            icon = { GoogleIcon() })
        VerticalSpace(16.dp)

        SocialSignInButton(
            text = "Sign in with Apple",
            onClick = onAppleSignInClick,
            icon = { AppleIcon() })
        VerticalSpace(24.dp)

        AuthFooterText(
            normalText = "Don't have an account?",
            actionText = "Register",
            onActionClick = onNavigateToRegister
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen({}, {}, {}, {})
}