package com.zezar.quizunam.ui.screens

import android.webkit.WebView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.zezar.quizunam.R
import com.zezar.quizunam.model.Question
import com.zezar.quizunam.model.QuizUnamUiState
import com.zezar.quizunam.model.Topic


/*
@Composable
fun QuestionScreen(
    uiState: QuizUnamUiState,
    onAnswerSelected: (String) -> Unit,
    onNext: () -> Unit
) {
    val currentIndex = uiState.currentQuestionIndex
    val totalQuestions = uiState.userQuestions.size

    if (currentIndex >= totalQuestions) return // Evita crash

    val userQuestion = uiState.userQuestions[currentIndex]
    val question = userQuestion.question
    val selected = userQuestion.selectedAnswer

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Pregunta actual y número
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Pregunta ${currentIndex + 1} de $totalQuestions",
                style = MaterialTheme.typography.labelLarge,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = question.description,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Imagen si existe
            if (question.image?.isNotEmpty() == true) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        // Opciones
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            val options = listOf(
                "A" to question.optionA,
                "B" to question.optionB,
                "C" to question.optionC,
                "D" to question.optionD
            )

            options.forEach { (letter, text) ->
                val isSelected = selected == letter
                Button(
                    onClick = { onAnswerSelected(letter) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) Color(0xFF9DE0AD) else MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "$letter. $text",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

        // Botón siguiente
        Button(
            onClick = onNext,
            enabled = selected != null,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Siguiente",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

 */

@Composable
fun QuestionScreen(
    uiState: QuizUnamUiState,
    onAnswerSelected: (String) -> Unit,
    onNext: () -> Unit
) {
    val currentIndex = uiState.currentQuestionIndex
    val totalQuestions = uiState.userQuestions.size

    if (currentIndex >= totalQuestions) return

    val userQuestion = uiState.userQuestions[currentIndex]
    val question = userQuestion.question
    val selected = userQuestion.selectedAnswer

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Pregunta ${currentIndex + 1} de $totalQuestions",
                style = MaterialTheme.typography.labelLarge,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (question.codeSubject == "MAT") {
                MathQuestionCard(
                    question = question,
                    selected = selected,
                    onAnswerSelected = onAnswerSelected
                )
            } else {
                QuestionCard(
                    question = question,
                    selected = selected,
                    onAnswerSelected = onAnswerSelected
                )
            }
        }

        // Botón Siguiente
        Button(
            onClick = onNext,
            enabled = selected != null,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Siguiente",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}



@Composable
fun QuestionCard(
    question: Question,
    selected: String?,
    onAnswerSelected: (String) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Descripción
        Text(
            text = question.description,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Imagen si existe
        if (question.image?.isNotEmpty() == true) {
            Image(
                painter = painterResource(id = R.drawable.img), // Puedes adaptar esto
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Opciones
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            val options = listOf(
                "A" to question.optionA,
                "B" to question.optionB,
                "C" to question.optionC,
                "D" to question.optionD
            )

            options.forEach { (letter, text) ->
                val isSelected = selected == letter
                Button(
                    onClick = { onAnswerSelected(letter) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) Color(0xFF9DE0AD) else MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "$letter. $text",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
fun MathQuestionCard(
    question: Question,
    selected: String?,
    onAnswerSelected: (String) -> Unit
) {
    val latexHtml = remember(question.description) {
        getLatexHtml(question.description)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    loadDataWithBaseURL(null, latexHtml, "text/html", "utf-8", null)
                }
            },
            update = {
                it.loadDataWithBaseURL(null, latexHtml, "text/html", "utf-8", null)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Opciones con selección
        val options = listOf(
            "A" to question.optionA,
            "B" to question.optionB,
            "C" to question.optionC,
            "D" to question.optionD
        )

        options.forEach { (letter, text) ->
            val isSelected = selected == letter
            Button(
                onClick = { onAnswerSelected(letter) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color(0xFF9DE0AD) else MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("$letter. $text")
            }
        }
    }
}


fun getLatexHtml(description: String): String {
    return """
        <html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
            <script type="text/javascript" id="MathJax-script" async
                src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js">
            </script>
            <style>
                body {
                    font-size: 18px;
                    padding: 16px;
                    margin: 0;
                }
            </style>
        </head>
        <body>
            <p>\($description\)</p>
        </body>
        </html>
    """.trimIndent()
}




