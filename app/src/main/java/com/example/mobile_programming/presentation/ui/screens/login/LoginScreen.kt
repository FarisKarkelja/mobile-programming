package com.example.mobile_programming.presentation.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.*
import com.example.mobile_programming.presentation.util.AuthValidators
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.ui.screens.error.ErrorScreen
import com.example.mobile_programming.presentation.ui.screens.loading.LoadingScreen
import com.example.mobile_programming.presentation.view_model.auth.login.LoginNavigationEvent
import com.example.mobile_programming.presentation.view_model.auth.login.LoginUiState
import com.example.mobile_programming.presentation.view_model.auth.login.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    val emailError = AuthValidators.validateEmail(email)
    val passwordError = AuthValidators.validatePassword(password)

    val isLoginEnabled =
        emailError == null && passwordError == null && email.isNotBlank() && password.isNotBlank()

    LaunchedEffect(Unit) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                LoginNavigationEvent.Navigate -> onLoginSuccess()
                LoginNavigationEvent.NavigateBack -> {}
            }
        }
    }

    when (uiState) {
        is LoginUiState.Loading -> LoadingScreen()
        is LoginUiState.Error -> ErrorScreen(
            message = (uiState as LoginUiState.Error).message,
            onRetry = { viewModel.resetUiState() }
        )

        else -> LoginScreen(
            email = email,
            password = password,
            emailError = emailError,
            passwordError = passwordError,
            isLoginEnabled = isLoginEnabled,
            passwordVisible = passwordVisible,
            onPasswordVisibilityChange = { passwordVisible = !passwordVisible },
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onLoginClick = { viewModel.onLoginClick(email, password) },
            onRegisterClick = onNavigateToRegister,
            modifier = Modifier
        )
    }
}

@Composable
private fun LoginScreen(
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
    LoginScreen(
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
    )
}