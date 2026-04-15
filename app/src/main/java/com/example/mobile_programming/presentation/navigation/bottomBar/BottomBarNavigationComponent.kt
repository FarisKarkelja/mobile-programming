package com.example.mobile_programming.presentation.navigation.bottomBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.theme.TextPrimary

@Composable
fun BottomBarNavigationComponent(
    items: List<BottomBarNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.size_4),
            topEnd = dimensionResource(id = R.dimen.size_4)
        ),
        color = TextPrimary
    ) {
        NavigationBar(
            containerColor = Color.Transparent
        ) {
            items.forEachIndexed { index, item ->
                val selected = selectedItemIndex == index

                NavigationBarItem(
                    modifier = Modifier.wrapContentSize(),
                    selected = selected,
                    onClick = { onItemSelected(index) },
                    label = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = stringResource(id = item.titleId),
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = if (selected) White else Color.Gray,
                                    fontSize = 12.sp,
                                    fontWeight = if (selected) FontWeight.W400 else FontWeight.W300
                                )
                            )
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = stringResource(id = item.titleId),
                            tint = if (selected) White else Color.Gray
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}