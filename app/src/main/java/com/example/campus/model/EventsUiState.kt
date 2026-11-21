package com.example.campus.model

data class EventsUiState(
    val content: EventsContent = EventsContent.Empty,
    val favoriteIds: List<Int> = emptyList()
)
