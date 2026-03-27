package com.example.mobile_programming.presentation.ui.screens.profile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.VisualTransformation
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary

@Composable
fun ProfileTextField(
    value: String,
    label: String,
    leadingIcon: ImageVector,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit = {}
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        readOnly = readOnly,
        modifier = modifier.fillMaxWidth(),
        label = { Text(label) },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "$label Icon",
                tint = TextPrimary
            )
        },
        visualTransformation = visualTransformation,
        singleLine = true,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = SunsetTangerine,
            unfocusedBorderColor = TextPrimary,
            focusedLabelColor = SunsetTangerine,
            unfocusedLabelColor = TextPrimary,
            focusedTextColor = TextPrimary,
            unfocusedTextColor = TextPrimary
        )
    )
}