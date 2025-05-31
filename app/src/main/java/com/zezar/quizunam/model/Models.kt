package com.zezar.quizunam.model

data class Field(
    val id: Int,
    val code: String,
    val name: String,
    val description: String,
    val image: String,
)

data class Subject(
    val id: Int,
    val code: String,
    val name: String,
    val progress: Float, // de 0.0f a 1.0f para la barra de progreso
    val image: String, // nombre del recurso de imagen o URL si lo decides
    val goalPoints: Int = 1000,
    val fieldCodes: String
)

data class Topic(
    val idTopic: Int,
    val code: String,
    val codeSubject: String,
    val title: String,
    val image: String,
    val progress: Float,
    val goalPoints: Int = 200,
    val fieldCodes: String = "A1 A2 A3 A4"
)

data class Question(
    val id: Int,
    val codeSubject: String,
    val codeTopic: String,
    val description: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val answer: String, // puede ser "A", "B", "C" o "D"
    val image: String? = null, // opcional
    val level: String, // "A" = fácil, "B" = intermedio, "C" = difícil
    val originKey: String = "GPT"
)

/**
 * // Fuentes originales
 * UNAM-GUIDE      // Guía oficial de la UNAM
 * CONAMAT         // Guía de estudio CONAMAT
 * YOUTUBE         // Video educativo de YouTube
 * WEB             // Página de internet (blog, artículo, etc.)
 * BOOK            // Libro físico o digital
 * MANUAL          // Pregunta redactada manualmente
 *
 * // Generadas por IA
 * GPT-GEN         // Pregunta generada completamente por GPT u otra IA
 *
 * // Combinaciones de fuente + IA
 * Y-GPT           // Pregunta de YouTube usada como prompt en GPT
 * C-GPT           // Pregunta de CONAMAT transformada por GPT
 * U-GPT           // Pregunta de guía oficial UNAM transformada por GPT
 * W-GPT           // Página web convertida a pregunta por GPT
 * B-GPT           // Pregunta de libro generada por GPT
 * GPT-MOD         // Pregunta generada por GPT a partir de múltiples fuentes
 * GPT-AUG         // Pregunta original aumentada o corregida con GPT
 *
 * // Otras posibles combinaciones si usas otros modelos de IA
 * Y-DS            // Pregunta de YouTube generada con DeepSeek
 * W-DS            // Página web convertida a pregunta por DeepSeek
 */

data class UserQuestion(
    val question: Question,
    var selectedAnswer: String? = null,
    val isCorrect: Boolean = false
)

enum class QuizType {
    TOPIC_QUIZ,
    SUBJECT_QUIZ,
    QUICK_QUIZ,
    MOCK_EXAM
}
