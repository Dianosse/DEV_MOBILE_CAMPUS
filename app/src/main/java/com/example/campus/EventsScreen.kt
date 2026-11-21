package com.example.campus

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.campus.model.EventsContent

@Composable
fun EventsScreen(viewModel: EventsViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val content = uiState.content) {
        is EventsContent.Success -> EventListScreen(
            events = content.events,
            favoriteIds = uiState.favoriteIds,
            onFavoriteToggle = { viewModel.onFavoriteClick(it) }
        )
        EventsContent.Empty -> Text(stringResource(R.string.noEvent))
    }
}