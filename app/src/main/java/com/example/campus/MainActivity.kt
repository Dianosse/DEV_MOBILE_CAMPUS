package com.example.campus

import android.content.res.Configuration.*
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
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
                    Event(1, "Conférence Kotlin", "TECH", "Salle 204", 30, "C'est une conférence"),
                    Event(2, "Atelier Android", "TECH", null, 15, "C'est un atelier"),
                    Event(3, "Tournoi", "SPORT", "Gymnase", 0, "C'est un tournoi"),
                    Event(4, "Concert", "MUSIQUE", "Amphi A", 100, "C'est un concert"),
                    Event(5, "ForumForumForumForumForumForumForum", "CAMPUS", "Hall", 50, "C'est plein plein plein de forum")
                )

                val categories = listOf(
                    "TECH",
                    "SPORT",
                    "MUSIQUE",
                    "CAMPUS",
                    "MUSIQUE",
                    "CAMPUS",
                    "MUSIQUE",
                    "CAMPUS",
                    "MUSIQUE",
                    "CAMPUS",
                    "MUSIQUE",
                    "CAMPUS",
                    "MUSIQUE",
                    "CAMPUS",
                    "MUSIQUE",
                    "CAMPUS"
                )

                EventListScreen(events, categories)
            }
        }
    }
}



@Composable
fun EventDetailScreen(event: Event, onBook: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img_event),
            contentDescription = stringResource(R.string.desc_img_event),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                event.title,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(event.category)
        }
        Text(event.location ?: stringResource(R.string.no_location))
        Text(
            event.description,
            modifier = Modifier
                .heightIn(max = 150.dp)
                .verticalScroll(rememberScrollState())
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onBook,
                enabled = event.capacity > 0
            ) {
                Text(stringResource(R.string.reserver))
            }
            Text(pluralStringResource(R.plurals.nb_places, event.capacity, event.capacity))
        }
    }
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun EventDetailScreenPreviewLight() {
    val event = Event(
        id = 1,
        title = "Conférence KotlinConférence KotlinConférence KotlinConférence KotlinConférence Kotlin",
        category = "TECH",
        location = "Salle 204",
        capacity = 0,
        description = "C'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférence"
    )

    CampusTheme {
        EventDetailScreen(
            event = event,
            onBook = {}
        )
    }

}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun EventDetailScreenPreviewDark() {
    val event = Event(
        id = 1,
        title = "Conférence KotlinConférence KotlinConférence KotlinConférence KotlinConférence Kotlin",
        category = "TECH",
        location = "Salle 204",
        capacity = 0,
        description = "C'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférenceC'est une conférence"
    )

    CampusTheme {
        EventDetailScreen(
            event = event,
            onBook = {}
        )
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(events : List<Event>, categories: List<String>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.campus)) })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item{
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(categories) { category ->
                        Text(category)
                    }
                }
            }
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


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun EventCardPreviewLight() {
    val event = Event(
        id = 1,
        title = "Conférence KotlinConférence KotlinConférence KotlinConférence KotlinConférence Kotlin",
        category = "TECH",
        location = "Salle 204",
        capacity = 0,
        description = "C'est une conférence"
    )

    CampusTheme {
        EventCard(
            event = event,
            onClick = {},
            onBook = {}
        )
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun EventCardPreviewDark() {
    val event = Event(
        id = 1,
        title = "Conférence KotlinConférence KotlinConférence KotlinConférence KotlinConférence Kotlin",
        category = "TECH",
        location = "Salle 204",
        capacity = 0,
        description = "C'est une conférence"
    )

    CampusTheme {
        EventCard(
            event = event,
            onClick = {},
            onBook = {}
        )
    }
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
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    event.category,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(event.location ?: stringResource(R.string.no_location))
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onBook,
                    enabled = event.capacity > 0
                ) {
                    Text(stringResource(R.string.reserver))
                }
                TextButton(
                    onClick = onClick
                ) {
                    Text(stringResource(R.string.event_details))
                }
            }
        }
    }
}





@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun EventListScreenPreviewLight() {
    CampusTheme {
        EventListScreen(
            events = listOf(
                Event(1, "Conférence Kotlin", "TECH", "Salle 204", 30, "Description"),
                Event(2, "Tournoi", "SPORT", "Gymnase", 0, "Description")
            ),
            categories = listOf("TECH", "SPORT")
        )
    }
}



@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun EventListScreenPreviewDark() {
    CampusTheme {
        EventListScreen(
            events = listOf(
                Event(1, "Conférence Kotlin", "TECH", "Salle 204", 30, "Description"),
                Event(2, "Tournoi", "SPORT", "Gymnase", 0, "Description")
            ),
            categories = listOf("TECH", "SPORT")
        )
    }
}