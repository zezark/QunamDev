package com.zezar.quizunam

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zezar.quizunam.ui.screens.FieldScreen
import com.zezar.quizunam.ui.screens.QuestionScreen
import com.zezar.quizunam.ui.screens.SubjectScreen
import com.zezar.quizunam.ui.screens.SummaryScreen
import com.zezar.quizunam.ui.screens.SyllabusScreen
import com.zezar.quizunam.ui.viewmodel.QuizUnamViewModel



enum class QuizUnamScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Subjects(title = R.string.ui_subjects),
    Syllabus(title = R.string.ui_syllabus),
    Question(title = R.string.ui_questions),
    Summary(title = R.string.ui_summary)
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizUnamAppBar(
    currentScreen: QuizUnamScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.app_name)
                    )
                }
            }
        }
    )
}

@Composable
fun QuizUnamApp (
    viewModel: QuizUnamViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = QuizUnamScreen.valueOf(
        backStackEntry?.destination?.route ?: QuizUnamScreen.Start.name
    )

    Scaffold(
        topBar = {
            QuizUnamAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        viewModel.loadFields()

        val context = LocalContext.current
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = QuizUnamScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                //.verticalScroll(rememberScrollState())
        ) {
            composable(route = QuizUnamScreen.Start.name) {

                FieldScreen(uiState) { field ->
                    Toast.makeText(context, "Seleccionaste: ${field.name}", Toast.LENGTH_SHORT).show()
                    viewModel.loadSubjectsByField(field)
                    navController.navigate(QuizUnamScreen.Subjects.name)
                }
            }

            composable(route = QuizUnamScreen.Subjects.name) {
                SubjectScreen(uiState) { subject ->
                    Toast.makeText(context, "Seleccionaste: ${subject.name}", Toast.LENGTH_SHORT).show()
                    viewModel.loadTopicsByFieldAndSubject(subject.code)
                    navController.navigate(QuizUnamScreen.Syllabus.name)
                }
            }

            composable(route = QuizUnamScreen.Syllabus.name) {
                SyllabusScreen(uiState) { topic ->
                    Toast.makeText(context, "Seleccionaste tema: ${topic.title}", Toast.LENGTH_SHORT).show()
                    viewModel.loadQuestionsByTopic(topic)
                    navController.navigate(QuizUnamScreen.Question.name)
                }
            }

            composable(route = QuizUnamScreen.Question.name) {
                QuestionScreen(
                    uiState = uiState,
                    onAnswerSelected = { answer ->
                        viewModel.answerCurrentQuestion(answer)
                    },
                    onNext = {
                        if (uiState.currentQuestionIndex < uiState.userQuestions.lastIndex) {
                            viewModel.nextQuestion()
                        } else {
                            // Quiz terminado → navegar al resumen
                            viewModel.saveProgress(context)
                            navController.navigate(QuizUnamScreen.Summary.name)

                        }
                    }
                )
            }

            composable(route = QuizUnamScreen.Summary.name) {
                SummaryScreen(
                    userQuestions = uiState.userQuestions,
                    onRestart = {
                        viewModel.resetQuiz()
                        navController.navigate(QuizUnamScreen.Subjects.name) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}