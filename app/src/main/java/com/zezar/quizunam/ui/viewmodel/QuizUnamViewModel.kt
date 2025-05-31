package com.zezar.quizunam.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezar.quizunam.data.PreferencesManager
import com.zezar.quizunam.model.Field
import com.zezar.quizunam.model.Question
import com.zezar.quizunam.model.QuizType
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

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
        val correctCount = userQuestions.count { it.isCorrect }

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

        // Revisar si el tipo de quiz, si fue mock o quick, guardar puntaje
        // usando el uistate.

        val quizType = _uiState.value.quizTypeSelected

        viewModelScope.launch {
            if (quizType == QuizType.QUICK_QUIZ) {
                val key = generateQuizKey("QQ")
                PreferencesManager.saveQuizScore(context, key, correctCount)
            }

            if (quizType == QuizType.MOCK_EXAM) {
                val key = generateQuizKey("ME")
                PreferencesManager.saveQuizScore(context, key, correctCount)
            }
        }
    }

    private fun loadQuestionsForQuickExam() {

        val field = _uiState.value.fieldSelected ?: return
        val questionList = emptyList<Question>().toMutableList()

        questionList += repository.getMathQuestions().shuffled().take(1)
        questionList += repository.getBiologyQuestions().shuffled().take(1)
        questionList += repository.getMexicanHistoryQuestions().shuffled().take(1)
        questionList += repository.getWorldHistoryQuestions().shuffled().take(1)
        questionList += repository.getChemistryQuestions().shuffled().take(1)
        questionList += repository.getPhysicsQuestions().shuffled().take(1)
        questionList += repository.getSpanishQuestions().shuffled().take(1)
        questionList += repository.getGeographyQuestions().shuffled().take(1)
        questionList += repository.getLiteratureQuestions().shuffled().take(1)

        if(field.code == "A4") {
            questionList += repository.getPhilosophyQuestions().shuffled().take(1)
        }

        val userQuestions = questionList.map { UserQuestion(it) }

        _uiState.update {
            it.copy(
                userQuestions = userQuestions,
                currentQuestionIndex = 0
            )
        }
    }

    fun setTopic(topic: Topic) {
        _uiState.update { it.copy(topicSelected = topic) }
    }

    fun loadQuestions(quizType: QuizType) {

        _uiState.update { it.copy(quizTypeSelected = quizType ) }

        when(quizType) {
            QuizType.TOPIC_QUIZ -> { loadQuestionsByTopicV2() }
            QuizType.QUICK_QUIZ -> { loadQuestionsForQuickExam() }
            QuizType.SUBJECT_QUIZ -> { loadQuestionsBySubject() }
            QuizType.MOCK_EXAM -> { loadQuestionsForMockExam() }
        }
    }

    private fun loadQuestionsForMockExam() {

        val field = _uiState.value.fieldSelected ?: return

        val questionList = emptyList<Question>().toMutableList()

        when(field.code) {
            "A1" -> {
                questionList += repository.getMathQuestions().shuffled().take(1)
                questionList += repository.getBiologyQuestions().shuffled().take(1)
                questionList += repository.getMexicanHistoryQuestions().shuffled().take(1)
                questionList += repository.getWorldHistoryQuestions().shuffled().take(1)
                questionList += repository.getChemistryQuestions().shuffled().take(1)
                questionList += repository.getPhysicsQuestions().shuffled().take(1)
                questionList += repository.getSpanishQuestions().shuffled().take(1)
                questionList += repository.getGeographyQuestions().shuffled().take(1)
                questionList += repository.getLiteratureQuestions().shuffled().take(1)
            }
            "A2" -> {
                questionList += repository.getMathQuestions().shuffled().take(1)
                questionList += repository.getBiologyQuestions().shuffled().take(1)
                questionList += repository.getMexicanHistoryQuestions().shuffled().take(1)
                questionList += repository.getWorldHistoryQuestions().shuffled().take(1)
                questionList += repository.getChemistryQuestions().shuffled().take(1)
                questionList += repository.getPhysicsQuestions().shuffled().take(1)
                questionList += repository.getSpanishQuestions().shuffled().take(1)
                questionList += repository.getGeographyQuestions().shuffled().take(1)
                questionList += repository.getLiteratureQuestions().shuffled().take(1)
            }
            "A3" -> {
                questionList += repository.getMathQuestions().shuffled().take(1)
                questionList += repository.getBiologyQuestions().shuffled().take(1)
                questionList += repository.getMexicanHistoryQuestions().shuffled().take(1)
                questionList += repository.getWorldHistoryQuestions().shuffled().take(1)
                questionList += repository.getChemistryQuestions().shuffled().take(1)
                questionList += repository.getPhysicsQuestions().shuffled().take(1)
                questionList += repository.getSpanishQuestions().shuffled().take(1)
                questionList += repository.getGeographyQuestions().shuffled().take(1)
                questionList += repository.getLiteratureQuestions().shuffled().take(1)
            }
            "A4" -> {
                questionList += repository.getMathQuestions().shuffled().take(1)
                questionList += repository.getBiologyQuestions().shuffled().take(1)
                questionList += repository.getMexicanHistoryQuestions().shuffled().take(1)
                questionList += repository.getWorldHistoryQuestions().shuffled().take(1)
                questionList += repository.getChemistryQuestions().shuffled().take(1)
                questionList += repository.getPhysicsQuestions().shuffled().take(1)
                questionList += repository.getSpanishQuestions().shuffled().take(1)
                questionList += repository.getGeographyQuestions().shuffled().take(1)
                questionList += repository.getLiteratureQuestions().shuffled().take(1)
                questionList += repository.getPhilosophyQuestions().shuffled().take(1)
            }
        }

        val codeSubjects = questionList.map { it.codeSubject }.distinct().shuffled()

        val orderedQuestions = codeSubjects.flatMap { subjectCode ->
            questionList.filter { it.codeSubject == subjectCode }
        }

        val userQuestions = orderedQuestions.map { question ->
            UserQuestion(question = question)
        }

        _uiState.update {
            it.copy(
                userQuestions = userQuestions,
                currentQuestionIndex = 0
            )
        }
    }

    private fun loadQuestionsBySubject() {

        val subject = _uiState.value.subjetcSelected ?: return
        val questions = repository.getQuestions().shuffled().filter { it.codeSubject == subject.code }.take(10)

        val userQuestions = questions.map { question ->
            UserQuestion(question = question)
        }

        _uiState.update {
            it.copy(
                userQuestions = userQuestions,
                currentQuestionIndex = 0
            )
        }

    }

    private fun loadQuestionsByTopicV2() {

        val topic = _uiState.value.topicSelected ?: return

        val all = repository.getQuestions().filter { it.codeTopic == topic.code }

        val selected = all.shuffled().take(3).map { shuffleQuestionOptions(it) }

        val userQuestions = selected.map { question ->
            UserQuestion(question = question)
        }

        _uiState.update {
            it.copy(
                userQuestions = userQuestions,
                currentQuestionIndex = 0
            )
        }
    }

    private fun generateQuizKey(prefix: String): String {
        val formatter = DateTimeFormatter.ofPattern("ddMMMyy-HHmmss", Locale.ENGLISH)
        val timestamp = LocalDateTime.now().format(formatter).uppercase()
        return "$prefix-$timestamp" // Ej: "QQ-28MAY25-142532"
    }


    fun loadQuizHistory(context: Context) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(quizHistoryMap = PreferencesManager.getAllQuizScores(context = context))
            }
        }
    }
}