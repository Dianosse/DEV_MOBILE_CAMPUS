package com.example.campus

import androidx.lifecycle.ViewModel
import com.example.campus.data.sampleEvents
import com.example.campus.model.EventsContent
import com.example.campus.model.EventsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EventsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        if(sampleEvents.isEmpty()) {
            EventsUiState()
        } else {
            EventsUiState(content = EventsContent.Success(sampleEvents))
        }
    )
    val uiState: StateFlow<EventsUiState> = _uiState.asStateFlow()

    fun onFavoriteClick(eventId : Int) {
        _uiState.update { current ->
            val ids = current.favoriteIds
            current.copy(
                favoriteIds = if (eventId in ids) ids - eventId else ids + eventId
            )
        }
    }

}
