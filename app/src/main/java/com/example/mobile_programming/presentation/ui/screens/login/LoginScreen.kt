package com.example.mobile_programming.presentation.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.*
import com.example.mobile_programming.presentation.ui.util.AuthValidators
import com.example.mobile_programming.R

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    onAppleSignInClick: () -> Unit,
    onNavigateToRegister: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var hasTriedSubmit by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }

    val emailError = if (hasTriedSubmit) AuthValidators.validateEmail(email) else null
    val passwordError = if (hasTriedSubmit) AuthValidators.validatePassword(password) else null

    LoginScreenContent(
        email = email,
        password = password,
        emailError = emailError,
        passwordError = passwordError,
        isLoginEnabled = true,
        passwordVisible = passwordVisible,
        onPasswordVisibilityChange = { passwordVisible = !passwordVisible },
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        onLoginClick = {
            hasTriedSubmit = true
            if (AuthValidators.validateEmail(email) == null && AuthValidators.validatePassword(
                    password
                ) == null
            ) {
                onLoginSuccess()
            }
        },
        onRegisterClick = onNavigateToRegister,
        onGoogleSignInClick = onGoogleSignInClick,
        onAppleSignInClick = onAppleSignInClick,
        modifier = modifier
    )
}

@Composable
private fun LoginScreenContent(
    email: String,
    password: String,
    emailError: String?,
    passwordError: String?,
    isLoginEnabled: Boolean,
    passwordVisible: Boolean,
    onPasswordVisibilityChange: () -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    onAppleSignInClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WarmCream)
            .padding(dimensionResource(id = R.dimen.padding_24)),
        verticalArrangement = Arrangement.Center
    ) {
        AuthHeader(
            title = stringResource(R.string.login_title),
            subtitle = stringResource(R.string.login_subtitle)
        )

        VerticalSpace(dimensionResource(id = R.dimen.height_24))
        AuthTextField(
            value = email,
            onValueChange = onEmailChange,
            label = "Email",
            leadingIcon = {
                Icon(
                    Icons.Default.Email,
                    contentDescription = null,
                    tint = TextPrimary
                )
            },
            keyboardType = KeyboardType.Email,
            isError = emailError != null,
            errorMessage = emailError
        )

        VerticalSpace(dimensionResource(id = R.dimen.height_16))
        PasswordTextField(
            value = password,
            onValueChange = onPasswordChange,
            isError = passwordError != null,
            errorMessage = passwordError,
            passwordVisible = passwordVisible,
            onPasswordVisibilityChange = onPasswordVisibilityChange
        )

        VerticalSpace(dimensionResource(id = R.dimen.height_24))
        AuthPrimaryButton(
            text = stringResource(R.string.login_button),
            onClick = onLoginClick,
            enabled = isLoginEnabled
        )

        VerticalSpace(dimensionResource(id = R.dimen.height_24))
        AuthDivider()
        VerticalSpace(dimensionResource(id = R.dimen.height_24))

        SocialSignInButton(
            text = stringResource(R.string.google_sign_in),
            onClick = onGoogleSignInClick,
            icon = { GoogleIcon() })
        VerticalSpace(dimensionResource(id = R.dimen.height_16))

        SocialSignInButton(
            text = stringResource(R.string.apple_sign_in),
            onClick = onAppleSignInClick,
            icon = { AppleIcon() })
        VerticalSpace(dimensionResource(id = R.dimen.height_24))

        AuthFooterText(
            normalText = stringResource(R.string.register_redirect),
            actionText = stringResource(R.string.register_action),
            onActionClick = onRegisterClick
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreenContent(
        email = "",
        password = "",
        emailError = null,
        passwordError = null,
        isLoginEnabled = true,
        passwordVisible = false,
        onPasswordVisibilityChange = {},
        onEmailChange = {},
        onPasswordChange = {},
        onLoginClick = {},
        onRegisterClick = {},
        onGoogleSignInClick = {},
        onAppleSignInClick = {}
    )
}