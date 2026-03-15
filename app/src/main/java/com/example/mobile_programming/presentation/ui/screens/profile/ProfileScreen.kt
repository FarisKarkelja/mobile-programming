package com.example.mobile_programming.presentation.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.Black
import com.example.mobile_programming.presentation.theme.DeepTeal
import com.example.mobile_programming.presentation.theme.SunsetTangerine

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileSection(
            name = "Ilma",
            levelDescription = "Building consistency every day"
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_medium)))

        Text(
            text = "Profile Details",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            ProfileDetailField(
                icon = Icons.Default.Person,
                text = "Full Name",
                additionalInfo = "Ilma Player"
            )
            ProfileDetailField(
                icon = Icons.Default.Email,
                text = "Email",
                additionalInfo = "ilma@example.com"
            )
            ProfileDetailField(
                icon = Icons.Default.Lock,
                text = "Password",
                additionalInfo = "********"
            )
        }
    }
}

@Composable
fun ProfileSection(
    name: String,
    levelDescription: String,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.height(36.dp))

    Box(
        modifier = modifier
            .size(dimensionResource(R.dimen.avatar_large))
            .clip(CircleShape)
            .background(SunsetTangerine),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background), // zamijeni sa svojom slikom
            contentDescription = stringResource(R.string.profile_avatar),
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }

    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

    Text(
        text = "$name Player",
        style = MaterialTheme.typography.titleLarge,
        color = Black,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = levelDescription,
        style = MaterialTheme.typography.bodyMedium,
        color = Black
    )
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
fun ProfileDetailField(
    icon: ImageVector,
    text: String,
    additionalInfo: String? = null,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(DeepTeal, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Black,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                color = Black
            )
            additionalInfo?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Black
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen()
    }
}