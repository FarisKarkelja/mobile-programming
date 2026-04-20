package com.example.mobile_programming.presentation.navigation.bottomBar

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.White

@Composable
fun BottomBarNavigationComponent(
    items: List<BottomBarNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    Surface(
        color = TextPrimary,
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
        ) {
            items.forEachIndexed { index, item ->
                val selected = selectedItemIndex == index

                NavigationBarItem(
                    modifier = Modifier.wrapContentSize(),
                    selected = selected,
                    onClick = { onItemSelected(index) },
                    label = {
                        Text(
                            text = stringResource(id = item.titleId),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 12.sp,
                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                            )
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = stringResource(id = item.titleId)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = SunsetTangerine,
                        selectedTextColor = SunsetTangerine,
                        unselectedIconColor = White,
                        unselectedTextColor = White,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBarNavigationComponent(
        items = BottomBarNavigationItems.items,
        selectedItemIndex = 0,
        onItemSelected = {}
    )
}

@Preview(showBackground = true)
@Composable
fun BottomBarSelectedPreview() {
    BottomBarNavigationComponent(
        items = BottomBarNavigationItems.items,
        selectedItemIndex = 1,
        onItemSelected = {}
    )
}