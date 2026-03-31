package com.example.mobile_programming.presentation.ui.screens.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.*
import com.example.mobile_programming.presentation.ui.util.AuthValidators

@Composable
fun RegistrationScreen(
    onRegisterSuccess: () -> Unit,
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
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val nameError = if (hasTriedSubmit) AuthValidators.validateFullName(fullName) else null
    val emailError = if (hasTriedSubmit) AuthValidators.validateEmail(email) else null
    val passwordError = if (hasTriedSubmit) AuthValidators.validatePassword(password) else null
    val confirmPasswordError = if (hasTriedSubmit) AuthValidators.validateConfirmPassword(
        password,
        confirmPassword
    ) else null

    RegistrationScreenContent(
        fullName = fullName,
        email = email,
        password = password,
        confirmPassword = confirmPassword,
        passwordVisible = passwordVisible,
        confirmPasswordVisible = confirmPasswordVisible,
        fullNameError = nameError,
        emailError = emailError,
        passwordError = passwordError,
        confirmPasswordError = confirmPasswordError,
        isRegisterEnabled = true,
        onFullNameChange = { fullName = it },
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        onConfirmPasswordChange = { confirmPassword = it },
        onPasswordVisibilityChange = { passwordVisible = !passwordVisible },
        onConfirmPasswordVisibilityChange = { confirmPasswordVisible = !confirmPasswordVisible },
        onRegisterClick = {
            hasTriedSubmit = true
            if (
                AuthValidators.validateFullName(fullName) == null &&
                AuthValidators.validateEmail(email) == null &&
                AuthValidators.validatePassword(password) == null &&
                AuthValidators.validateConfirmPassword(password, confirmPassword) == null
            ) {
                onRegisterSuccess()
            }
        },
        onLoginClick = onNavigateToLogin,
        onGoogleClick = onGoogleSignInClick,
        onAppleClick = onAppleSignInClick,
        modifier = modifier
    )
}

@Composable
private fun RegistrationScreenContent(
    fullName: String,
    email: String,
    password: String,
    confirmPassword: String,
    passwordVisible: Boolean,
    confirmPasswordVisible: Boolean,
    fullNameError: String?,
    emailError: String?,
    passwordError: String?,
    confirmPasswordError: String?,
    isRegisterEnabled: Boolean,
    onFullNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onPasswordVisibilityChange: () -> Unit,
    onConfirmPasswordVisibilityChange: () -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onAppleClick: () -> Unit,
    onLoginClick: () -> Unit,
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
            title = stringResource(R.string.register_title),
            subtitle = stringResource(R.string.register_subtitle)
        )

        VerticalSpace(dimensionResource(id = R.dimen.height_24))
        AuthTextField(
            value = fullName,
            onValueChange = onFullNameChange,
            label = "Full Name",
            leadingIcon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    tint = TextPrimary
                )
            },
            isError = fullNameError != null,
            errorMessage = fullNameError
        )

        VerticalSpace(dimensionResource(id = R.dimen.height_16))
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
            label = "Password",
            isError = passwordError != null,
            errorMessage = passwordError,
            passwordVisible = passwordVisible,
            onPasswordVisibilityChange = onPasswordVisibilityChange
        )

        VerticalSpace(dimensionResource(id = R.dimen.height_16))
        PasswordTextField(
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            label = "Confirm Password",
            isError = confirmPasswordError != null,
            errorMessage = confirmPasswordError,
            passwordVisible = confirmPasswordVisible,
            onPasswordVisibilityChange = onConfirmPasswordVisibilityChange
        )

        VerticalSpace(dimensionResource(id = R.dimen.height_24))
        AuthPrimaryButton(
            text = stringResource(R.string.register_button),
            onClick = onRegisterClick,
            enabled = isRegisterEnabled
        )

        VerticalSpace(dimensionResource(id = R.dimen.height_24))
        AuthDivider()
        VerticalSpace(dimensionResource(id = R.dimen.height_24))

        SocialSignInButton(
            text = stringResource(R.string.google_sign_in),
            onClick = onGoogleClick,
            icon = { GoogleIcon() })
        VerticalSpace(dimensionResource(id = R.dimen.height_16))

        SocialSignInButton(
            text = stringResource(R.string.apple_sign_in),
            onClick = onAppleClick,
            icon = { AppleIcon() })
        VerticalSpace(dimensionResource(id = R.dimen.height_24))

        AuthFooterText(
            normalText = stringResource(R.string.login_redirect),
            actionText = stringResource(R.string.login_action),
            onActionClick = onLoginClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreenContent(
        fullName = "",
        email = "",
        password = "",
        confirmPassword = "",
        passwordVisible = false,
        confirmPasswordVisible = false,
        fullNameError = null,
        emailError = null,
        passwordError = null,
        confirmPasswordError = null,
        isRegisterEnabled = true,
        onPasswordVisibilityChange = {},
        onConfirmPasswordVisibilityChange = {},
        onFullNameChange = {},
        onEmailChange = {},
        onPasswordChange = {},
        onConfirmPasswordChange = {},
        onLoginClick = {},
        onRegisterClick = {},
        onGoogleClick = {},
        onAppleClick = {}
    )
}