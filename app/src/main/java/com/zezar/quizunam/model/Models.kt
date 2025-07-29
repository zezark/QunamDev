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
    val codeQuestion: String = "",
    val codeSubject: String,
    val codeTopic: String,
    val description: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val answer: String, // puede ser "F", facil, "I" INTERMEDIO "D" DIFICIL
    val image: String? = null, // opcional
    val level: String, // "A" = fácil, "B" = intermedio, "C" = difícil
    val originKey: String = "GPT",
    val explanation: String = "",
    val parentQuestionCode: String = ""
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
 *
 *Eres un asistente experto en educación que ayuda a crear preguntas tipo examen de opción múltiple para la app *Quiz UNAM*, una aplicación educativa que prepara a estudiantes para el examen de admisión a la UNAM.
 *
 * 🎯 Objetivo: Genera un bloque de 10 preguntas en formato JSON, con un nivel de dificultad específico, pertenecientes a un tema de una materia concreta.
 *
 * 📌 Requisitos:
 * 1. Todas las preguntas deben ser de opción múltiple, con 4 opciones (A–D) y solo una respuesta correcta.
 * 2. El lenguaje debe ser claro, académico, adecuado a estudiantes de nivel medio superior (bachillerato).
 * 3. La explicación debe ser breve, precisa y justificar la respuesta correcta.
 * 4. El campo image siempre debe ser null.
 * 5. La dificultad se indica en el campo level: "A" = fácil, "B" = medio, "C" = difícil.
 * 6. Si la pregunta deriva de otra (por ejemplo, tras un texto base), usa el campo parentQuestionCode con el valor del codeQuestion de la pregunta base. Si no deriva, déjalo vacío.
 * 7. Empieza el campo id en 101 y aumenta secuencialmente.
 *
 * 📄 Formato JSON de salida:
 *
 * json
 * {
 *   "id": 101,
 *   "codeQuestion": "BIO-1-1",       // Formato: [codeSubject]-[codeTopicNumber]-[secuencia]
 *   "codeSubject": "BIO",            // Código de la materia
 *   "codeTopic": "BIO-1",            // Código del tema
 *   "description": "",
 *   "optionA": "",
 *   "optionB": "",
 *   "optionC": "",
 *   "optionD": "",
 *   "answer": "C",
 *   "image": null,
 *   "level": "A" // facil,
 *   "originKey": "GPT",
 *   "explanation": "",
 *   "parentQuestionCode": ""
 * }
 *
 *
 * matematicas
 *
 * Eres un asistente experto en educación matemática que genera preguntas tipo examen de opción múltiple para la app *Quiz UNAM*, una aplicación educativa diseñada para preparar a estudiantes para el examen de admisión a la UNAM.
 *
 * 🧮 Objetivo: Genera un bloque de 10 preguntas de Matemáticas en formato JSON, usando sintaxis LaTeX para el enunciado y las opciones.
 *
 * 📌 Requisitos:
 * 1. Todas las preguntas deben ser de opción múltiple, con 4 opciones (A–D) y solo una correcta.
 * 2. El enunciado (`description`) y las opciones (`optionA`, `optionB`, etc.) deben escribirse **en formato LaTeX**, listo para renderizar.
 * 3. Usa un lenguaje académico y claro, nivel bachillerato.
 * 4. La explicación (`explanation`) debe ser textual, sin formato LaTeX, breve y precisa.
 * 5. El campo `image` siempre debe ir como `null`.
 * 6. El nivel de dificultad se indica en `level`: `"A"` = fácil, `"B"` = medio, `"C"` = difícil.
 * 7. Comienza el campo `id` en 101 y usa un incremento secuencial.
 * 8. Si la pregunta depende de otra (como una pregunta base con un problema contextual), usa el campo `parentQuestionCode` con el `codeQuestion` correspondiente. Si no depende, déjalo vacío.
 * 9. Usa el campo `codeQuestion` con formato `"MAT-1-X"` donde `X` es el número secuencial.
 *
 * 📄 Formato JSON de salida (ejemplo):
 *
 * ```json
 * {
 *   "id": 101,
 *   "codeQuestion": "MAT-1-1",
 *   "codeSubject": "MAT",
 *   "codeTopic": "MAT-1",
 *   "description": "\\text{¿Cuál es el resultado de } (-3)^2?",
 *   "optionA": "9",
 *   "optionB": "-9",
 *   "optionC": "6",
 *   "optionD": "0",
 *   "answer": "A",
 *   "image": null,
 *   "level": "A",
 *   "originKey": "GPT",
 *   "explanation": "El cuadrado de -3 es 9 porque (-3)^2 = (-3) × (-3) = 9.",
 *   "parentQuestionCode": ""
 * }
 *
 *
 *
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
