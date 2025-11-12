package com.example.luizinho.ludoon.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.luizinho.ludoon.data.repository.stories
import com.example.luizinho.ludoon.ui.components.LudoOnBottomBar
import com.example.luizinho.ludoon.ui.components.LudoOnTopBar
import com.example.luizinho.ludoon.ui.components.StoryList

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { LudoOnTopBar() },
        bottomBar = { LudoOnBottomBar() },
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),

        ) {

            StoryList(stories)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen()
}