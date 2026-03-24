package com.example.mobile_programming.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.ErrorColor
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream

@Composable
fun AuthHeader(title: String, subtitle: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        VerticalSpace(8.dp)
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            color = TextPrimary
        )
    }
}

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            leadingIcon = leadingIcon,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = isError,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = SunsetTangerine,
                unfocusedBorderColor = TextPrimary,
                errorBorderColor = TextPrimary,
                focusedLabelColor = SunsetTangerine,
                errorLabelColor = TextPrimary,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary,
                errorTextColor = TextPrimary
            )
        )
        if (isError && !errorMessage.isNullOrEmpty()) {
            Text(
                text = errorMessage,
                color = ErrorColor,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Password",
    isError: Boolean = false,
    errorMessage: String? = null
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            leadingIcon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = null,
                    tint = TextPrimary
                )
            },
            trailingIcon = {
                Text(
                    text = if (passwordVisible) stringResource(R.string.hide) else stringResource(
                        R.string.show
                    ),
                    modifier = Modifier
                        .clickable { passwordVisible = !passwordVisible }
                        .padding(end = dimensionResource(id = R.dimen.padding_14)),
                    color = TextPrimary
                )
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = isError,
            singleLine = true,
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = SunsetTangerine,
                unfocusedBorderColor = TextPrimary,
                errorBorderColor = TextPrimary,
                focusedLabelColor = SunsetTangerine,
                errorLabelColor = TextPrimary,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary,
                errorTextColor = TextPrimary
            ),
            modifier = Modifier.fillMaxWidth()
        )
        if (isError && !errorMessage.isNullOrEmpty()) {
            Text(
                text = errorMessage,
                color = ErrorColor,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun AuthPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
        colors = ButtonDefaults.buttonColors(
            contentColor = WarmCream,
            containerColor = SunsetTangerine,
            disabledContentColor = WarmCream.copy(alpha = 0.5f),
            disabledContainerColor = SunsetTangerine.copy(alpha = 0.5f)
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.height_50))
    ) {
        Text(text = text)
    }
}

@Composable
fun AuthDivider() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        HorizontalDivider(modifier = Modifier.weight(1f))
        Text(
            stringResource(R.string.or),
            color = TextPrimary,
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_8))
        )
        HorizontalDivider(modifier = Modifier.weight(1f))
    }
}

@Composable
fun SocialSignInButton(
    text: String,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = TextPrimary
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.height_50))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            icon()
            HorizontalSpace(dimensionResource(id = R.dimen.width_8))
            Text(text)
        }
    }
}

@Composable
fun GoogleIcon() {
    Icon(
        painter = painterResource(id = R.drawable.google_icon),
        contentDescription = "Google Icon",
        modifier = Modifier.size(dimensionResource(id = R.dimen.size_24)),
        tint = TextPrimary
    )
}

@Composable
fun AppleIcon() {
    Icon(
        painter = painterResource(id = R.drawable.apple_icon),
        contentDescription = "Apple Icon",
        modifier = Modifier.size(dimensionResource(id = R.dimen.size_24)),
        tint = TextPrimary
    )
}

@Composable
fun AuthFooterText(
    normalText: String,
    actionText: String,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(horizontalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {
        Text(text = normalText, color = TextPrimary)
        HorizontalSpace(dimensionResource(id = R.dimen.width_4))
        Text(
            text = actionText,
            color = SunsetTangerine,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { onActionClick() }
        )
    }
}