package com.example.mobile_programming.presentation.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobile_programming.presentation.theme.*
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.error.ErrorScreen
import com.example.mobile_programming.presentation.ui.screens.loading.LoadingScreen
import com.example.mobile_programming.presentation.ui.screens.profile.components.LogoutButton
import com.example.mobile_programming.presentation.ui.screens.profile.components.ProfileAvatar
import com.example.mobile_programming.presentation.ui.screens.profile.components.ProfileTextField
import com.example.mobile_programming.presentation.ui.screens.profile.util.User
import com.example.mobile_programming.presentation.view_model.profile.ProfileUiState
import com.example.mobile_programming.presentation.view_model.profile.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onNavigateToLogin: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is ProfileUiState.Loading -> LoadingScreen()
        is ProfileUiState.Error -> ErrorScreen(
            message = state.message,
            onRetry = { viewModel.resetUiState() }
        )

        is ProfileUiState.Success -> ProfileScreen(
            user = state.profileData,
            onLogoutClick = { onNavigateToLogin() }
        )

        is ProfileUiState.Init -> {}
    }
}

@Composable
private fun ProfileScreen(
    user: User,
    onLogoutClick: () -> Unit
) {
    Scaffold(
        topBar = { TopBar() },
        containerColor = WarmCream
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = dimensionResource(id = R.dimen.padding_16)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalSpace(dimensionResource(id = R.dimen.height_32))
            ProfileAvatar()

            VerticalSpace(dimensionResource(id = R.dimen.height_16))
            Text(
                text = user.fullName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            VerticalSpace(dimensionResource(id = R.dimen.height_32))
            ProfileTextField(
                value = user.email,
                label = "Email",
                leadingIcon = Icons.Default.Email,
                readOnly = true
            )

            VerticalSpace(dimensionResource(id = R.dimen.height_16))
            ProfileTextField(
                value = user.password,
                label = "Password",
                leadingIcon = Icons.Default.Lock,
                readOnly = true,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.weight(1f))
            LogoutButton(
                text = stringResource(R.string.logout_button),
                onClick = onLogoutClick,
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_24))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(
        user = HardcodedData.users.first(),
        onLogoutClick = {}
    )
}
