package com.example.mobile_programming.presentation.ui.screens.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.*
import com.example.mobile_programming.presentation.ui.screens.error.ErrorScreen
import com.example.mobile_programming.presentation.ui.screens.loading.LoadingScreen
import com.example.mobile_programming.presentation.util.AuthValidators
import com.example.mobile_programming.presentation.view_model.auth.registration.RegistrationNavigationEvent
import com.example.mobile_programming.presentation.view_model.auth.registration.RegistrationUiState
import com.example.mobile_programming.presentation.view_model.auth.registration.RegistrationViewModel

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel,
    onRegisterSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var fullName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var confirmPasswordVisible by rememberSaveable { mutableStateOf(false) }

    val isRegisterEnabled = fullName.isNotBlank() &&
            email.isNotBlank() &&
            password.isNotBlank() &&
            confirmPassword.isNotBlank()

    val nameError = AuthValidators.validateFullName(fullName)
    val emailError = AuthValidators.validateEmail(email)
    val passwordError = AuthValidators.validatePassword(password)
    val confirmPasswordError = AuthValidators.validateConfirmPassword(
        password,
        confirmPassword
    )

    LaunchedEffect(Unit) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                RegistrationNavigationEvent.Navigate -> onRegisterSuccess()
                RegistrationNavigationEvent.NavigateBack -> {}
            }
        }
    }

    when (uiState) {
        is RegistrationUiState.Loading -> LoadingScreen()
        is RegistrationUiState.Error -> ErrorScreen(
            message = (uiState as RegistrationUiState.Error).message,
            onRetry = { viewModel.resetUiState() }
        )

        else -> RegistrationScreen(
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
            isRegisterEnabled = isRegisterEnabled,
            onFullNameChange = { fullName = it },
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onConfirmPasswordChange = { confirmPassword = it },
            onPasswordVisibilityChange = { passwordVisible = !passwordVisible },
            onConfirmPasswordVisibilityChange = {
                confirmPasswordVisible = !confirmPasswordVisible
            },
            onRegisterClick = { viewModel.onRegisterClick(fullName, email, password) },
            onLoginClick = onNavigateToLogin,
            modifier = Modifier
        )
    }
}

@Composable
private fun RegistrationScreen(
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
    RegistrationScreen(
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
    )
}