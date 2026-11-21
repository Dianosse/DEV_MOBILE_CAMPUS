package com.example.campus.model

sealed class EventsContent {
    data class Success(val events: List<Event>) : EventsContent()
    data object Empty : EventsContent()
}