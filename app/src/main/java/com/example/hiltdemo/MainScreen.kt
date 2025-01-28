package com.example.hiltdemo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {

    val newsState by viewModel.newsState.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        when (newsState) {
            is UiState.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            is UiState.Success -> NewsList((newsState as UiState.Success).data)
            is UiState.Error -> Text(
                text = (newsState as UiState.Error).message,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun NewsList(articles: List<Article>) {
    val lazyListState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        state = lazyListState
    ) {
        items(count = articles.size) { index ->
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
                    .border(1.dp, Color.Black, CircleShape)
                    .padding(horizontal = 24.dp, vertical = 12.dp),
                text = articles[index].title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}