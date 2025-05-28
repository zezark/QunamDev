package com.zezar.quizunam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zezar.quizunam.R
import com.zezar.quizunam.data.PreferencesManager
import com.zezar.quizunam.model.QuizUnamUiState
import com.zezar.quizunam.model.Topic
import kotlinx.coroutines.launch

@Composable
fun SyllabusScreen(
    uiState: QuizUnamUiState,
    onClickTopic: (Topic) -> Unit
) {
    val topics = uiState.topics

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Card {
                    Button(onClick = { /* TODO */ }) {
                        Text(text = "Quiz Aleatorio")
                    }
                }
            }
        }
        
        items(topics) { topic ->
            TopicCard(
                topic = topic,
                onClick = {
                    onClickTopic(topic)
                }
            )
        }
    }
}

@Composable
fun TopicCard(
    topic: Topic,
    onClick: () -> Unit
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var progress by remember { mutableFloatStateOf(0f) }

    // Cargar progreso al inicio
    LaunchedEffect(topic.code) {
        val stored = PreferencesManager.getProgress(context, topic.code)
        progress = stored / 100f // suponiendo que es de 0 a 100
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        scope.launch {
                            val newValue = ((progress * 100).toInt() + 1).coerceAtMost(100)
                            PreferencesManager.saveProgress(context, topic.code, newValue)
                            progress = newValue / 100f
                        }
                    }
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = topic.title,
                    style = MaterialTheme.typography.titleMedium
                )
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                )
            }
        }
    }
}


