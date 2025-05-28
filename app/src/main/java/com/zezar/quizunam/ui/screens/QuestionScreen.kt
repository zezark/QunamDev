package com.zezar.quizunam.ui.screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
                MathQuestionCardV2(question = question, selected = selected, onAnswerSelected = onAnswerSelected )
                //MathQuestionCard( question = question, selected = selected, onAnswerSelected = onAnswerSelected)
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
        Text(text = question.codeSubject)
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

@Composable
fun LatexView(
    latex: String,
    modifier: Modifier = Modifier,
    fontSizeSp: Int = 18,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    color: String = "black"
) {
    val context = LocalContext.current
    var isLoaded by remember { mutableStateOf(false) }

    // color: ${if (isDarkTheme) "white" else "black"};

    val html = remember(latex, fontSizeSp, isDarkTheme, color) {
        """
        <html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
            <script type="text/javascript" id="MathJax-script" async
                src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js">
            </script>
            <script type="text/javascript">
                window.addEventListener("load", function() {
                    MathJax.typesetPromise().then(() => {
                        if (window.Android && Android.onMathJaxReady) {
                            Android.onMathJaxReady();
                        }
                    });
                });
            </script>
            <style>
                body {
                    font-size: ${fontSizeSp}px;
                    padding: 4px;
                    margin: 0;
                    color: $color;
                    background-color: transparent;
                }
            </style>
        </head>
        <body>
            <p>\($latex\)</p>
        </body>
        </html>
        """.trimIndent()
    }

    Box(modifier = modifier) {
        if (!isLoaded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp), // Altura temporal para spinner
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (isLoaded) Modifier else Modifier
                        .height(0.dp)
                        .alpha(0f)
                ),
            factory = {
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    setBackgroundColor(android.graphics.Color.TRANSPARENT)

                    // Comunicación JS -> Kotlin
                    addJavascriptInterface(object {
                        @android.webkit.JavascriptInterface
                        fun onMathJaxReady() {
                            (context as? android.app.Activity)?.runOnUiThread {
                                isLoaded = true
                            }
                        }
                    }, "Android")

                    webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView?, url: String?) {
                            // JS se encarga de notificar cuando está listo
                        }
                    }

                    loadDataWithBaseURL(null, html, "text/html", "utf-8", null)
                }
            },
            update = {
                isLoaded = false // Reiniciar estado si latex cambia
                it.loadDataWithBaseURL(null, html, "text/html", "utf-8", null)
            }
        )
    }
}


@Composable
fun MathQuestionCardV2(
    question: Question,
    selected: String?,
    onAnswerSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Pregunta
        LatexView(
            latex = question.description,
            modifier = Modifier.fillMaxWidth(),
            color = "white"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Opciones
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
                Column {
                    Text("$letter.")
                    LatexView(
                        latex = text,
                        fontSizeSp = 16,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}






