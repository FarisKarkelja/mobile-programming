package com.example.mobile_programming.presentation.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
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
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalSpace(32.dp)
            ProfileAvatar()

            VerticalSpace(16.dp)
            Text(
                text = stringResource(R.string.full_name),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            VerticalSpace(32.dp)
            ProfileTextField(
                value = stringResource(R.string.email_placeholder),
                label = "Email",
                leadingIcon = Icons.Default.Email,
                readOnly = true
            )

            VerticalSpace(16.dp)

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
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
    }
}