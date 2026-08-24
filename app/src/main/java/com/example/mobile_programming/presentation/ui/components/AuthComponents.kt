package com.example.mobile_programming.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
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
        VerticalSpace(dimensionResource(id = R.dimen.height_8))
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
    errorMessage: String? = null,
    passwordVisible: Boolean,
    onPasswordVisibilityChange: () -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
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
                        .clickable { onPasswordVisibilityChange() }
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
fun AuthDivider(
    modifier: Modifier = Modifier,
    text: String = "OR"
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(dimensionResource(R.dimen.height_1))
                .background(SunsetTangerine.copy(alpha = 0.4f))
        )
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_12)),
            color = SunsetTangerine,
            style = MaterialTheme.typography.bodyMedium
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(dimensionResource(R.dimen.height_1))
                .background(SunsetTangerine.copy(alpha = 0.4f))
        )
    }
}

@Composable
fun SocialSignInButton(
    text: String,
    onClick: () -> Unit,
    icon: Int,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.height_54)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.size_16)),
        border = BorderStroke(
            dimensionResource(R.dimen.width_1),
            SunsetTangerine.copy(alpha = 0.5f)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Social Login Logo",
                tint = Color.Unspecified,
                modifier = Modifier.size(dimensionResource(R.dimen.size_24))
            )
            Spacer(modifier = Modifier.size(dimensionResource(R.dimen.height_8)))
            Text(
                text = text,
                color = TextPrimary,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
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

@Preview(showBackground = true)
@Composable
fun AuthHeaderPreview() {
    AuthHeader(
        title = "Dobrodošli nazad",
        subtitle = "Prijavite se da nastavite sa korištenjem aplikacije"
    )
}

@Preview(showBackground = true)
@Composable
fun AuthTextFieldNormalPreview() {
    AuthTextField(
        value = "korisnik@email.com",
        onValueChange = {},
        label = "Email adresa"
    )
}

@Preview(showBackground = true)
@Composable
fun AuthTextFieldErrorPreview() {
    AuthTextField(
        value = "pogresan-email",
        onValueChange = {},
        label = "Email adresa",
        isError = true,
        errorMessage = "Format email adrese nije ispravan"
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldHiddenPreview() {
    PasswordTextField(
        value = "tajnalozinka",
        onValueChange = {},
        passwordVisible = false,
        onPasswordVisibilityChange = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldVisiblePreview() {
    PasswordTextField(
        value = "tajnalozinka",
        onValueChange = {},
        passwordVisible = true,
        onPasswordVisibilityChange = {}
    )
}

@Preview(showBackground = true)
@Composable
fun AuthPrimaryButtonEnabledPreview() {
    AuthPrimaryButton(
        text = "Prijavi se",
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun AuthPrimaryButtonDisabledPreview() {
    AuthPrimaryButton(
        text = "Prijavi se",
        onClick = {},
        enabled = false
    )
}

@Preview(showBackground = true)
@Composable
fun AuthDividerPreview() {
    AuthDivider()
}

@Preview(showBackground = true)
@Composable
fun SocialSignInButtonPreview() {
    SocialSignInButton(
        text = "Nastavi sa Google-om",
        onClick = {},
        icon = R.drawable.google
    )
}

@Preview(showBackground = true)
@Composable
fun AuthFooterTextPreview() {
    AuthFooterText(
        normalText = "Nemate nalog?",
        actionText = "Registrujte se",
        onActionClick = {}
    )
}