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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zezar.quizunam.R
import com.zezar.quizunam.data.PreferencesManager
import com.zezar.quizunam.model.QuizUnamUiState
import com.zezar.quizunam.model.Subject
import com.zezar.quizunam.ui.viewmodel.QuizUnamViewModel
import kotlinx.coroutines.launch

@Composable
fun SubjectScreen(
    uiState: QuizUnamUiState,
    onSubjectClick: (Subject) -> Unit
) {

    val subjects = uiState.subjects

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = R.string.ui_subjects),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(subjects) { subject ->



                SubjectCard(subject = subject, onClick = { onSubjectClick(subject) })
            }
        }
    }
}

@Composable
fun SubjectCardA(subject: Subject, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen de materia
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = subject.name,
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Nombre y progreso
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = subject.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = { subject.progress },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

@Composable
fun getImageRes(imageName: String): Int {
    val context = LocalContext.current
    return remember(imageName) {
        context.resources.getIdentifier(imageName, "drawable", context.packageName)
    }
}

@Composable
fun SubjectCard(subject: Subject, onClick: () -> Unit) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var progress by remember { mutableFloatStateOf(0f) }

    // Cargar progreso al inicio
    LaunchedEffect(subject.code) {
        val stored = PreferencesManager.getProgress(context, subject.code)
        progress = stored / 100f // suponiendo que es de 0 a 100
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen clickeable
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = subject.name,
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        scope.launch {
                            val newValue = ((progress * 100).toInt() + 1).coerceAtMost(100)
                            PreferencesManager.saveProgress(context, subject.code, newValue)
                            progress = newValue / 100f
                        }
                    }
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Nombre y progreso
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = subject.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}
