package com.zezar.quizunam.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezar.quizunam.data.PreferencesManager
import com.zezar.quizunam.model.Field
import com.zezar.quizunam.model.Question
import com.zezar.quizunam.model.QuizUnamUiState
import com.zezar.quizunam.model.Subject
import com.zezar.quizunam.model.Topic
import com.zezar.quizunam.model.UserQuestion
import com.zezar.quizunam.repository.QuizUnamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QuizUnamViewModel: ViewModel() {

    private val repository = QuizUnamRepository

    private val _uiState = MutableStateFlow(QuizUnamUiState())
    val uiState: StateFlow<QuizUnamUiState> = _uiState.asStateFlow()

    fun setField(field: Field) {
        _uiState.update { it.copy(fieldSelected = field) }
    }

    fun setSubject(subject: Subject) {
        _uiState.update{ it.copy(subjetcSelected = subject) }
    }

    fun loadFields() {
        _uiState.update { it.copy(fields = repository.getFields()) }
    }


    fun loadSubjects() {
        val subjects = repository.getSubjects()
        _uiState.update { it.copy(subjects = subjects) }
    }

    fun loadSubjectsByField(field: Field) {

        setField(field)

        val subjects = repository.getSubjects().filter { it.fieldCodes.contains(field.code) }
        _uiState.update { it.copy(subjects = subjects) }
    }

    fun loadTopicsByFieldAndSubject(codeSubject: String) {
        val fieldCode = uiState.value.fieldSelected?.code ?: return

        val topics = repository.getTopics().filter { topic ->
            topic.codeSubject == codeSubject && topic.fieldCodes.contains(fieldCode)
        }
        _uiState.update { it.copy(topics = topics) }
    }

    fun loadTopics(subject: Subject) {
        val topics = repository.getTopics().filter { it.codeSubject == subject.code }
        _uiState.update { it.copy(topics = topics) }
    }

    fun loadQuestionsByTopic(topic: Topic) {

        val all = repository.getQuestions().filter { it.codeTopic == topic.code }

        //val selected = all.shuffled().take(3)
        val selected = all.shuffled().take(3).map { shuffleQuestionOptions(it) }


        val userQuestions = selected.map { question ->
            UserQuestion(question = question)
        }

        _uiState.update {
            it.copy(
                //currentTopic = topic,
                userQuestions = userQuestions,
                currentQuestionIndex = 0
            )
        }
    }

    fun answerCurrentQuestion(answer: String) {
        val currentIndex = _uiState.value.currentQuestionIndex
        val updatedList = _uiState.value.userQuestions.toMutableList()

        val userQuestion = updatedList[currentIndex]
        updatedList[currentIndex] = userQuestion.copy(
            selectedAnswer = answer,
            isCorrect = answer == userQuestion.question.answer
        )

        _uiState.update {
            it.copy(userQuestions = updatedList)
        }
    }

    fun nextQuestion() {
        val nextIndex = _uiState.value.currentQuestionIndex + 1
        if (nextIndex < _uiState.value.userQuestions.size) {
            _uiState.update { it.copy(currentQuestionIndex = nextIndex) }
        }
    }

    fun resetQuiz() {

        _uiState.update {
            it.copy(
                currentQuestionIndex = 0,
                userQuestions = emptyList()
            )
        }
    }

    private fun shuffleQuestionOptions(question: Question): Question {
        val originalOptions = mapOf(
            "A" to question.optionA,
            "B" to question.optionB,
            "C" to question.optionC,
            "D" to question.optionD
        )

        val correctAnswerText = originalOptions[question.answer] ?: return question

        val shuffledOptions = originalOptions.values.shuffled()

        val newAnswerIndex = shuffledOptions.indexOf(correctAnswerText)
        val newAnswerLetter = listOf("A", "B", "C", "D")[newAnswerIndex]

        return question.copy(
            optionA = shuffledOptions[0],
            optionB = shuffledOptions[1],
            optionC = shuffledOptions[2],
            optionD = shuffledOptions[3],
            answer = newAnswerLetter
        )
    }


    fun saveProgress(context: Context) {

        val userQuestions = _uiState.value.userQuestions

        viewModelScope.launch {
            userQuestions.forEach { userQuestion ->

                if (userQuestion.isCorrect) {
                    val code = userQuestion.question.codeTopic
                    val stored = PreferencesManager.getProgress(context, code)

                    val topic = repository.getTopicByCode(code)
                    val goal = topic?.goalPoints?.takeIf { it > 0 } ?: 100

                    val newValue = (stored + 1).coerceAtMost(goal)
                    PreferencesManager.saveProgress(context, code, newValue)
                }
            }
        }
    }

    fun loadQuestionsForQuickExam() {

        val field = _uiState.value.fieldSelected ?: return
        val allQuestions = repository.getQuestions().shuffled()

        val subjectCodes = repository.getSubjects()
            .filter { it.fieldCodes.contains(field.code) }
            .map { it.code }
            .shuffled()

        val selectedQuestions = subjectCodes.flatMap { subjectCode ->
            allQuestions.filter { it.codeSubject == subjectCode }.take(2)
        }

        val userQuestions = selectedQuestions.map { UserQuestion(it) }

        _uiState.update {
            it.copy(
                userQuestions = userQuestions,
                currentQuestionIndex = 0
            )
        }
    }
}