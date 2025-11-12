package com.example.luizinho.ludoon.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import iconBottomBar

// Modelo dos itens da BottomBar
data class BottomBarItem(
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector? = null,
)

@Composable
fun LudoOnBottomBar() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val items = listOf(
        BottomBarItem("Home", Icons.Outlined.Home, Icons.Filled.Home),
        BottomBarItem("Reels", Icons.Outlined.VideoLibrary),
        BottomBarItem("Shop", Icons.AutoMirrored.Outlined.Send),
        BottomBarItem("Search", Icons.Outlined.Search),
        BottomBarItem("Profile", Icons.Outlined.Person)
    )

    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedIndex = index },
                    contentAlignment = Alignment.Center
                ) {
                    BottomIcon(
                        icon = if (selectedIndex == index && item.selectedIcon != null)
                            item.selectedIcon
                        else
                            item.icon,
                        contentDesc = item.label,
                        isSelected = selectedIndex == index
                    )
                }
            }
        }
    }
}

@Composable
fun BottomIcon(
    icon: ImageVector,
    contentDesc: String,
    isSelected: Boolean
) {
    Icon(
        imageVector = icon,
        contentDescription = contentDesc,
        tint = if (isSelected) Color.Black else Color.Gray,
        modifier = Modifier.size(iconBottomBar)
    )
}

@Preview(showBackground = true)
@Composable
fun LudoOnBottomBarPreview() {
    Scaffold(
        bottomBar = { LudoOnBottomBar() }
    ) { innerPadding ->
        Text(
            text = "Conteúdo do feed aqui",
            modifier = Modifier.padding(innerPadding)
        )
    }
}
