package com.zezar.quizunam.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.zezar.quizunam.model.QuizUnamUiState

@Composable
fun HistoryScreen(
   uiState: QuizUnamUiState
) {

    val historyMap = uiState.quizHistoryMap

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(historyMap.entries.toList()) { entry ->
            QuizScoreCard(code = entry.key, score = entry.value)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun QuizScoreCard(code: String, score: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = getQuizTitle(code),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Score: $score",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Date: ${extractDate(code)}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}


fun getQuizTitle(code: String): String {
    return when {
        code.startsWith("QQ") -> "Quick Quiz"
        code.startsWith("ME") -> "Mock Exam"
        else -> "Unknown Quiz"
    }
}

fun extractDate(code: String): String {
    return try {
        val datePart = code.substringAfter("-")
        val day = datePart.take(2)
        val month = datePart.drop(2).take(3)
        val year = "20" + datePart.takeLast(2)
        "$day-$month-$year"
    } catch (e: Exception) {
        "Unknown Date"
    }
}


