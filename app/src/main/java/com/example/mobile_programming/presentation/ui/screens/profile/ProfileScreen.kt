package com.example.mobile_programming.presentation.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.presentation.theme.*
import com.example.mobile_programming.presentation.ui.components.BottomBar
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.ui.screens.profile.components.LogoutButton
import com.example.mobile_programming.presentation.ui.screens.profile.components.ProfileAvatar
import com.example.mobile_programming.presentation.ui.screens.profile.components.ProfileTextField

@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
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
                text = stringResource(R.string.full_name),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            VerticalSpace(dimensionResource(id = R.dimen.height_32))
            ProfileTextField(
                value = stringResource(R.string.email_placeholder),
                label = "Email",
                leadingIcon = Icons.Default.Email,
                readOnly = true
            )

            VerticalSpace(dimensionResource(id = R.dimen.height_16))
            ProfileTextField(
                value = stringResource(R.string.password_placeholder),
                label = "Password",
                leadingIcon = Icons.Default.Lock,
                readOnly = true,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.weight(1f))
            LogoutButton(
                text = stringResource(R.string.logout_button),
                onClick = { /* TODO: Add logout logic */ },
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_24))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen()
}
