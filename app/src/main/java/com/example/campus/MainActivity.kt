package com.example.campus

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.campus.model.Event
import com.example.campus.ui.theme.CampusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusTheme () {

                val events = listOf(
                    Event(1, "Conférence Kotlin", "TECH", "Salle 204", 30),
                    Event(2, "Atelier Android", "TECH", null, 15),
                    Event(3, "Tournoi", "SPORT", "Gymnase", 0),
                    Event(4, "Concert", "MUSIQUE", "Amphi A", 100),
                    Event(5, "ForumForumForumForumForumForumForum", "CAMPUS", "Hall", 50)
                )

                EventListScreen(events)
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(events : List<Event>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Campus") })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(events, key = { it.id }) { event ->
                EventCard(
                    event = event,
                    onClick = { Log.d("BOUTON VOIR", "Click sur le voir pour l'event : ${event.title}") },
                    onBook = { Log.d("BOUTON RESERVER", "Click sur le Réserver pour l'event : ${event.title}") }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EventCardPreview() {
    val event = Event(
        id = 1,
        title = "Conférence KotlinConférence KotlinConférence KotlinConférence KotlinConférence Kotlin",
        category = "TECH",
        location = "Salle 204",
        capacity = 0
    )

    EventCard(
        event = event,
        onClick = {},
        onBook = {}
    )
}

@Composable
fun EventCard(
    event : Event,
    onClick: () -> Unit,
    onBook: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row (modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    event.title,
                    modifier = Modifier.weight(1f)
                )
                Text(event.category)
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(event.location ?: "Lieu non renseigné")
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onBook,
                    enabled = event.capacity > 0
                ) {
                    Text("Réserver")
                }
                TextButton(
                    onClick = onClick,
                ) {
                    Text("Voir ->")
                }
            }
        }
    }
}