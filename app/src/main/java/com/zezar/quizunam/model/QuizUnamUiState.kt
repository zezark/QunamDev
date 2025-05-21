package com.zezar.quizunam.model

data class QuizUnamUiState(
    val fieldSelected: Field? = null,
    val subjetcSelected: Subject? = null,
    val fields: List<Field> = emptyList(),
    val subjects: List<Subject> = emptyList(),
    val topics: List<Topic> = emptyList(),
    val currentTopic: Topic? = null,
    val userQuestions: List<UserQuestion> = emptyList(),
    val currentQuestionIndex: Int = 0
)
