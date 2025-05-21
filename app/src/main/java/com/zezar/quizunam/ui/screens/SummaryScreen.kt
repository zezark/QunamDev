package com.zezar.quizunam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.zezar.quizunam.R
import com.zezar.quizunam.data.PreferencesManager
import com.zezar.quizunam.model.UserQuestion


@Composable
fun SummaryScreen(
    userQuestions: List<UserQuestion>,
    onRestart: () -> Unit
) {

    val correctCount = userQuestions.count { it.isCorrect }
    val total = userQuestions.size

    LazyColumn {
        item {
            Text(
                text = "Resultado",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        item {
            Text(
                text = "Obtuviste $correctCount de $total respuestas correctas",
                style = MaterialTheme.typography.titleMedium,
                color = if (correctCount >= total / 2) Color(0xFF4CAF50) else Color.Red,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }

        items(userQuestions) { question ->

            if (question.question.codeSubject == "MAT") {
                SummaryMathQuestionCard(question)
            } else {
                SummaryQuestionCard(question)
            }

        }

        item {
            Button(
                onClick = onRestart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Reiniciar")
            }
        }

    }


    /*
    val correctCount = userQuestions.count { it.isCorrect }
    val total = userQuestions.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Resultado",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Obtuviste $correctCount de $total respuestas correctas",
            style = MaterialTheme.typography.titleMedium,
            color = if (correctCount >= total / 2) Color(0xFF4CAF50) else Color.Red,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Lista de preguntas y resultados
        userQuestions.forEachIndexed { index, uq ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (uq.isCorrect) Color(0xFFE8F5E9) else Color(0xFFFFEBEE)
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "${index + 1}. ${uq.question.description}", color = Color.Black)
                    if (uq.question.image?.isNotEmpty() == true) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "A) ${uq.question.optionA}", color = Color.DarkGray)
                    Text(text = "B) ${uq.question.optionB}", color = Color.DarkGray)
                    Text(text = "C) ${uq.question.optionC}", color = Color.DarkGray)
                    Text(text = "D) ${uq.question.optionD}", color = Color.DarkGray)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Tu respuesta: ${uq.selectedAnswer}" , color = Color.DarkGray)
                    Text(text = "Correcta: ${uq.question.answer}", color = Color.DarkGray)
                    Text(
                        text = if (uq.isCorrect) "✔ Correcto" else "✘ Incorrecto",
                        color = if (uq.isCorrect) Color(0xFF2E7D32) else Color.Red,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onRestart,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Reiniciar")
        }


    }

     */
}

@Composable
fun SummaryMathQuestionCard(question: UserQuestion) {

    Card {
        Column {
            Text(text = "Math card")
            Text(text = question.question.description)
            Text(text = "A) ${question.question.optionA}")
            Text(text = "B) ${question.question.optionB}")
            Text(text = "C) ${question.question.optionC}")
            Text(text = "D) ${question.question.optionD}")
            Text(text = "Correct -> ${question.selectedAnswer}")
            Text(text = "Mi respuesta -> ${question.question.answer}")
        }
    }
}

@Composable
fun SummaryQuestionCard(question: UserQuestion) {

    Card {
        Column {
            Text(text = "Normal card")
            Text(text = question.question.description)
            Text(text = "A) ${question.question.optionA}")
            Text(text = "B) ${question.question.optionB}")
            Text(text = "C) ${question.question.optionC}")
            Text(text = "D) ${question.question.optionD}")
            Text(text = "Correct -> ${question.selectedAnswer}")
            Text(text = "Mi respuesta -> ${question.question.answer}")
        }
    }


}
