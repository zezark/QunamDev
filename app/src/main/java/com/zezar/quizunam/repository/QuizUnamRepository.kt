package com.zezar.quizunam.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zezar.quizunam.model.Field
import com.zezar.quizunam.model.Question
import com.zezar.quizunam.model.Subject
import com.zezar.quizunam.model.Topic
import java.io.InputStreamReader

object QuizUnamRepository {

    fun getQuestionsFromJson(context: Context, subjectKey: String): List<Question> {
        val fileName = "${subjectKey.lowercase()}.json"
        return try {
            val inputStream = context.assets.open(fileName)
            val reader = InputStreamReader(inputStream)
            val questionListType = object : TypeToken<List<Question>>() {}.type
            Gson().fromJson(reader, questionListType)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun getTopicByCode(code: String): Topic? {
        return getTopics().firstOrNull { it.code == code }
    }

    fun getSubjects(): List<Subject> {
        return listOf(
            Subject(1, "MAT", "Matemáticas", 0.6f, "ic_math", fieldCodes = "A1 A2 A3 A4"),
            Subject(2, "BIO", "Biología", 0.3f, "ic_biology", fieldCodes = "A1 A2 A3 A4"),
            Subject(3, "HUN", "Historia de México", 0.8f, "ic_history", fieldCodes = "A1 A2 A3 A4"),
            Subject(4, "HMX", "Historia Universal", 0.8f, "ic_history", fieldCodes = "A1 A2 A3 A4"),
            Subject(5, "QUI", "Química", 0.2f, "ic_chemistry", fieldCodes = "A1 A2 A3 A4"),
            Subject(6, "FIS", "Física", 0.4f, "ic_physics", fieldCodes = "A1 A2 A3 A4"),
            Subject(7, "ESP", "Español", 0.9f, "ic_spanish", fieldCodes = "A1 A2 A3 A4"),
            Subject(8, "FIL", "Filosofía", 0.1f, "ic_philosophy", fieldCodes = "A4"),
            Subject(9, "GEO", "Geografía", 0.5f, "ic_geography", fieldCodes = "A1 A2 A3 A4"),
            Subject(10, "LIT", "Literatura", 0.7f, "ic_literature", fieldCodes = "A1 A2 A3 A4")
        )
    }

    fun getFields() : List<Field> {
        return listOf(
            Field(1, "A1", "Área 1", "Área de las Ciencias Físico-Matemáticas y de las Ingenierías", "img_area_1"),
            Field(2, "A2", "Área 2", "Área de las Ciencias Biológicas, Químicas y de la Salud", "img_area_2"),
            Field(3, "A3", "Área 3", "Área de las Ciencias Sociales", "img_area_3"),
            Field(4, "A4", "Área 4", "Área de las Humanidades y de las Artes", "img_area_4")
        )
    }

    fun getTopics(): List<Topic> {

        return listOf(

            Topic(1, "ESP-1", "ESP", "Lengua y comunicación", "img", 0.2f),
            Topic(2, "ESP-2", "ESP", "Formas discursivas del texto", "img", 0.2f),
            Topic(3, "ESP-3", "ESP", "Comprensión de lectura", "img", 0.2f),
            Topic(4, "ESP-4", "ESP", "Gramática", "img", 0.2f),
            Topic(5, "ESP-5", "ESP", "Redacción", "img", 0.2f),
            Topic(6, "ESP-6", "ESP", "Vocabulario", "img", 0.2f),
            Topic(7, "ESP-7", "ESP", "Ortografía", "img", 0.2f),
            // Matematicas
            Topic(1, "MAT-1", "MAT", "Operaciones con números reales, complejos y expresiones algebraicas", "img", 0.2f),
            Topic(2, "MAT-2", "MAT", "Productos notables y factorización", "img", 0.2f),
            Topic(3, "MAT-3", "MAT", "Ecuaciones", "img", 0.2f),
            Topic(4, "MAT-4", "MAT", "Desigualdades", "img", 0.2f),
            Topic(5, "MAT-5", "MAT", "Sistemas de ecuaciones", "img", 0.2f),
            Topic(6, "MAT-6", "MAT", "Funciones algebraicas", "img", 0.2f),
            Topic(7, "MAT-7", "MAT", "Trigonometría", "img", 0.2f),
            Topic(8, "MAT-8", "MAT", "Funciones trigonométricas", "img", 0.2f),
            Topic(9, "MAT-9", "MAT", "Funciones exponenciales y logarítmicas", "img", 0.2f),
            Topic(10, "MAT-10", "MAT", "Recta", "img", 0.2f),
            Topic(11, "MAT-11", "MAT", "Circunferencia", "img", 0.2f),
            Topic(12, "MAT-12", "MAT", "Elipse", "img", 0.2f),
            Topic(13, "MAT-13", "MAT", "Hipérbola", "img", 0.2f),
            Topic(14, "MAT-14", "MAT", "Ecuación general de segundo grado", "img", 0.2f),
            Topic(13, "MAT-15", "MAT", "Limites", "img", 0.2f, fieldCodes = "A1"),
            Topic(13, "MAT-16", "MAT", "La derivada", "img", 0.2f, fieldCodes = "A1"),
            Topic(13, "MAT-17", "MAT", "La integral", "img", 0.2f, fieldCodes = "A1"),
            // FISICA
            Topic(1, "FIS-1", "FIS", "Cinemática", "img", 0.2f),
            Topic(2, "FIS-2", "FIS", "Fuerzas, leyes de Newton y Ley de la Gravitación Universal", "img", 0.2f),
            Topic(3, "FIS-3", "FIS", "Trabajo y leyes de la conservación", "img", 0.2f),
            Topic(4, "FIS-4", "FIS", "Termodinámica", "img", 0.2f),
            Topic(5, "FIS-5", "FIS", "Ondas", "img", 0.2f),
            Topic(6, "FIS-6", "FIS", "Electromagnetismo", "img", 0.2f),
            Topic(7, "FIS-7", "FIS", "Fluidos", "img", 0.2f),
            Topic(8, "FIS-8", "FIS", "Óptica", "img", 0.2f),
            Topic(9, "FIS-9", "FIS", "Física contemporánea", "img", 0.2f),
            //QUIMICA
            Topic(1, "QUI-1", "QUI", "Temas básicos", "img", 0.2f),
            Topic(2, "QUI-2", "QUI", "Agua", "img", 0.2f),
            Topic(3, "QUI-3", "QUI", "Aire", "img", 0.2f),
            Topic(4, "QUI-4", "QUI", "Alimentos", "img", 0.2f),
            Topic(5, "QUI-5", "QUI", "La energía y las reacciones químicas", "img", 0.2f),
            Topic(6, "QUI-6", "QUI", "Química del carbono", "img", 0.2f, fieldCodes = "A2"),
            // BIOLOGIA
            Topic(1, "BIO-1", "BIO", "Célula", "img", 0.2f),
            Topic(2, "BIO-2", "BIO", "Metabolismo celular", "img", 0.2f),
            Topic(3, "BIO-3", "BIO", "Reproducción", "img", 0.2f),
            Topic(4, "BIO-4", "BIO", "Mecanismos de la herencia", "img", 0.2f),
            Topic(5, "BIO-5", "BIO", "Evolución", "img", 0.2f),
            Topic(6, "BIO-6", "BIO", "Los seres vivos y su ambiente", "img", 0.2f),

            Topic(1, "HMX-1", "HMX", "La Nueva España (siglos XVI a XIX)", "img", 0.2f),
            Topic(2, "HMX-2", "HMX", "El movimiento de Independencia de la Nueva España (1810 – 1821)", "img", 0.2f),
            Topic(3, "HMX-3", "HMX", "México independiente (1821 – 1854)", "img", 0.2f),
            Topic(4, "HMX-4", "HMX", "La Reforma liberal y la resistencia de la República (1854 – 1876)", "img", 0.2f),
            Topic(5, "HMX-5", "HMX", "El Porfiriato (1876 – 1911)", "img", 0.2f),
            Topic(6, "HMX-6", "HMX", "La Revolución Mexicana (1910 – 1920)", "img", 0.2f),
            Topic(7, "HMX-7", "HMX", "La reconstrucción nacional (1920 – 1940)", "img", 0.2f),
            Topic(8, "HMX-8", "HMX", "México contemporáneo (1940 – 2000)", "img", 0.2f),

            Topic(1, "HUN-1", "HUN", "La Historia", "img", 0.2f),
            Topic(2, "HUN-2", "HUN", "Las revoluciones burguesas", "img", 0.2f),
            Topic(3, "HUN-3", "HUN", "Pensamiento y movimientos sociales y políticos del siglo XIX", "img", 0.2f),
            Topic(4, "HUN-4", "HUN", "El imperialismo", "img", 0.2f),
            Topic(5, "HUN-5", "HUN", "La Primera Guerra Mundial", "img", 0.2f),
            Topic(6, "HUN-6", "HUN", "El mundo entre guerras", "img", 0.2f),
            Topic(7, "HUN-7", "HUN", "La Segunda Guerra Mundial", "img", 0.2f),
            Topic(8, "HUN-8", "HUN", "El conflicto entre el capitalismo y el socialismo", "img", 0.2f),
            Topic(9, "HUN-9", "HUN", "El mundo actual", "img", 0.2f),

            Topic(1, "LIT-1", "LIT", "El texto", "img", 0.2f),
            Topic(2, "LIT-2", "LIT", "Géneros y corrientes literarias", "img", 0.2f),
            Topic(3, "LIT-3", "LIT", "Redacción y técnicas de investigación documental", "img", 0.2f),

            Topic(1, "GEO-1", "GEO", "La Tierra, base del desarrollo del hombre", "img", 0.2f),
            Topic(2, "GEO-2", "GEO", "Geografía humana: el paisaje cultural (espacio geográfico)", "img", 0.2f),

            Topic(2, "FIL-1", "FIL-1", "Lógica", "img", 0.2f, fieldCodes = "A4"),
            Topic(2, "FIL-2", "FIL-1", "Ética", "img", 0.2f, fieldCodes = "A4"),
            Topic(2, "FIL-3", "FIL-1", "Disciplinas y problemas de la Filosofía", "img", 0.2f, fieldCodes = "A4"),

        )
    }

    /*

    fun getQuestions(): List<Question> {
        return listOf(

            Question(1, "MAT", "MAT-1", "\\text{¿Cuál es el resultado de } (-3)^2?", "9", "-9", "6", "0", "A", null, "A"),
            Question(2, "MAT", "MAT-1", "\\text{Simplifica: } 2x + 3x - 5", "5x - 5", "x - 5", "5x + 5", "5x", "A", null, "A"),
            Question(3, "MAT", "MAT-1", "\\text{Resuelve: } (2 + 3i) + (4 - 5i)", "6 - 2i", "2 - 2i", "6 + 8i", "8 - 2i", "A", null, "B"),
            Question(4, "MAT", "MAT-1", "\\text{Multiplica: } (2x)(-3x^2)", "-6x^3", "-6x^2", "5x^3", "-5x^2", "A", null, "A"),
            Question(5, "MAT", "MAT-1", "\\text{¿Cuál es el resultado de } \\sqrt{-49}?", "7", "-7", "7i", "No tiene solución", "C", null, "B"),
            Question(6, "MAT", "MAT-1", "\\text{Factoriza: } x^2 - 9", "(x + 3)(x - 3)", "(x - 9)(x + 1)", "(x - 3)^2", "No se puede", "A", null, "A"),
            Question(7, "MAT", "MAT-1", "\\text{Resuelve: } 5x - 2 = 3x + 6", "x = 4", "x = -4", "x = 1", "x = 2", "A", null, "A"),
            Question(8, "MAT", "MAT-1", "\\text{Multiplica: } (1 + 2i)(1 - 2i)", "1 - 4i^2", "1 + 4", "5", "3", "C", null, "B"),
            Question(9, "MAT", "MAT-1", "\\text{¿Cuál es el inverso aditivo de } -5?", "5", "-5", "0", "1", "A", null, "A"),
            Question(10, "MAT", "MAT-1", "\\text{Simplifica: } (x^2)^3", "x^6", "x^5", "x^3", "x^8", "A", null, "A"),

            Question(1001, "MAT", "MAT-2", "\\text{¿Cuál es el resultado de } (a+b)^2?", "a^2 + 2ab + b^2", "a^2 + b^2", "a^2 - 2ab + b^2", "2a + 2b", "A", null, "B"),
            Question(1002, "MAT", "MAT-2", "\\text{Factoriza } x^2 - 9", "(x-3)(x+3)", "(x-9)(x+1)", "(x-3)^2", "(x+9)(x-1)", "A", null, "B"),
            Question(1003, "MAT", "MAT-2", "\\text{¿Cuál es el desarrollo de } (2x - 5)^2?", "4x^2 - 20x + 25", "4x^2 + 20x + 25", "4x^2 - 10x - 25", "2x^2 - 5", "A", null, "C"),
            Question(1004, "MAT", "MAT-2", "\\text{Factoriza } x^2 + 6x + 9", "(x+3)^2", "(x+9)(x-3)", "(x-3)^2", "(x+6)(x+3)", "A", null, "B"),
            Question(1005, "MAT", "MAT-2", "\\text{¿Cuál es el producto notable de } (a-b)(a+b)?", "a^2 - b^2", "a^2 + b^2", "a^2 - 2ab + b^2", "a^2 + 2ab + b^2", "A", null, "B"),

            Question(2001, "MAT", "MAT-3", "\\text{¿Cuál es la solución de la ecuación } 2x + 5 = 13?", "4", "3", "5", "6", "A", null, "B"),
            Question(2002, "MAT", "MAT-3", "\\text{Resuelve } x^2 - 9 = 0", "x = \\pm 3", "x = 3", "x = -3", "No tiene solución", "A", null, "B"),
            Question(2003, "MAT", "MAT-3", "\\text{Encuentra } x \\text{ en } 3(x - 2) = 9", "x = 5", "x = 3", "x = 6", "x = 4", "A", null, "C"),
            Question(2004, "MAT", "MAT-3", "\\text{¿Cuál es el valor de } x \\text{ en } \\frac{x}{4} + 3 = 7?", "16", "12", "10", "8", "A", null, "B"),
            Question(2005, "MAT", "MAT-3", "\\text{Resuelve la ecuación cuadrática } x^2 + 4x + 4 = 0", "x = -2", "x = 2", "x = 0", "x = \\pm 2", "A", null, "B"),

            Question(3001, "MAT", "MAT-4", "\\text{Resuelve la desigualdad } 2x - 5 > 3", "x > 4", "x < 4", "x > -4", "x < -4", "A", null, "B"),
            Question(3002, "MAT", "MAT-4", "\\text{¿Cuál es el conjunto solución de } x^2 - 4x \\leq 0?", "\\{x | 0 \\leq x \\leq 4\\}", "\\{x | x \\leq 0 \\text{ o } x \\geq 4\\}", "\\{x | x \\geq 0\\}", "\\{x | x \\leq 4\\}", "A", null, "B"),
            Question(3003, "MAT", "MAT-4", "\\text{Resuelve la desigualdad } \\frac{3x + 1}{2} < 4", "x < \\frac{7}{3}", "x > \\frac{7}{3}", "x < 5", "x > 5", "A", null, "B"),
            Question(3004, "MAT", "MAT-4", "\\text{¿Cuál es la solución de } -2x + 7 \\geq 1?", "x \\leq 3", "x \\geq 3", "x \\leq -3", "x \\geq -3", "A", null, "B"),
            Question(3005, "MAT", "MAT-4", "\\text{Determina el conjunto solución de } |x - 2| < 5", "\\{-3 < x < 7\\}", "\\{x < -3 \\text{ o } x > 7\\}", "\\{-7 < x < 3\\}", "\\{x < 7\\}", "A", null, "B"),

            Question(4001, "MAT", "MAT-5", "\\text{Resuelve el sistema: } \\begin{cases} 2x + y = 5 \\\\ x - y = 1 \\end{cases}", "(x,y) = (2,1)", "(x,y) = (1,2)", "(x,y) = (3,-1)", "(x,y) = (0,5)", "A", null, "B"),
            Question(4002, "MAT", "MAT-5", "\\text{¿Cuál es la solución del sistema } \\begin{cases} 3x - 2y = 4 \\\\ 5x + y = 11 \\end{cases}?", "(x,y) = (2,1)", "(x,y) = (1,2)", "(x,y) = (3,1)", "(x,y) = (0,4)", "A", null, "B"),
            Question(4003, "MAT", "MAT-5", "\\text{Encuentra } x \\text{ e } y \\text{ en } \\begin{cases} x + y = 7 \\\\ 2x - y = 4 \\end{cases}", "(x,y) = (3,4)", "(x,y) = (4,3)", "(x,y) = (2,5)", "(x,y) = (5,2)", "B", null, "B"),
            Question(4004, "MAT", "MAT-5", "\\text{Resuelve el sistema } \\begin{cases} 4x + 3y = 24 \\\\ x - 2y = -3 \\end{cases}", "(x,y) = (3,4)", "(x,y) = (2,4)", "(x,y) = (4,3)", "(x,y) = (5,1)", "A", null, "B"),
            Question(4005, "MAT", "MAT-5", "\\text{¿Cuál es la solución del sistema } \\begin{cases} 6x + y = 9 \\\\ 2x - 3y = 4 \\end{cases}?", "(x,y) = (1,3)", "(x,y) = (2,1)", "(x,y) = (0,9)", "(x,y) = (3,1)", "D", null, "B"),

            Question(6001, "MAT", "MAT-6", "\\text{¿Cuál es el dominio de la función } f(x) = \\frac{1}{x-3}?", "\\{x \\in \\mathbb{R} \\mid x \\neq 3\\}", "\\{x \\in \\mathbb{R} \\mid x \\neq 0\\}", "\\{x \\in \\mathbb{R} \\mid x > 3\\}", "\\{x \\in \\mathbb{R}\\}", "A", null, "B"),
            Question(6002, "MAT", "MAT-6", "\\text{Si } f(x) = 2x^2 - 3x + 1, \\text{calcula } f(2).", "3", "5", "7", "9", "C", null, "B"),
            Question(6003, "MAT", "MAT-6", "\\text{¿Cuál es la imagen de } x = -1 \\text{ para } f(x) = x^3 + 2x?", "-1", "-3", "1", "3", "B", null, "B"),
            Question(6004, "MAT", "MAT-6", "\\text{La función } f(x) = \\sqrt{x-1} \\text{ tiene dominio }:", "\\{x \\in \\mathbb{R} \\mid x \\geq 1\\}", "\\{x \\in \\mathbb{R} \\mid x > 1\\}", "\\{x \\in \\mathbb{R} \\mid x \\leq 1\\}", "\\{x \\in \\mathbb{R} \\mid x < 1\\}", "A", null, "B"),
            Question(6005, "MAT", "MAT-6", "\\text{Dada la función } f(x) = 3x - 5, \\text{ ¿cuál es } f^{-1}(x)?", "f^{-1}(x) = \\frac{x+5}{3}", "f^{-1}(x) = 3x + 5", "f^{-1}(x) = \\frac{3}{x-5}", "f^{-1}(x) = \\frac{x-5}{3}", "A", null, "B"),

            Question(7001, "MAT", "MAT-7", "\\text{¿Cuál es el valor de } \\sin 30^\\circ?", "0", "0.5", "\\frac{\\sqrt{3}}{2}", "1", "B", null, "B"),
            Question(7002, "MAT", "MAT-7", "\\text{En un triángulo rectángulo, si el cateto opuesto mide 3 y el adyacente 4, ¿cuánto mide la hipotenusa?}", "5", "6", "7", "8", "A", null, "B"),
            Question(7003, "MAT", "MAT-7", "\\text{El coseno de } 0^\\circ \\text{ es }:", "0", "0.5", "1", "-1", "C", null, "B"),
            Question(7004, "MAT", "MAT-7", "\\text{¿Cuál es el valor de } \\tan 45^\\circ?", "0", "1", "\\sqrt{3}", "\\frac{1}{\\sqrt{3}}", "B", null, "B"),
            Question(7005, "MAT", "MAT-7", "\\text{Si } \\sin \\theta = \\frac{3}{5}, \\text{ y } \\theta \\text{ está en el primer cuadrante, ¿cuál es } \\cos \\theta?", "\\frac{4}{5}", "\\frac{3}{5}", "\\frac{5}{3}", "\\frac{1}{2}", "A", null, "B"),

            Question(8001, "MAT", "MAT-8", "\\text{La función } y = \\sin x \\text{ tiene periodo }:", "\\pi", "2\\pi", "\\frac{\\pi}{2}", "4\\pi", "B", null, "B"),
            Question(8002, "MAT", "MAT-8", "\\text{La función } y = \\cos x \\text{ es simétrica respecto al eje }:", "x", "y", "origen", "ninguno", "B", null, "B"),
            Question(8003, "MAT", "MAT-8", "\\text{El valor máximo de } y = \\tan x \\text{ es }:", "\\infty", "1", "0", "No tiene máximo", "D", null, "B"),
            Question(8004, "MAT", "MAT-8", "\\text{¿Cuál es la derivada de } f(x) = \\sin x?", "\\cos x", "-\\sin x", "-\\cos x", "\\sin x", "A", null, "B"),
            Question(8005, "MAT", "MAT-8", "\\text{El valor de } \\sin 90^\\circ \\text{ es }:", "0", "1", "-1", "\\frac{\\sqrt{2}}{2}", "B", null, "B"),

            Question(9001, "MAT", "MAT-9", "\\text{¿Cuál es el valor de } \\log_{10} 1000?", "1", "2", "3", "4", "C", null, "B"),
            Question(9002, "MAT", "MAT-9", "\\text{Si } f(x) = e^x, \\text{ entonces } f'(x) = ?", "e^x", "x e^{x-1}", "x e^x", "e", "A", null, "B"),
            Question(9003, "MAT", "MAT-9", "\\text{¿Cuál es la solución de } e^{2x} = 1?", "x = 0", "x = 1", "x = \\frac{1}{2}", "x = -1", "A", null, "B"),
            Question(9004, "MAT", "MAT-9", "\\text{Si } \\log_a b = 2 \\text{ y } \\log_a c = 3, \\text{ ¿cuánto vale } \\log_a (b c)?", "5", "6", "1", "\\frac{5}{6}", "A", null, "B"),
            Question(9005, "MAT", "MAT-9", "\\text{¿Cuál es la propiedad correcta del logaritmo?}", "\\log (xy) = \\log x + \\log y", "\\log (x + y) = \\log x + \\log y", "\\log (x^y) = y + \\log x", "\\log \\left(\\frac{x}{y}\\right) = \\log x \\cdot \\log y", "A", null, "B"),

            Question(10001, "MAT", "MAT-10", "\\text{¿Cuál es la pendiente de la recta } y = 3x + 5?", "3", "5", "-3", "0", "A", null, "B"),
            Question(10002, "MAT", "MAT-10", "\\text{Ecuación de la recta que pasa por } (1, 2) \\text{ y tiene pendiente } 4:", "y = 4x - 2", "y = 4x + 2", "y = 4x - 4", "y = 4x + 6", "A", null, "B"),
            Question(10003, "MAT", "MAT-10", "\\text{La forma general de la ecuación de la recta es:}", "Ax + By + C = 0", "y = mx + b", "x = y + b", "y = Ax + C", "A", null, "B"),
            Question(10004, "MAT", "MAT-10", "\\text{Si dos rectas son paralelas, sus pendientes:}", "Son iguales", "Son inversas", "Son negativas", "No tienen pendiente", "A", null, "B"),
            Question(10005, "MAT", "MAT-10", "\\text{¿Cuál es la pendiente de la recta perpendicular a } y = \\frac{1}{2}x + 3?", "-2", "\\frac{1}{2}", "2", "-\\frac{1}{2}", "A", null, "B"),

            Question(11001, "MAT", "MAT-11", "\\text{¿Cuál es la ecuación general de una circunferencia con centro en } (h, k) \\text{ y radio } r?", "(x - h)^2 + (y - k)^2 = r^2", "x^2 + y^2 = r", "(x + h)^2 + (y + k)^2 = r^2", "x^2 + y^2 = r^2", "A", null, "B"),
            Question(11002, "MAT", "MAT-11", "\\text{¿Cuál es el centro y radio de la circunferencia } x^2 + y^2 - 4x + 6y - 12 = 0?", "Centro (2, -3), radio 5", "Centro (-2, 3), radio 5", "Centro (2, 3), radio 6", "Centro (-2, -3), radio 6", "A", null, "B"),
            Question(11003, "MAT", "MAT-11", "\\text{¿Qué representa la ecuación } (x - 1)^2 + (y + 2)^2 = 9?", "Una circunferencia con centro en (1, -2) y radio 3", "Una circunferencia con centro en (-1, 2) y radio 9", "Una elipse con centro en (1, -2)", "Una parábola con foco en (1, -2)", "A", null, "B"),
            Question(11004, "MAT", "MAT-11", "\\text{¿Cómo se obtiene el radio } r \\text{ de la circunferencia si se conoce la ecuación } (x - h)^2 + (y - k)^2 = r^2?", "Es la raíz cuadrada del término independiente", "Es el coeficiente de } x", "Es el coeficiente de } y", "Es el valor de } h", "A", null, "B"),
            Question(11005, "MAT", "MAT-11", "\\text{¿Qué tipo de curva representa la ecuación } x^2 + y^2 = 0?", "Un punto en el origen", "Una circunferencia con radio 0", "Una línea", "No representa una curva real", "A", null, "B"),

            Question(12001, "MAT", "MAT-12", "\\text{¿Cuál es la ecuación general de una elipse con centro en } (h, k)?", "\\frac{(x - h)^2}{a^2} + \\frac{(y - k)^2}{b^2} = 1", "\\frac{(x - h)^2}{b^2} - \\frac{(y - k)^2}{a^2} = 1", "(x - h)^2 + (y - k)^2 = r^2", "y = mx + b", "A", null, "B"),
            Question(12002, "MAT", "MAT-12", "\\text{Si } a > b, \\text{ ¿cuál es el eje mayor de la elipse?}", "El eje horizontal", "El eje vertical", "El eje inclinado", "No tiene eje mayor", "A", null, "B"),
            Question(12003, "MAT", "MAT-12", "\\text{¿Dónde están los focos de la elipse si el centro está en } (0,0)?", "(\\pm c, 0) \\text{ o } (0, \\pm c) \\text{ donde } c^2 = a^2 - b^2", "(0,0)", "(a,b)", "No tiene focos", "A", null, "B"),
            Question(12004, "MAT", "MAT-12", "\\text{La suma de las distancias de cualquier punto de la elipse a los focos es:}", "Constante e igual a } 2a", "Variable", "Constante e igual a } 2b", "Variable e igual a } a + b", "A", null, "B"),
            Question(12005, "MAT", "MAT-12", "\\text{¿Qué pasa si } a = b \\text{ en la ecuación de la elipse?}", "Se convierte en una circunferencia", "Se convierte en una parábola", "Se convierte en una hipérbola", "No representa una figura geométrica", "A", null, "B"),

            Question(13001, "MAT", "MAT-13", "\\text{¿Cuál es la ecuación canónica de una hipérbola con centro en } (h, k)?", "\\frac{(x - h)^2}{a^2} - \\frac{(y - k)^2}{b^2} = 1", "\\frac{(x - h)^2}{a^2} + \\frac{(y - k)^2}{b^2} = 1", "(x - h)^2 + (y - k)^2 = r^2", "\\frac{(y - k)^2}{a^2} - \\frac{(x - h)^2}{b^2} = 1", "A", null, "B"),
            Question(13002, "MAT", "MAT-13", "\\text{¿Qué caracteriza a una hipérbola respecto a sus focos?}", "La diferencia de distancias a los focos es constante", "La suma de distancias a los focos es constante", "Tiene un solo foco", "No tiene focos", "A", null, "B"),
            Question(13003, "MAT", "MAT-13", "\\text{¿Cómo se calcula la distancia } c \\text{ del centro a los focos en una hipérbola?}", "c^2 = a^2 + b^2", "c^2 = a^2 - b^2", "c^2 = b^2 - a^2", "c^2 = a^2 \\cdot b^2", "A", null, "B"),
            Question(13004, "MAT", "MAT-13", "\\text{¿Qué representa la ecuación } \\frac{x^2}{4} - \\frac{y^2}{9} = 1?", "Una hipérbola horizontal", "Una hipérbola vertical", "Una elipse", "Una parábola", "A", null, "B"),
            Question(13005, "MAT", "MAT-13", "\\text{¿Cuál es la condición para que una cónica sea una hipérbola en su forma general } Ax^2 + Bxy + Cy^2 + Dx + Ey + F = 0?", "A y C tienen signos opuestos", "A = C", "B = 0", "A = 0", "A", null, "B"),

            Question(14001, "MAT", "MAT-14", "\\text{¿Cuál es la forma general de la ecuación de segundo grado?}", "Ax^2 + Bx + C = 0", "Ax + B = 0", "Ax^2 + B = 0", "Ax^2 + C = 0", "A", null, "B"),
            Question(14002, "MAT", "MAT-14", "\\text{¿Qué determina el discriminante } \\Delta = B^2 - 4AC \\text{ de una ecuación cuadrática?}", "El número y tipo de soluciones", "El valor del vértice", "La pendiente", "El valor de C", "A", null, "B"),
            Question(14003, "MAT", "MAT-14", "\\text{Si } \\Delta < 0 \\text{ en una ecuación cuadrática, entonces:}", "Tiene dos soluciones complejas", "Tiene una sola solución real", "Tiene dos soluciones reales", "No tiene solución", "A", null, "B"),
            Question(14004, "MAT", "MAT-14", "\\text{¿Cuál es la fórmula general para resolver } Ax^2 + Bx + C = 0?", "x = \\frac{-B \\pm \\sqrt{B^2 - 4AC}}{2A}", "x = \\frac{-B \\pm \\sqrt{AC}}{2A}", "x = \\frac{-B}{2A}", "x = \\frac{-C \\pm \\sqrt{B^2 - 4A}}{2A}", "A", null, "B"),
            Question(14005, "MAT", "MAT-14", "\\text{¿Qué representa gráficamente una ecuación de segundo grado en una variable?}", "Una parábola", "Una recta", "Una circunferencia", "Una hipérbola", "A", null, "B"),

            Question(15001, "MAT", "MAT-15", "\\text{¿Cuál es el límite de } \\lim_{x \\to 2} (3x + 1)?", "7", "6", "5", "8", "A", null, "A1"),
            Question(15002, "MAT", "MAT-15", "\\text{Si } \\lim_{x \\to a} f(x) = L \\text{, entonces:}", "f(x) se aproxima a L cuando x se acerca a a", "f(a) = L", "x siempre vale a", "f(x) = a", "A", null, "A1"),
            Question(15003, "MAT", "MAT-15", "\\text{¿Qué representa } \\lim_{x \\to \\infty} \\frac{1}{x}?", "0", "1", "Infinito", "Indeterminado", "A", null, "A1"),
            Question(15004, "MAT", "MAT-15", "\\text{¿Qué tipo de indeterminación representa } \\frac{0}{0}?", "Indeterminación", "Infinito", "Límite nulo", "No existe", "A", null, "A1"),
            Question(15005, "MAT", "MAT-15", "\\text{¿Cuál es el valor de } \\lim_{x \\to 0} \\frac{\\sin x}{x}?", "1", "0", "Infinito", "No existe", "A", null, "A1"),

            Question(16001, "MAT", "MAT-16", "\\text{¿Qué representa la derivada de una función?}", "La pendiente de la tangente en un punto", "El área bajo la curva", "El valor máximo de la función", "La constante de integración", "A", null, "A1"),
            Question(16002, "MAT", "MAT-16", "\\text{¿Cuál es la derivada de } f(x) = x^2?", "2x", "x", "x^2", "2", "A", null, "A1"),
            Question(16003, "MAT", "MAT-16", "\\text{¿Cuál es la derivada de una constante } c?", "0", "1", "c", "c^2", "A", null, "A1"),
            Question(16004, "MAT", "MAT-16", "\\text{¿Cuál es la notación de Leibniz para la derivada de } y = f(x)?", "\\frac{dy}{dx}", "f'(x)", "\\frac{dx}{dy}", "Df(x)", "A", null, "A1"),
            Question(16005, "MAT", "MAT-16", "\\text{¿Cuál es la derivada de } f(x) = \\sin x?", "\\cos x", "-\\cos x", "\\sin x", "-\\sin x", "A", null, "A1"),

            Question(17001, "MAT", "MAT-17", "\\text{¿Qué representa una integral definida?}", "El área bajo la curva entre dos puntos", "La pendiente de la curva", "La longitud de la curva", "El volumen de la región", "A", null, "A1"),
            Question(17002, "MAT", "MAT-17", "\\text{¿Cuál es la integral de } f(x) = x^n \\text{ con } n \\neq -1?", "\\frac{x^{n+1}}{n+1} + C", "\\frac{1}{x} + C", "n x^{n-1} + C", "x^{n+1} + C", "A", null, "A1"),
            Question(17003, "MAT", "MAT-17", "\\text{¿Cuál es la integral de } f(x) = \\cos x?", "\\sin x + C", "-\\sin x + C", "\\cos x + C", "-\\cos x + C", "A", null, "A1"),
            Question(17004, "MAT", "MAT-17", "\\int_0^1 x^2\\,dx = ?", "\\frac{1}{3}", "1", "\\frac{1}{2}", "\\frac{2}{3}", "A", null, "A1"),
            Question(17005, "MAT", "MAT-17", "\\text{¿Qué relación existe entre derivada e integral?}", "La integral es la operación inversa de la derivada", "La derivada es una parte de la integral", "Ambas operaciones no tienen relación", "Ambas calculan el área", "A", null, "A1"),


            Question(101, "BIO", "BIO-1", "¿Cuál es el nivel más básico de organización de la materia viva?", "Célula", "Molécula", "Átomo", "Tejido", "C", null, "A"),
            Question(102, "BIO", "BIO-1", "¿Qué estructura regula la entrada y salida de sustancias en la célula?", "Pared celular", "Membrana plasmática", "Núcleo", "Citoplasma", "B", null, "A"),
            Question(103, "BIO", "BIO-1", "¿Qué orgánulo celular contiene el ADN?", "Lisosoma", "Ribosoma", "Mitocondria", "Núcleo", "D", null, "A"),
            Question(104, "BIO", "BIO-1", "¿Cuál de los siguientes no es un organelo?", "Núcleo", "Ribosoma", "ADN", "Aparato de Golgi", "C", null, "A"),
            Question(105, "BIO", "BIO-1", "¿Qué tipo de célula no tiene núcleo definido?", "Animal", "Vegetal", "Procariota", "Eucariota", "C", null, "A"),

            Question(106, "BIO", "BIO-2", "¿Cuál es la molécula que almacena energía en las células?", "ADN", "ATP", "ARN", "Glucógeno", "B", null, "A"),
            Question(107, "BIO", "BIO-2", "¿Qué proceso convierte la glucosa en energía?", "Fotosíntesis", "Respiración celular", "Digestión", "Fermentación", "B", null, "A"),
            Question(108, "BIO", "BIO-2", "¿Dónde ocurre principalmente la respiración celular?", "Ribosoma", "Cloroplasto", "Núcleo", "Mitocondria", "D", null, "A"),
            Question(109, "BIO", "BIO-2", "¿Qué orgánulo se encarga de la fotosíntesis?", "Cloroplasto", "Lisosoma", "Mitocondria", "Aparato de Golgi", "A", null, "A"),
            Question(110, "BIO", "BIO-2", "¿Qué enzimas catalizan las reacciones metabólicas?", "Hormonas", "Proteínas", "Vitaminas", "Enzimas", "D", null, "A"),

            Question(111, "BIO", "BIO-3", "¿Qué tipo de reproducción requiere de dos progenitores?", "Asexual", "Sexual", "Mitosis", "Bipartición", "B", null, "A"),
            Question(112, "BIO", "BIO-3", "¿En qué fase de la mitosis se alinean los cromosomas en el centro?", "Profase", "Metafase", "Anafase", "Telofase", "B", null, "A"),
            Question(113, "BIO", "BIO-3", "¿Cómo se llama la división celular que produce gametos?", "Mitosis", "Meiosis", "Fisión binaria", "Duplicación", "B", null, "A"),
            Question(114, "BIO", "BIO-3", "¿Qué tipo de reproducción es más rápida?", "Sexual", "Asexual", "Por fecundación", "Meiótica", "B", null, "A"),
            Question(115, "BIO", "BIO-3", "¿La fecundación es característica de qué tipo de reproducción?", "Asexual", "Bipartición", "Sexual", "Esporulación", "C", null, "A"),

            Question(116, "BIO", "BIO-4", "¿Quién propuso las leyes de la herencia?", "Watson", "Crick", "Mendel", "Darwin", "C", null, "A"),
            Question(117, "BIO", "BIO-4", "¿Qué representa una letra mayúscula en genética?", "Recesivo", "Dominante", "Mutación", "Codón", "B", null, "A"),
            Question(118, "BIO", "BIO-4", "¿Qué estructura porta la información genética?", "Proteínas", "Glucosa", "ADN", "Lípidos", "C", null, "A"),
            Question(119, "BIO", "BIO-4", "¿Qué célula transmite la herencia?", "Neurona", "Esperma", "Célula madre", "Célula somática", "B", null, "A"),
            Question(120, "BIO", "BIO-4", "¿Qué significa homocigoto?", "Dos genes distintos", "Dos genes iguales", "Un solo gen", "Sin genes", "B", null, "A"),

            Question(121, "BIO", "BIO-5", "¿Cuál es el mecanismo propuesto por Darwin para la evolución?", "Mutación", "Adaptación", "Selección natural", "Deriva genética", "C", null, "A"),
            Question(122, "BIO", "BIO-5", "¿Qué indica el registro fósil?", "Cambios climáticos", "Evidencia evolutiva", "Distribución vegetal", "Movimiento de placas", "B", null, "A"),
            Question(123, "BIO", "BIO-5", "¿Qué estructuras indican un ancestro común?", "Órganos homólogos", "Órganos análogos", "Mutaciones", "Órganos únicos", "A", null, "A"),
            Question(124, "BIO", "BIO-5", "¿Qué tipo de selección favorece a los extremos?", "Estabilizadora", "Disruptiva", "Direccional", "Neutral", "B", null, "A"),
            Question(125, "BIO", "BIO-5", "¿Cuál es una fuente de variabilidad genética?", "Reproducción asexual", "Mutación", "Homeostasis", "Mitocondria", "B", null, "A"),

            Question(126, "BIO", "BIO-6", "¿Cómo se llama el lugar donde vive un organismo?", "Ecosistema", "Hábitat", "Nicho", "Población", "B", null, "A"),
            Question(127, "BIO", "BIO-6", "¿Qué representa un ecosistema?", "Sólo animales", "Interacción entre seres vivos y ambiente", "Solo plantas", "Cadena trófica", "B", null, "A"),
            Question(128, "BIO", "BIO-6", "¿Qué ciclo incluye fotosíntesis y respiración?", "Ciclo del nitrógeno", "Ciclo del carbono", "Ciclo del agua", "Ciclo del fósforo", "B", null, "A"),
            Question(129, "BIO", "BIO-6", "¿Qué nivel de organización incluye diferentes especies?", "Población", "Comunidad", "Célula", "Órgano", "B", null, "A"),
            Question(130, "BIO", "BIO-6", "¿Qué es la biodiversidad?", "Riqueza de agua", "Variedad de especies", "Tipo de suelo", "Abundancia de clorofila", "B", null, "A"),

            Question(201, "ESP", "ESP-1", "¿Cuál es la principal función de la lengua en la comunicación humana?", "Expresar sentimientos", "Transmitir información", "Ordenar ideas", "Reforzar la memoria", "B", null, "A"),
            Question(202, "ESP", "ESP-1", "¿Qué elementos intervienen en el proceso comunicativo?", "Receptor, canal y código", "Emisor, receptor, canal y código", "Emisor, receptor y mensaje", "Mensaje y contexto", "B", null, "A"),
            Question(203, "ESP", "ESP-1", "¿Qué es un canal en la comunicación?", "El medio físico por el que se transmite el mensaje", "El contenido del mensaje", "El lenguaje usado", "El contexto de la situación", "A", null, "A"),
            Question(204, "ESP", "ESP-1", "¿Qué tipo de lenguaje utilizamos al hablar con amigos?", "Formal", "Académico", "Informal", "Técnico", "C", null, "A"),
            Question(205, "ESP", "ESP-1", "¿Qué función del lenguaje predomina en una orden?", "Referencial", "Apelativa", "Fática", "Poética", "B", null, "A"),

            Question(206, "ESP", "ESP-2", "¿Qué tipo de texto busca convencer al lector?", "Narrativo", "Descriptivo", "Expositivo", "Argumentativo", "D", null, "A"),
            Question(207, "ESP", "ESP-2", "¿Cuál es la principal característica de un texto descriptivo?", "Presenta hechos", "Describe cualidades", "Cuenta una historia", "Argumenta ideas", "B", null, "A"),
            Question(208, "ESP", "ESP-2", "¿Qué texto se enfoca en informar objetivamente?", "Narrativo", "Expositivo", "Argumentativo", "Descriptivo", "B", null, "A"),
            Question(209, "ESP", "ESP-2", "¿Cuál es una forma discursiva que relata sucesos en orden cronológico?", "Argumentativa", "Narrativa", "Expositiva", "Descriptiva", "B", null, "A"),
            Question(210, "ESP", "ESP-2", "¿Qué se busca en un texto argumentativo?", "Narrar hechos", "Describir lugares", "Convencer con razones", "Informar datos", "C", null, "A"),

            Question(211, "ESP", "ESP-3", "¿Qué se evalúa al comprender un texto?", "Ortografía", "Lectura en voz alta", "Entonación", "Interpretación del contenido", "D", null, "A"),
            Question(212, "ESP", "ESP-3", "¿Qué es una idea principal?", "Una anécdota", "Un dato secundario", "La información más relevante del texto", "Un ejemplo", "C", null, "A"),
            Question(213, "ESP", "ESP-3", "¿Qué permite la lectura crítica?", "Memorizar datos", "Comprender mejor la ortografía", "Cuestionar e interpretar la información", "Leer más rápido", "C", null, "A"),
            Question(214, "ESP", "ESP-3", "¿Qué se debe identificar primero al leer un texto?", "El título", "El tema principal", "El autor", "La editorial", "B", null, "A"),
            Question(215, "ESP", "ESP-3", "¿Qué indica un conector como 'por lo tanto'?", "Contraste", "Causa", "Consecuencia", "Tiempo", "C", null, "A"),

            Question(216, "ESP", "ESP-4", "¿Qué clase de palabra indica acción?", "Sustantivo", "Adjetivo", "Verbo", "Adverbio", "C", null, "A"),
            Question(217, "ESP", "ESP-4", "¿Cuál es un ejemplo de adjetivo?", "Correr", "Bonito", "Casa", "Rápidamente", "B", null, "A"),
            Question(218, "ESP", "ESP-4", "¿Qué función tiene el sustantivo en una oración?", "Describe", "Modifica", "Nombrar personas, objetos o lugares", "Expresa acciones", "C", null, "A"),
            Question(219, "ESP", "ESP-4", "¿Qué indica el tiempo verbal?", "Cantidad", "Lugar", "Momento de la acción", "Intención", "C", null, "A"),
            Question(220, "ESP", "ESP-4", "¿Cuál es una oración en tiempo futuro?", "Yo comí", "Él come", "Nosotros comeremos", "Tú comías", "C", null, "A"),

            Question(221, "ESP", "ESP-5", "¿Qué es un párrafo?", "Una palabra aislada", "Un conjunto de frases sin relación", "Una oración larga", "Un conjunto de oraciones sobre una idea principal", "D", null, "A"),
            Question(222, "ESP", "ESP-5", "¿Qué debe tener una introducción?", "Conclusiones", "Desarrollo de ideas", "Presentación del tema", "Bibliografía", "C", null, "A"),
            Question(223, "ESP", "ESP-5", "¿Qué conecta ideas en un texto?", "Oraciones simples", "Puntos y comas", "Conectores", "Signos de interrogación", "C", null, "A"),
            Question(224, "ESP", "ESP-5", "¿Cuál es la función del desarrollo en un texto?", "Presentar el tema", "Dar ejemplos y argumentos", "Finalizar ideas", "Redactar el título", "B", null, "A"),
            Question(225, "ESP", "ESP-5", "¿Qué caracteriza una conclusión efectiva?", "Introduce nuevas ideas", "Resume y cierra el texto", "Evita opiniones", "Amplía el tema", "B", null, "A"),

            Question(226, "ESP", "ESP-6", "¿Qué es un sinónimo de ‘feliz’?", "Triste", "Alegre", "Cansado", "Serio", "B", null, "A"),
            Question(227, "ESP", "ESP-6", "¿Qué es un antónimo?", "Una palabra compuesta", "Una palabra con significado opuesto", "Una palabra técnica", "Una palabra inventada", "B", null, "A"),
            Question(228, "ESP", "ESP-6", "¿Qué significa ‘sustituir’?", "Romper", "Colocar junto", "Reemplazar", "Aumentar", "C", null, "A"),
            Question(229, "ESP", "ESP-6", "¿Qué palabra es un sinónimo de ‘rápido’?", "Veloz", "Lento", "Despacio", "Parado", "A", null, "A"),
            Question(230, "ESP", "ESP-6", "¿Qué palabra es un antónimo de ‘grande’?", "Alto", "Pequeño", "Ancho", "Enorme", "B", null, "A"),

            Question(231, "ESP", "ESP-7", "¿Cuál es la forma correcta?", "Hizo un oyito", "Hizo un hoyito", "Hizo un hoito", "Hizo un oíto", "B", null, "A"),
            Question(232, "ESP", "ESP-7", "¿Cuál palabra está escrita correctamente?", "Esajerar", "Exagerar", "Exajerar", "Esagerar", "B", null, "A"),
            Question(233, "ESP", "ESP-7", "¿Qué signo indica una pausa breve?", "Punto", "Coma", "Dos puntos", "Punto y coma", "B", null, "A"),
            Question(234, "ESP", "ESP-7", "¿Cómo se escribe correctamente?", "A ser el trabajo", "Hacer el trabajo", "Hacer él trabajo", "Aser el trabajo", "B", null, "A"),
            Question(235, "ESP", "ESP-7", "¿Cuál es la forma correcta?", "Hiba a salir", "Iva a salir", "Iba a salir", "Hiva a salir", "C", null, "A"),

            Question(301, "HMX", "HMX-1", "¿Qué institución regulaba la vida religiosa y educativa en la Nueva España?", "El cabildo", "La Audiencia", "La Iglesia", "El Virreinato", "C", null, "A"),
            Question(302, "HMX", "HMX-1", "¿Cuál era la principal actividad económica de la Nueva España?", "La minería", "El comercio con Asia", "La pesca", "La agricultura de exportación", "A", null, "A"),
            Question(303, "HMX", "HMX-1", "¿Qué grupo social predominaba en el gobierno virreinal?", "Indígenas", "Criollos", "Peninsulares", "Mestizos", "C", null, "A"),
            Question(304, "HMX", "HMX-1", "¿Qué fue el sistema de encomiendas?", "Un método para educar indígenas", "Un sistema fiscal", "Una forma de esclavitud indígena", "Una institución militar", "C", null, "B"),
            Question(305, "HMX", "HMX-1", "¿Qué institución representaba al rey de España en la Nueva España?", "El cabildo", "El virrey", "El corregidor", "El inquisidor", "B", null, "A"),

            Question(306, "HMX", "HMX-2", "¿Quién encabezó el inicio de la Independencia en 1810?", "José María Morelos", "Vicente Guerrero", "Miguel Hidalgo", "Agustín de Iturbide", "C", null, "A"),
            Question(307, "HMX", "HMX-2", "¿Cuál fue el documento que proclamaba la independencia?", "Plan de Ayala", "Plan de Iguala", "Constitución de Cádiz", "Sentimientos de la Nación", "B", null, "B"),
            Question(308, "HMX", "HMX-2", "¿Qué papel jugó José María Morelos en la independencia?", "Organizó el ejército insurgente", "Negoció con España", "Dirigió la Inquisición", "Promovió la paz", "A", null, "B"),
            Question(309, "HMX", "HMX-2", "¿Qué buscaba el movimiento de Independencia?", "Más impuestos", "Autonomía local", "Independencia total de España", "Apoyo francés", "C", null, "A"),
            Question(310, "HMX", "HMX-2", "¿Qué sucedió con Miguel Hidalgo tras ser capturado?", "Fue liberado", "Fue desterrado", "Fue fusilado", "Fue nombrado virrey", "C", null, "A"),

            Question(311, "HMX", "HMX-3", "¿Quién fue el primer emperador del México independiente?", "Benito Juárez", "Agustín de Iturbide", "Antonio López de Santa Anna", "Guadalupe Victoria", "B", null, "A"),
            Question(312, "HMX", "HMX-3", "¿Qué tipo de gobierno se instauró tras la caída del imperio de Iturbide?", "Teocracia", "Monarquía constitucional", "República federal", "Dictadura", "C", null, "A"),
            Question(313, "HMX", "HMX-3", "¿Qué conflicto marcó esta etapa?", "La intervención estadounidense", "La guerra cristera", "La guerra de Reforma", "La revolución", "A", null, "B"),
            Question(314, "HMX", "HMX-3", "¿Quién fue presidente en múltiples ocasiones y tuvo gran influencia?", "Juárez", "Iturbide", "Santa Anna", "Obregón", "C", null, "B"),
            Question(315, "HMX", "HMX-3", "¿Qué documento estableció el sistema federal en México?", "Constitución de 1824", "Plan de Ayutla", "Acta de Independencia", "Plan de Tuxtepec", "A", null, "A"),

            Question(316, "HMX", "HMX-4", "¿Qué presidente impulsó las Leyes de Reforma?", "Santa Anna", "Juárez", "Porfirio Díaz", "Madero", "B", null, "B"),
            Question(317, "HMX", "HMX-4", "¿Qué buscaban las Leyes de Reforma?", "Apoyar a la Iglesia", "Eliminar la educación pública", "Separar Iglesia y Estado", "Fortalecer al clero", "C", null, "A"),
            Question(318, "HMX", "HMX-4", "¿Qué país intervino en México durante esta etapa?", "España", "Estados Unidos", "Francia", "Inglaterra", "C", null, "B"),
            Question(319, "HMX", "HMX-4", "¿Qué evento representó la victoria republicana ante el Imperio?", "Batalla de Puebla", "Fusilamiento de Maximiliano", "Plan de Tuxtepec", "Firma del Tratado de Córdoba", "B", null, "A"),
            Question(320, "HMX", "HMX-4", "¿Quién encabezó la resistencia liberal?", "Porfirio Díaz", "Venustiano Carranza", "Juárez", "Miguel Lerdo", "C", null, "A"),

            Question(321, "HMX", "HMX-5", "¿Quién fue el dictador durante el Porfiriato?", "Juárez", "Madero", "Obregón", "Porfirio Díaz", "D", null, "A"),
            Question(322, "HMX", "HMX-5", "¿Qué lema representaba la política porfirista?", "Tierra y libertad", "Sufragio efectivo, no reelección", "Orden y progreso", "Pan y circo", "C", null, "A"),
            Question(323, "HMX", "HMX-5", "¿Qué sector fue beneficiado durante el Porfiriato?", "Campesinado", "Iglesia", "Extranjeros e inversionistas", "Obreros", "C", null, "B"),
            Question(324, "HMX", "HMX-5", "¿Qué tipo de desarrollo tuvo México en este periodo?", "Cultural", "Económico y de infraestructura", "Militar", "Tecnológico", "B", null, "A"),
            Question(325, "HMX", "HMX-5", "¿Qué originó el fin del Porfiriato?", "Una invasión", "La muerte de Díaz", "La Revolución Mexicana", "Un golpe militar", "C", null, "A"),

            Question(326, "HMX", "HMX-6", "¿En qué año inició la Revolución Mexicana?", "1910", "1920", "1900", "1888", "A", null, "A"),
            Question(327, "HMX", "HMX-6", "¿Qué documento político impulsó Francisco I. Madero?", "Plan de San Luis", "Plan de Ayutla", "Constitución de 1917", "Plan de Agua Prieta", "A", null, "B"),
            Question(328, "HMX", "HMX-6", "¿Qué personaje fue clave en el sur del país durante la revolución?", "Obregón", "Carranza", "Zapata", "Huerta", "C", null, "A"),
            Question(329, "HMX", "HMX-6", "¿Qué objetivo tenía la revolución?", "Eliminar el clero", "Terminar con la dictadura porfirista", "Invadir EUA", "Reinstaurar el imperio", "B", null, "A"),
            Question(330, "HMX", "HMX-6", "¿Qué general derrocó a Madero?", "Zapata", "Huerta", "Carranza", "Villa", "B", null, "B"),

            Question(331, "HMX", "HMX-7", "¿Qué presidente impulsó la educación rural?", "Plutarco Elías Calles", "Álvaro Obregón", "Lázaro Cárdenas", "Manuel Ávila Camacho", "B", null, "B"),
            Question(332, "HMX", "HMX-7", "¿Qué organización política se creó en 1929?", "PRI", "PAN", "PRD", "Partido Liberal", "A", null, "B"),
            Question(333, "HMX", "HMX-7", "¿Qué caracterizó la reconstrucción nacional?", "Guerra civil", "Estabilidad política y modernización", "Dictadura", "Intervención extranjera", "B", null, "A"),
            Question(334, "HMX", "HMX-7", "¿Qué institución se fortaleció en este periodo?", "Ejército", "Iglesia", "SEP", "Banco de México", "C", null, "A"),
            Question(335, "HMX", "HMX-7", "¿Qué presidente inició la política de reparto agrario?", "Calles", "Obregón", "Cárdenas", "Carranza", "C", null, "A"),

            Question(336, "HMX", "HMX-8", "¿Qué presidente nacionalizó el petróleo?", "Lázaro Cárdenas", "Manuel Ávila Camacho", "Miguel Alemán", "Echeverría", "A", null, "A"),
            Question(337, "HMX", "HMX-8", "¿Qué sector económico creció en el llamado 'milagro mexicano'?", "Primario", "Industrial", "Turístico", "Agrícola", "B", null, "A"),
            Question(338, "HMX", "HMX-8", "¿Qué movimiento estudiantil fue reprimido en 1968?", "UNAM libre", "Movimiento de Reforma", "Movimiento del 68", "Movimiento pro democracia", "C", null, "B"),
            Question(339, "HMX", "HMX-8", "¿Qué presidente creó el ISSSTE?", "Cárdenas", "Ávila Camacho", "Adolfo López Mateos", "Díaz Ordaz", "C", null, "A"),
            Question(340, "HMX", "HMX-8", "¿Qué característica tuvo el sistema político mexicano en el siglo XX?", "Pluripartidismo", "Unipartidismo", "Monarquía", "Federalismo centralizado", "B", null, "A"),

            // HUN-1: La Historia
            Question(1, "HUN", "HUN-1", "¿Qué estudia la Historia como disciplina?", "El pasado humano", "El futuro de la humanidad", "La naturaleza", "Los animales", "A", null, "A"),
            Question(2, "HUN", "HUN-1", "¿Cuál es una fuente primaria para el estudio de la historia?", "Libro de texto", "Carta de un soldado", "Artículo de revista", "Enciclopedia", "B", null, "A"),
            Question(3, "HUN", "HUN-1", "¿Qué permite la periodización histórica?", "Inventar hechos históricos", "Ubicar hechos en el tiempo", "Eliminar eventos irrelevantes", "Memorizar fechas", "B", null, "A"),
            Question(4, "HUN", "HUN-1", "¿Cuál es el objetivo principal del historiador?", "Escribir novelas", "Difundir mitos", "Investigar y explicar hechos del pasado", "Predecir el futuro", "C", null, "A"),
            Question(5, "HUN", "HUN-1", "¿Qué herramienta utiliza principalmente el historiador?", "Microscopio", "Cálculo diferencial", "Análisis de fuentes", "Diseño gráfico", "C", null, "A"),

            // HUN-2: Las revoluciones burguesas
            Question(6, "HUN", "HUN-2", "¿En qué siglo ocurrió la Revolución Francesa?", "XVII", "XVIII", "XIX", "XX", "B", null, "A"),
            Question(7, "HUN", "HUN-2", "¿Qué documento surgió durante la Revolución Francesa?", "La Biblia", "La Constitución de Cádiz", "La Declaración de los Derechos del Hombre y del Ciudadano", "El Código Napoleónico", "C", null, "A"),
            Question(8, "HUN", "HUN-2", "¿Qué clase social lideró las revoluciones burguesas?", "Nobleza", "Clero", "Burguesía", "Campesinado", "C", null, "A"),
            Question(9, "HUN", "HUN-2", "¿Qué país fue escenario de la Independencia de las Trece Colonias?", "Francia", "México", "Estados Unidos", "Alemania", "C", null, "A"),
            Question(10, "HUN", "HUN-2", "¿Cuál fue una consecuencia de las revoluciones burguesas?", "Mayor poder del rey", "Establecimiento de monarquías absolutas", "Difusión del pensamiento liberal", "Expansión del feudalismo", "C", null, "A"),

            // HUN-3: Pensamientos y movimientos del siglo XIX
            Question(11, "HUN", "HUN-3", "¿Qué ideología defendía la propiedad privada y la libre empresa?", "Liberalismo", "Socialismo", "Absolutismo", "Comunismo", "A", null, "A"),
            Question(12, "HUN", "HUN-3", "¿Quién propuso el socialismo científico junto con Engels?", "Smith", "Rousseau", "Karl Marx", "Napoleón", "C", null, "A"),
            Question(13, "HUN", "HUN-3", "¿Qué movimiento defendía los derechos del proletariado?", "Romanticismo", "Socialismo", "Feudalismo", "Liberalismo", "B", null, "A"),
            Question(14, "HUN", "HUN-3", "¿Cuál fue una característica del nacionalismo en el siglo XIX?", "Defensa del absolutismo", "Búsqueda de la unificación territorial", "Apoyo al colonialismo", "Rechazo de la identidad cultural", "B", null, "A"),
            Question(15, "HUN", "HUN-3", "¿Qué corriente influyó en la Revolución Industrial?", "Feudalismo", "Comunismo", "Liberalismo", "Romanticismo", "C", null, "A"),

            Question(16, "HUN", "HUN-4", "¿Qué país europeo lideró la expansión imperialista en África durante el siglo XIX?", "Francia", "Alemania", "Gran Bretaña", "Italia", "C", null, "A"),
            Question(17, "HUN", "HUN-4", "¿Cuál fue una consecuencia directa del imperialismo europeo en Asia?", "El fortalecimiento de los imperios asiáticos", "La independencia inmediata de las colonias", "La explotación de recursos y pueblos", "La erradicación del comercio", "C", null, "A"),
            Question(18, "HUN", "HUN-4", "¿Qué justificación ideológica se utilizó para el imperialismo en el siglo XIX?", "La democracia directa", "El darwinismo social", "El marxismo", "La teoría heliocéntrica", "B", null, "B"),
            Question(19, "HUN", "HUN-4", "¿Qué conferencia dividió África entre potencias europeas sin considerar a los pueblos africanos?", "Conferencia de París", "Conferencia de Berlín", "Conferencia de Viena", "Conferencia de Yalta", "B", null, "A"),
            Question(20, "HUN", "HUN-4", "¿Cuál fue una característica económica del imperialismo?", "Reducción del comercio", "Cooperación con las colonias", "Búsqueda de nuevos mercados", "Desmilitarización", "C", null, "A"),

            Question(21, "HUN", "HUN-5", "¿Qué evento detonó la Primera Guerra Mundial?", "La invasión de Polonia", "El asesinato del archiduque Francisco Fernando", "La firma del Tratado de Versalles", "La Revolución rusa", "B", null, "A"),
            Question(22, "HUN", "HUN-5", "¿Cuál fue una de las principales alianzas en la Primera Guerra Mundial?", "Eje Roma-Berlín", "OTAN", "Triple Entente", "Pacto de Varsovia", "C", null, "A"),
            Question(23, "HUN", "HUN-5", "¿Qué tratado puso fin oficialmente a la Primera Guerra Mundial?", "Tratado de Tordesillas", "Tratado de Berlín", "Tratado de Versalles", "Tratado de Ginebra", "C", null, "A"),
            Question(24, "HUN", "HUN-5", "¿Cuál fue una consecuencia del Tratado de Versalles para Alemania?", "Expansión territorial", "Pérdida de colonias y pago de reparaciones", "Alianza con Estados Unidos", "Neutralidad política", "B", null, "A"),
            Question(25, "HUN", "HUN-5", "¿Qué arma cambió radicalmente el combate durante la Primera Guerra Mundial?", "Espada", "Catapulta", "Gas mostaza", "Ballesta", "C", null, "A"),

            Question(26, "HUN", "HUN-6", "¿Qué acontecimiento económico marcó el inicio de la Gran Depresión?", "La caída del Muro de Berlín", "El crack de la bolsa en 1929", "El Plan Marshall", "La invasión de Etiopía", "B", null, "A"),
            Question(27, "HUN", "HUN-6", "¿Qué régimen político se consolidó en Italia entre guerras?", "Comunismo", "Fascismo", "Democracia liberal", "Monarquía absoluta", "B", null, "A"),
            Question(28, "HUN", "HUN-6", "¿Qué líder implementó el New Deal en Estados Unidos?", "Theodore Roosevelt", "Woodrow Wilson", "Franklin D. Roosevelt", "Harry Truman", "C", null, "A"),
            Question(29, "HUN", "HUN-6", "¿Qué país experimentó una revolución comunista en 1917?", "Alemania", "Francia", "China", "Rusia", "D", null, "A"),
            Question(30, "HUN", "HUN-6", "¿Qué país fue invadido por Italia en 1935 como parte de su política expansionista?", "Egipto", "Etiopía", "Grecia", "Irán", "B", null, "A"),

            Question(31, "HUN", "HUN-7", "¿Qué hecho marcó el inicio de la Segunda Guerra Mundial?", "El bombardeo de Pearl Harbor", "La invasión alemana a Polonia", "La guerra civil española", "El pacto de no agresión", "B", null, "A"),
            Question(32, "HUN", "HUN-7", "¿Qué países conformaron el Eje?", "Francia, Reino Unido y EE.UU.", "Alemania, Italia y Japón", "URSS, China y EE.UU.", "Canadá, Brasil y México", "B", null, "A"),
            Question(33, "HUN", "HUN-7", "¿Qué acontecimiento provocó la entrada de Estados Unidos en la Segunda Guerra Mundial?", "El ataque a Pearl Harbor", "La invasión de Francia", "El pacto Ribbentrop-Mólotov", "El desembarco en Normandía", "A", null, "A"),
            Question(34, "HUN", "HUN-7", "¿Qué batalla representó un punto de inflexión en el frente oriental?", "Batalla de Berlín", "Batalla de Londres", "Batalla de Stalingrado", "Batalla del Mar del Coral", "C", null, "A"),
            Question(35, "HUN", "HUN-7", "¿Qué ciudad fue destruida por una bomba atómica en 1945?", "Tokio", "Osaka", "Hiroshima", "Kioto", "C", null, "A"),

            Question(36, "HUN", "HUN-8", "¿Qué bloque lideraba Estados Unidos durante la Guerra Fría?", "El bloque socialista", "El bloque capitalista", "El bloque neutral", "El bloque no alineado", "B", null, "A"),
            Question(37, "HUN", "HUN-8", "¿Qué organismo se creó en 1949 como una alianza militar liderada por EE.UU.?", "ONU", "Pacto de Varsovia", "OTAN", "UNESCO", "C", null, "A"),
            Question(38, "HUN", "HUN-8", "¿Qué evento puso al mundo al borde de una guerra nuclear en 1962?", "La guerra de Corea", "La invasión de Bahía de Cochinos", "La crisis de los misiles en Cuba", "La guerra de Vietnam", "C", null, "A"),
            Question(39, "HUN", "HUN-8", "¿Qué construcción simbolizó la división entre el Este y el Oeste?", "La Torre Eiffel", "El Canal de Suez", "El Muro de Berlín", "La Muralla China", "C", null, "A"),
            Question(40, "HUN", "HUN-8", "¿Qué doctrina estadounidense justificó la intervención en América Latina durante la Guerra Fría?", "Doctrina Truman", "Doctrina Monroe", "Doctrina Eisenhower", "Doctrina Carter", "B", null, "A"),

            Question(41, "HUN", "HUN-9", "¿Qué evento marcó el fin de la Guerra Fría?", "La caída del Muro de Berlín", "La firma del Tratado de Versalles", "El atentado a las Torres Gemelas", "La invasión de Irak", "A", null, "A"),
            Question(42, "HUN", "HUN-9", "¿Qué organización surgió como una unión económica y política en Europa?", "UNESCO", "OEA", "Unión Europea", "OTAN", "C", null, "A"),
            Question(43, "HUN", "HUN-9", "¿Qué ataque terrorista ocurrió en EE.UU. el 11 de septiembre de 2001?", "Ataque a Oklahoma", "Torres Gemelas", "Pentágono", "Pearl Harbor", "B", null, "A"),
            Question(44, "HUN", "HUN-9", "¿Qué país se convirtió en una potencia económica emergente en el siglo XXI?", "Italia", "India", "Sudáfrica", "México", "B", null, "A"),
            Question(45, "HUN", "HUN-9", "¿Qué conflicto bélico involucró la invasión de Irak en 2003?", "Guerra del Golfo", "Guerra de Vietnam", "Segunda Guerra Mundial", "Guerra de Irak", "D", null, "A"),

            // Tema: El texto (LIT-1)
            Question(id=1001, codeSubject="LIT", codeTopic="LIT-1", description="¿Qué es un texto literario?", optionA="Un texto informativo", optionB="Un texto que transmite emociones y experiencias", optionC="Un texto técnico", optionD="Un texto publicitario", answer="B", image=null, level="A"),
            Question(id=1002, codeSubject="LIT", codeTopic="LIT-1", description="¿Cuál es la función principal de un texto narrativo?", optionA="Informar datos", optionB="Describir un paisaje", optionC="Contar una historia", optionD="Persuadir al lector", answer="C", image=null, level="A"),
            Question(id=1003, codeSubject="LIT", codeTopic="LIT-1", description="¿Qué elemento no pertenece a la estructura básica de un texto?", optionA="Introducción", optionB="Cuerpo", optionC="Conclusión", optionD="Índice", answer="D", image=null, level="B"),
            Question(id=1004, codeSubject="LIT", codeTopic="LIT-1", description="¿Qué recurso literario consiste en la repetición de sonidos similares?", optionA="Metáfora", optionB="Aliteración", optionC="Hipérbole", optionD="Personificación", answer="B", image=null, level="B"),
            Question(id=1005, codeSubject="LIT", codeTopic="LIT-1", description="¿Cuál es el propósito principal del texto expositivo?", optionA="Entretener", optionB="Explicar o informar", optionC="Convencer", optionD="Describir emociones", answer="B", image=null, level="A"),

            // Tema: Géneros y corrientes literarias (LIT-2)
            Question(id=1011, codeSubject="LIT", codeTopic="LIT-2", description="¿Cuál es un género literario fundamental?", optionA="Narrativo", optionB="Periodístico", optionC="Científico", optionD="Legal", answer="A", image=null, level="A"),
            Question(id=1012, codeSubject="LIT", codeTopic="LIT-2", description="¿Qué corriente literaria se caracteriza por la objetividad y el rechazo a lo subjetivo?", optionA="Realismo", optionB="Romanticismo", optionC="Modernismo", optionD="Surrealismo", answer="A", image=null, level="B"),
            Question(id=1013, codeSubject="LIT", codeTopic="LIT-2", description="¿Cuál de estas obras pertenece al Romanticismo?", optionA="Don Quijote", optionB="Cien años de soledad", optionC="Los miserables", optionD="El canto de las sirenas", answer="C", image=null, level="B"),
            Question(id=1014, codeSubject="LIT", codeTopic="LIT-2", description="¿Qué género literario está relacionado con la representación teatral?", optionA="Poesía", optionB="Ensayo", optionC="Drama", optionD="Novela", answer="C", image=null, level="A"),
            Question(id=1015, codeSubject="LIT", codeTopic="LIT-2", description="¿Qué característica define al Modernismo?", optionA="Rechazo al simbolismo", optionB="Búsqueda de la belleza formal", optionC="Predominio del realismo social", optionD="Uso exclusivo del verso libre", answer="B", image=null, level="B"),

            // Tema: Redacción y técnicas de investigación documental (LIT-3)
            Question(id=1021, codeSubject="LIT", codeTopic="LIT-3", description="¿Qué es la redacción?", optionA="Proceso de creación y organización de textos", optionB="Lectura rápida de textos", optionC="Corrección de errores ortográficos", optionD="Recopilación de datos", answer="A", image=null, level="A"),
            Question(id=1022, codeSubject="LIT", codeTopic="LIT-3", description="¿Cuál es una técnica básica de investigación documental?", optionA="Entrevistas personales", optionB="Consulta de fuentes bibliográficas", optionC="Experimentos de laboratorio", optionD="Observación directa", answer="B", image=null, level="A"),
            Question(id=1023, codeSubject="LIT", codeTopic="LIT-3", description="¿Qué se debe evitar en la redacción académica?", optionA="Claridad y precisión", optionB="Plagio y copia textual sin citar", optionC="Uso de citas bibliográficas", optionD="Organización lógica", answer="B", image=null, level="A"),
            Question(id=1024, codeSubject="LIT", codeTopic="LIT-3", description="¿Qué elemento debe incluir una ficha bibliográfica?", optionA="Resumen del texto", optionB="Datos de la fuente consultada", optionC="Opinión personal", optionD="Título del capítulo", answer="B", image=null, level="B"),
            Question(id=1025, codeSubject="LIT", codeTopic="LIT-3", description="¿Cuál es la función de un índice en un trabajo escrito?", optionA="Presentar la conclusión", optionB="Enumerar capítulos y secciones con su ubicación", optionC="Resumir el contenido", optionD="Introducir el tema", answer="B", image=null, level="B"),

            // Tema: La Tierra, base del desarrollo del hombre (GEO-1)
            Question(id=2001, codeSubject="GEO", codeTopic="GEO-1", description="¿Cuál es la principal característica que hace a la Tierra habitable para el ser humano?", optionA="Su atmósfera y temperatura", optionB="Su cercanía al Sol", optionC="Su superficie líquida", optionD="Su composición de gases nobles", answer="A", image=null, level="A"),
            Question(id=2002, codeSubject="GEO", codeTopic="GEO-1", description="¿Qué capa de la Tierra está formada principalmente por roca sólida?", optionA="Núcleo externo", optionB="Manto", optionC="Corteza", optionD="Núcleo interno", answer="C", image=null, level="B"),
            Question(id=2003, codeSubject="GEO", codeTopic="GEO-1", description="¿Qué fenómeno explica la formación de montañas y terremotos?", optionA="Erosión", optionB="Movimiento de placas tectónicas", optionC="Sedimentación", optionD="Viento", answer="B", image=null, level="B"),
            Question(id=2004, codeSubject="GEO", codeTopic="GEO-1", description="¿Cuál es el porcentaje aproximado de agua que cubre la superficie terrestre?", optionA="30%", optionB="50%", optionC="70%", optionD="90%", answer="C", image=null, level="A"),
            Question(id=2005, codeSubject="GEO", codeTopic="GEO-1", description="¿Qué recurso natural ha sido fundamental para el desarrollo de las primeras civilizaciones humanas?", optionA="Petróleo", optionB="Agua dulce", optionC="Carbón", optionD="Gas natural", answer="B", image=null, level="A"),

            // Tema: Geografía humana: el paisaje cultural (espacio geográfico) (GEO-2)
            Question(id=2011, codeSubject="GEO", codeTopic="GEO-2", description="¿Qué estudia la geografía humana?", optionA="El relieve terrestre", optionB="La relación entre los humanos y su entorno", optionC="Los fenómenos atmosféricos", optionD="Las formaciones rocosas", answer="B", image=null, level="A"),
            Question(id=2012, codeSubject="GEO", codeTopic="GEO-2", description="¿Qué es el paisaje cultural?", optionA="Un paisaje natural sin intervención humana", optionB="El conjunto de elementos creados por la actividad humana en un espacio", optionC="Una zona protegida por ley", optionD="Un área exclusivamente rural", answer="B", image=null, level="A"),
            Question(id=2013, codeSubject="GEO", codeTopic="GEO-2", description="¿Cuál de los siguientes es un ejemplo de paisaje cultural?", optionA="Selva tropical", optionB="Ciudad histórica", optionC="Desierto", optionD="Glaciar", answer="B", image=null, level="A"),
            Question(id=2014, codeSubject="GEO", codeTopic="GEO-2", description="¿Qué factores influyen en la configuración del espacio geográfico?", optionA="Solo factores naturales", optionB="Factores económicos, sociales y naturales", optionC="Únicamente la política", optionD="Solo la tecnología", answer="B", image=null, level="B"),
            Question(id=2015, codeSubject="GEO", codeTopic="GEO-2", description="¿Qué herramienta es fundamental para el estudio del espacio geográfico?", optionA="Mapa", optionB="Microscopio", optionC="Telescopio", optionD="Cámara fotográfica", answer="A", image=null, level="A"),

            // Tema: Lógica (FIL-1)
            Question(id=3001, codeSubject="FIL", codeTopic="FIL-1", description="¿Qué estudia la lógica en filosofía?", optionA="Las leyes del pensamiento correcto", optionB="La ética", optionC="La historia de la filosofía", optionD="La estética", answer="A", image=null, level="B"),
            Question(id=3002, codeSubject="FIL", codeTopic="FIL-1", description="¿Cuál es un ejemplo de argumento válido?", optionA="Si llueve, la calle está mojada. Está lloviendo. Por lo tanto, la calle está mojada.", optionB="La calle está mojada, por lo tanto llueve.", optionC="Si estudio, aprobaré. No aprobé, entonces no estudié.", optionD="Si estudio, aprobaré. No aprobé, por lo tanto estudiaré.", answer="A", image=null, level="B"),
            Question(id=3003, codeSubject="FIL", codeTopic="FIL-1", description="¿Qué es una falacia lógica?", optionA="Un razonamiento correcto", optionB="Un error en el razonamiento", optionC="Una teoría ética", optionD="Un método científico", answer="B", image=null, level="B"),
            Question(id=3004, codeSubject="FIL", codeTopic="FIL-1", description="¿Qué tipo de lógica estudia las proposiciones y sus relaciones?", optionA="Lógica simbólica", optionB="Lógica inductiva", optionC="Lógica formal", optionD="Lógica deductiva", answer="C", image=null, level="C"),
            Question(id=3005, codeSubject="FIL", codeTopic="FIL-1", description="¿Cuál es el principio de no contradicción?", optionA="Una proposición puede ser verdadera y falsa al mismo tiempo", optionB="Una proposición no puede ser verdadera y falsa simultáneamente", optionC="Todo es relativo", optionD="Nada existe", answer="B", image=null, level="B"),

            // Tema: Ética (FIL-2)
            Question(id=3011, codeSubject="FIL", codeTopic="FIL-2", description="¿Qué estudia la ética?", optionA="La naturaleza del ser", optionB="Los principios del comportamiento moral", optionC="Las leyes físicas", optionD="La estructura del lenguaje", answer="B", image=null, level="A"),
            Question(id=3012, codeSubject="FIL", codeTopic="FIL-2", description="¿Cuál filósofo es conocido por la ética del deber?", optionA="Aristóteles", optionB="Immanuel Kant", optionC="John Stuart Mill", optionD="Friedrich Nietzsche", answer="B", image=null, level="B"),
            Question(id=3013, codeSubject="FIL", codeTopic="FIL-2", description="¿Qué significa el utilitarismo?", optionA="Buscar el máximo bienestar para el mayor número", optionB="Obedecer normas sin cuestionar", optionC="Priorizar el deber individual", optionD="Negar la existencia del bien y el mal", answer="A", image=null, level="B"),
            Question(id=3014, codeSubject="FIL", codeTopic="FIL-2", description="¿Qué es la ética aplicada?", optionA="Estudio de problemas morales concretos", optionB="Teoría general de la moral", optionC="Estudio de lógica formal", optionD="Análisis de textos antiguos", answer="A", image=null, level="B"),
            Question(id=3015, codeSubject="FIL", codeTopic="FIL-2", description="¿Cuál es un valor ético fundamental?", optionA="Verdad", optionB="Belleza", optionC="Potencia", optionD="Cantidad", answer="A", image=null, level="A"),

            // Tema: Disciplinas y problemas de la Filosofía (FIL-3)
            Question(id=3021, codeSubject="FIL", codeTopic="FIL-3", description="¿Cuál es una disciplina principal de la filosofía?", optionA="Matemáticas", optionB="Metafísica", optionC="Biología", optionD="Psicología", answer="B", image=null, level="A"),
            Question(id=3022, codeSubject="FIL", codeTopic="FIL-3", description="¿Qué problema aborda la epistemología?", optionA="La naturaleza del conocimiento", optionB="La estructura del universo", optionC="Las leyes físicas", optionD="Los sistemas económicos", answer="A", image=null, level="B"),
            Question(id=3023, codeSubject="FIL", codeTopic="FIL-3", description="¿Cuál es el objeto de estudio de la estética?", optionA="La belleza y el arte", optionB="La lógica", optionC="La ética", optionD="La política", answer="A", image=null, level="A"),
            Question(id=3024, codeSubject="FIL", codeTopic="FIL-3", description="¿Qué filósofo es conocido por cuestionar todo con la duda metódica?", optionA="Sócrates", optionB="Descartes", optionC="Platón", optionD="Aristóteles", answer="B", image=null, level="B"),
            Question(id=3025, codeSubject="FIL", codeTopic="FIL-3", description="¿Qué disciplina filosófica estudia el ser y la existencia?", optionA="Ontología", optionB="Lógica", optionC="Epistemología", optionD="Ética", answer="A", image=null, level="B"),


            Question(id=4001, codeSubject="FIS", codeTopic="FIS-1", description="¿Qué es la velocidad en cinemática?", optionA="La rapidez con dirección", optionB="La distancia recorrida", optionC="El tiempo empleado", optionD="La aceleración media", answer="A", image=null, level="B"),
            Question(id=4002, codeSubject="FIS", codeTopic="FIS-1", description="¿Cuál es la unidad de medida de la aceleración?", optionA="Metro por segundo", optionB="Metro por segundo cuadrado", optionC="Segundo", optionD="Newton", answer="B", image=null, level="A"),
            Question(id=4003, codeSubject="FIS", codeTopic="FIS-1", description="¿Qué representa un gráfico de posición vs tiempo?", optionA="La velocidad", optionB="La aceleración", optionC="La posición en función del tiempo", optionD="El desplazamiento total", answer="C", image=null, level="B"),
            Question(id=4004, codeSubject="FIS", codeTopic="FIS-1", description="¿Qué es la aceleración?", optionA="Cambio de posición en el tiempo", optionB="Cambio de velocidad en el tiempo", optionC="Distancia total recorrida", optionD="Rapidez constante", answer="B", image=null, level="B"),
            Question(id=4005, codeSubject="FIS", codeTopic="FIS-1", description="¿Qué es un movimiento rectilíneo uniforme?", optionA="Movimiento con aceleración constante", optionB="Movimiento con velocidad constante en línea recta", optionC="Movimiento circular", optionD="Movimiento oscilatorio", answer="B", image=null, level="A"),

            Question(id=4011, codeSubject="FIS", codeTopic="FIS-2", description="¿Qué afirma la primera ley de Newton o ley de inercia?", optionA="La fuerza es proporcional a la aceleración", optionB="Un objeto en reposo o en movimiento rectilíneo uniforme permanece así a menos que una fuerza externa actúe", optionC="Para cada acción hay una reacción igual y opuesta", optionD="La gravedad actúa siempre hacia abajo", answer="B", image=null, level="A"),
            Question(id=4012, codeSubject="FIS", codeTopic="FIS-2", description="¿Cuál es la fórmula que representa la segunda ley de Newton?", optionA="F = m/a", optionB="F = m * a", optionC="F = m + a", optionD="F = m - a", answer="B", image=null, level="B"),
            Question(id=4013, codeSubject="FIS", codeTopic="FIS-2", description="¿Qué tipo de fuerza mantiene a los planetas en órbita?", optionA="Fuerza electromagnética", optionB="Fuerza de gravedad", optionC="Fuerza nuclear fuerte", optionD="Fuerza de fricción", answer="B", image=null, level="B"),
            Question(id=4014, codeSubject="FIS", codeTopic="FIS-2", description="¿Qué ley de Newton explica la acción y reacción?", optionA="Primera ley", optionB="Segunda ley", optionC="Tercera ley", optionD="Ley de gravitación universal", answer="C", image=null, level="A"),
            Question(id=4015, codeSubject="FIS", codeTopic="FIS-2", description="¿Qué es la gravedad según Newton?", optionA="Una fuerza que atrae los objetos con masa", optionB="Una fuerza que repele los objetos", optionC="Una forma de energía", optionD="Una propiedad del tiempo", answer="A", image=null, level="B"),

            Question(id=4021, codeSubject="FIS", codeTopic="FIS-3", description="¿Qué es el trabajo en física?", optionA="Fuerza por desplazamiento", optionB="Energía sin desplazamiento", optionC="Velocidad multiplicada por tiempo", optionD="Masa por aceleración", answer="A", image=null, level="B"),
            Question(id=4022, codeSubject="FIS", codeTopic="FIS-3", description="¿Cuál es la unidad de trabajo en el Sistema Internacional?", optionA="Newton", optionB="Joule", optionC="Watt", optionD="Pascal", answer="B", image=null, level="A"),
            Question(id=4023, codeSubject="FIS", codeTopic="FIS-3", description="¿Qué ley establece la conservación de la energía?", optionA="Primera ley de Newton", optionB="Ley de gravitación universal", optionC="Primera ley de la termodinámica", optionD="Ley de conservación de la energía", answer="D", image=null, level="B"),
            Question(id=4024, codeSubject="FIS", codeTopic="FIS-3", description="¿Qué es la energía cinética?", optionA="Energía almacenada en objetos en reposo", optionB="Energía del movimiento", optionC="Energía térmica", optionD="Energía eléctrica", answer="B", image=null, level="B"),
            Question(id=4025, codeSubject="FIS", codeTopic="FIS-3", description="¿Qué relación existe entre trabajo y energía?", optionA="Son conceptos independientes", optionB="El trabajo realizado sobre un objeto cambia su energía", optionC="El trabajo es la fuerza sin desplazamiento", optionD="La energía es siempre constante", answer="B", image=null, level="C"),

            Question(id=4031, codeSubject="FIS", codeTopic="FIS-4", description="¿Qué estudia la termodinámica?", optionA="El movimiento de los cuerpos", optionB="Las transformaciones de la energía y el calor", optionC="La velocidad", optionD="La luz", answer="B", image=null, level="B"),
            Question(id=4032, codeSubject="FIS", codeTopic="FIS-4", description="¿Cuál es la ley cero de la termodinámica?", optionA="Si dos sistemas están en equilibrio térmico con un tercero, están en equilibrio entre sí", optionB="La energía se conserva", optionC="El calor fluye de frío a caliente", optionD="La entropía siempre disminuye", answer="A", image=null, level="C"),
            Question(id=4033, codeSubject="FIS", codeTopic="FIS-4", description="¿Qué es la entropía?", optionA="Una medida del desorden en un sistema", optionB="Energía almacenada", optionC="La energía térmica", optionD="Trabajo realizado", answer="A", image=null, level="C"),
            Question(id=4034, codeSubject="FIS", codeTopic="FIS-4", description="¿Qué indica la primera ley de la termodinámica?", optionA="La energía no se crea ni se destruye", optionB="El calor siempre fluye de caliente a frío", optionC="La energía se pierde", optionD="La presión aumenta con la temperatura", answer="A", image=null, level="B"),
            Question(id=4035, codeSubject="FIS", codeTopic="FIS-4", description="¿Cuál es una aplicación práctica de la termodinámica?", optionA="El motor de combustión interna", optionB="La luz visible", optionC="El sonido", optionD="La electricidad estática", answer="A", image=null, level="B"),

            Question(id=4041, codeSubject="FIS", codeTopic="FIS-5", description="¿Qué es una onda mecánica?", optionA="Una perturbación que se propaga en un medio", optionB="Una onda que no necesita medio", optionC="Una onda electromagnética", optionD="Una onda de luz", answer="A", image=null, level="B"),
            Question(id=4042, codeSubject="FIS", codeTopic="FIS-5", description="¿Cuál es la característica principal de una onda transversal?", optionA="Las partículas se mueven en la misma dirección que la onda", optionB="Las partículas se mueven perpendicularmente a la dirección de propagación", optionC="No tiene frecuencia", optionD="Viaja solo en líquidos", answer="B", image=null, level="B"),
            Question(id=4043, codeSubject="FIS", codeTopic="FIS-5", description="¿Qué propiedad de la onda determina su tono?", optionA="Amplitud", optionB="Frecuencia", optionC="Velocidad", optionD="Longitud de onda", answer="B", image=null, level="B"),
            Question(id=4044, codeSubject="FIS", codeTopic="FIS-5", description="¿Qué es la interferencia de ondas?", optionA="La superposición de dos o más ondas", optionB="La reflexión de una onda", optionC="La absorción de energía", optionD="La dispersión de luz", answer="A", image=null, level="C"),
            Question(id=4045, codeSubject="FIS", codeTopic="FIS-5", description="¿Cuál es la velocidad aproximada del sonido en el aire?", optionA="340 m/s", optionB="3,000 m/s", optionC="150 m/s", optionD="1,000 m/s", answer="A", image=null, level="B"),

            Question(id=4051, codeSubject="FIS", codeTopic="FIS-6", description="¿Qué estudia el electromagnetismo?", optionA="La interacción entre cargas eléctricas y campos magnéticos", optionB="El movimiento de los cuerpos", optionC="La propagación de ondas sonoras", optionD="La termodinámica", answer="A", image=null, level="B"),
            Question(id=4052, codeSubject="FIS", codeTopic="FIS-6", description="¿Cuál es la unidad de carga eléctrica?", optionA="Coulomb", optionB="Voltio", optionC="Amperio", optionD="Ohmio", answer="A", image=null, level="A"),
            Question(id=4053, codeSubject="FIS", codeTopic="FIS-6", description="¿Qué representa la Ley de Ohm?", optionA="V = I * R", optionB="F = m * a", optionC="E = mc²", optionD="P = W / t", answer="A", image=null, level="B"),
            Question(id=4054, codeSubject="FIS", codeTopic="FIS-6", description="¿Qué es un campo magnético?", optionA="Una región donde una fuerza magnética es detectable", optionB="Una partícula subatómica", optionC="Un tipo de energía", optionD="Un tipo de radiación", answer="A", image=null, level="B"),
            Question(id=4055, codeSubject="FIS", codeTopic="FIS-6", description="¿Qué partículas son responsables de la corriente eléctrica?", optionA="Protones", optionB="Neutrones", optionC="Electrones", optionD="Fotones", answer="C", image=null, level="B"),

            // Temas básicos (QUI-1)
            Question(id=5001, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué es un átomo?", optionA="La partícula más pequeña de un elemento que conserva sus propiedades", optionB="Una molécula compleja", optionC="Un compuesto", optionD="Una mezcla homogénea", answer="A", image=null, level="B"),
            Question(id=5002, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué partículas subatómicas conforman un átomo?", optionA="Protones, neutrones y electrones", optionB="Protones y neutrinos", optionC="Electrones y fotones", optionD="Neutrones y positrones", answer="A", image=null, level="A"),
            Question(id=5003, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué es un elemento químico?", optionA="Una sustancia formada por un solo tipo de átomo", optionB="Una mezcla de sustancias", optionC="Un compuesto químico", optionD="Un isótopo", answer="A", image=null, level="B"),
            Question(id=5004, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué indica el número atómico de un elemento?", optionA="Número de protones en el núcleo", optionB="Número de neutrones", optionC="Número de electrones libres", optionD="Número de átomos en una molécula", answer="A", image=null, level="B"),
            Question(id=5005, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué es un isótopo?", optionA="Átomos del mismo elemento con diferente número de neutrones", optionB="Un compuesto químico", optionC="Una molécula", optionD="Una mezcla", answer="A", image=null, level="C"),

// Agua (QUI-2)
            Question(id=5011, codeSubject="QUI", codeTopic="QUI-2", description="¿Cuál es la fórmula molecular del agua?", optionA="H2O", optionB="CO2", optionC="O2", optionD="NaCl", answer="A", image=null, level="A"),
            Question(id=5012, codeSubject="QUI", codeTopic="QUI-2", description="¿Qué propiedad del agua permite que sea un buen solvente?", optionA="Su polaridad", optionB="Su temperatura alta", optionC="Su color", optionD="Su presión", answer="A", image=null, level="B"),
            Question(id=5013, codeSubject="QUI", codeTopic="QUI-2", description="¿Qué es la cohesión en el agua?", optionA="Atracción entre moléculas de agua", optionB="Atracción entre agua y otras sustancias", optionC="Evaporación del agua", optionD="Disolución de sales", answer="A", image=null, level="B"),
            Question(id=5014, codeSubject="QUI", codeTopic="QUI-2", description="¿Cuál es el punto de ebullición del agua a presión atmosférica?", optionA="100 °C", optionB="0 °C", optionC="50 °C", optionD="212 °C", answer="A", image=null, level="A"),
            Question(id=5015, codeSubject="QUI", codeTopic="QUI-2", description="¿Qué fenómeno explica que el agua suba por tubos delgados?", optionA="Capilaridad", optionB="Presión atmosférica", optionC="Evaporación", optionD="Condensación", answer="A", image=null, level="B"),

// Aire (QUI-3)
            Question(id=5021, codeSubject="QUI", codeTopic="QUI-3", description="¿De qué gases está compuesto principalmente el aire?", optionA="Nitrógeno y oxígeno", optionB="Dióxido de carbono y argón", optionC="Helio y hidrógeno", optionD="Ozono y vapor de agua", answer="A", image=null, level="B"),
            Question(id=5022, codeSubject="QUI", codeTopic="QUI-3", description="¿Qué porcentaje de oxígeno contiene el aire aproximadamente?", optionA="21%", optionB="78%", optionC="1%", optionD="50%", answer="A", image=null, level="A"),
            Question(id=5023, codeSubject="QUI", codeTopic="QUI-3", description="¿Qué es la presión atmosférica?", optionA="El peso del aire sobre la superficie terrestre", optionB="La fuerza del viento", optionC="La temperatura del aire", optionD="La humedad relativa", answer="A", image=null, level="B"),
            Question(id=5024, codeSubject="QUI", codeTopic="QUI-3", description="¿Qué instrumento se usa para medir la presión atmosférica?", optionA="Barómetro", optionB="Termómetro", optionC="Anemómetro", optionD="Higrómetro", answer="A", image=null, level="B"),
            Question(id=5025, codeSubject="QUI", codeTopic="QUI-3", description="¿Qué es la composición del aire seco?", optionA="Principalmente nitrógeno, oxígeno y argón", optionB="Solo oxígeno", optionC="Solo dióxido de carbono", optionD="Solo vapor de agua", answer="A", image=null, level="C"),

            // Alimentos (QUI-4)
            Question(id=5031, codeSubject="QUI", codeTopic="QUI-4", description="¿Qué macronutriente proporciona la mayor cantidad de energía?", optionA="Grasas", optionB="Carbohidratos", optionC="Proteínas", optionD="Vitaminas", answer="A", image=null, level="B"),
            Question(id=5032, codeSubject="QUI", codeTopic="QUI-4", description="¿Qué elemento químico es fundamental en las proteínas?", optionA="Nitrógeno", optionB="Carbono", optionC="Oxígeno", optionD="Hidrógeno", answer="A", image=null, level="A"),
            Question(id=5033, codeSubject="QUI", codeTopic="QUI-4", description="¿Cuál es el papel del agua en los alimentos?", optionA="Disolvente y medio para reacciones químicas", optionB="Fuente de energía", optionC="Protector solar", optionD="Vitaminas", answer="A", image=null, level="B"),
            Question(id=5034, codeSubject="QUI", codeTopic="QUI-4", description="¿Qué vitaminas son solubles en agua?", optionA="Vitaminas del complejo B y vitamina C", optionB="Vitaminas A y D", optionC="Vitaminas E y K", optionD="Vitaminas liposolubles", answer="A", image=null, level="C"),
            Question(id=5035, codeSubject="QUI", codeTopic="QUI-4", description="¿Qué reacción química ocurre en la digestión?", optionA="Hidrólisis", optionB="Oxidación", optionC="Condensación", optionD="Sublimación", answer="A", image=null, level="B"),

            // La energía y las reacciones químicas (QUI-5)
            Question(id=5041, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué es una reacción química?", optionA="Proceso donde se transforman sustancias en otras", optionB="Mezcla física", optionC="Cambio de estado", optionD="Cambio de temperatura", answer="A", image=null, level="B"),
            Question(id=5042, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué es la energía de activación?", optionA="Energía mínima para iniciar una reacción química", optionB="Energía liberada en la reacción", optionC="Energía almacenada en enlaces", optionD="Energía del ambiente", answer="A", image=null, level="C"),
            Question(id=5043, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué es una reacción exotérmica?", optionA="Reacción que libera calor", optionB="Reacción que absorbe calor", optionC="Reacción que no cambia temperatura", optionD="Reacción que produce luz", answer="A", image=null, level="B"),
            Question(id=5044, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué es una reacción endotérmica?", optionA="Reacción que absorbe energía", optionB="Reacción que libera energía", optionC="Reacción sin cambio energético", optionD="Reacción explosiva", answer="A", image=null, level="B"),
            Question(id=5045, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué ley química establece que la masa se conserva en una reacción?", optionA="Ley de conservación de la masa", optionB="Ley de conservación de la energía", optionC="Ley de Boyle", optionD="Ley de Avogadro", answer="A", image=null, level="A"),

            // Química del carbono (QUI-6)
            Question(id=5051, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué es un hidrocarburo?", optionA="Compuesto formado por carbono e hidrógeno", optionB="Compuesto formado por oxígeno e hidrógeno", optionC="Compuesto inorgánico", optionD="Elemento puro", answer="A", image=null, level="B"),
            Question(id=5052, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué tipo de enlace predomina en los compuestos de carbono?", optionA="Enlace covalente", optionB="Enlace iónico", optionC="Enlace metálico", optionD="Enlace de hidrógeno", answer="A", image=null, level="A"),
            Question(id=5053, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué es un isómero en química orgánica?", optionA="Compuestos con misma fórmula molecular pero diferente estructura", optionB="Compuestos con diferente fórmula", optionC="Mezcla de sustancias", optionD="Moléculas idénticas", answer="A", image=null, level="C"),
            Question(id=5054, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué es un alqueno?", optionA="Hidrocarburo con al menos un doble enlace carbono-carbono", optionB="Hidrocarburo saturado", optionC="Alcohol", optionD="Ácido carboxílico", answer="A", image=null, level="B"),
            Question(id=5055, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué es la reacción de combustión?", optionA="Reacción donde un compuesto reacciona con oxígeno liberando energía", optionB="Reacción de mezcla", optionC="Reacción de descomposición", optionD="Reacción de neutralización", answer="A", image=null, level="B"),
            )
    }

    fun getMathQuestions(): List<Question> {
        return listOf(
            Question(1, "MAT", "MAT-1", "\\text{¿Cuál es el resultado de } (-3)^2?", "9", "-9", "6", "0", "A", null, "A"),
            Question(2, "MAT", "MAT-1", "\\text{Simplifica: } 2x + 3x - 5", "5x - 5", "x - 5", "5x + 5", "5x", "A", null, "A"),
            Question(3, "MAT", "MAT-1", "\\text{Resuelve: } (2 + 3i) + (4 - 5i)", "6 - 2i", "2 - 2i", "6 + 8i", "8 - 2i", "A", null, "B"),
            Question(4, "MAT", "MAT-1", "\\text{Multiplica: } (2x)(-3x^2)", "-6x^3", "-6x^2", "5x^3", "-5x^2", "A", null, "A"),
            Question(5, "MAT", "MAT-1", "\\text{¿Cuál es el resultado de } \\sqrt{-49}?", "7", "-7", "7i", "No tiene solución", "C", null, "B"),
            Question(6, "MAT", "MAT-1", "\\text{Factoriza: } x^2 - 9", "(x + 3)(x - 3)", "(x - 9)(x + 1)", "(x - 3)^2", "No se puede", "A", null, "A"),
            Question(7, "MAT", "MAT-1", "\\text{Resuelve: } 5x - 2 = 3x + 6", "x = 4", "x = -4", "x = 1", "x = 2", "A", null, "A"),
            Question(8, "MAT", "MAT-1", "\\text{Multiplica: } (1 + 2i)(1 - 2i)", "1 - 4i^2", "1 + 4", "5", "3", "C", null, "B"),
            Question(9, "MAT", "MAT-1", "\\text{¿Cuál es el inverso aditivo de } -5?", "5", "-5", "0", "1", "A", null, "A"),
            Question(10, "MAT", "MAT-1", "\\text{Simplifica: } (x^2)^3", "x^6", "x^5", "x^3", "x^8", "A", null, "A"),

            Question(1001, "MAT", "MAT-2", "\\text{¿Cuál es el resultado de } (a+b)^2?", "a^2 + 2ab + b^2", "a^2 + b^2", "a^2 - 2ab + b^2", "2a + 2b", "A", null, "B"),
            Question(1002, "MAT", "MAT-2", "\\text{Factoriza } x^2 - 9", "(x-3)(x+3)", "(x-9)(x+1)", "(x-3)^2", "(x+9)(x-1)", "A", null, "B"),
            Question(1003, "MAT", "MAT-2", "\\text{¿Cuál es el desarrollo de } (2x - 5)^2?", "4x^2 - 20x + 25", "4x^2 + 20x + 25", "4x^2 - 10x - 25", "2x^2 - 5", "A", null, "C"),
            Question(1004, "MAT", "MAT-2", "\\text{Factoriza } x^2 + 6x + 9", "(x+3)^2", "(x+9)(x-3)", "(x-3)^2", "(x+6)(x+3)", "A", null, "B"),
            Question(1005, "MAT", "MAT-2", "\\text{¿Cuál es el producto notable de } (a-b)(a+b)?", "a^2 - b^2", "a^2 + b^2", "a^2 - 2ab + b^2", "a^2 + 2ab + b^2", "A", null, "B"),

            Question(2001, "MAT", "MAT-3", "\\text{¿Cuál es la solución de la ecuación } 2x + 5 = 13?", "4", "3", "5", "6", "A", null, "B"),
            Question(2002, "MAT", "MAT-3", "\\text{Resuelve } x^2 - 9 = 0", "x = \\pm 3", "x = 3", "x = -3", "No tiene solución", "A", null, "B"),
            Question(2003, "MAT", "MAT-3", "\\text{Encuentra } x \\text{ en } 3(x - 2) = 9", "x = 5", "x = 3", "x = 6", "x = 4", "A", null, "C"),
            Question(2004, "MAT", "MAT-3", "\\text{¿Cuál es el valor de } x \\text{ en } \\frac{x}{4} + 3 = 7?", "16", "12", "10", "8", "A", null, "B"),
            Question(2005, "MAT", "MAT-3", "\\text{Resuelve la ecuación cuadrática } x^2 + 4x + 4 = 0", "x = -2", "x = 2", "x = 0", "x = \\pm 2", "A", null, "B"),

            Question(3001, "MAT", "MAT-4", "\\text{Resuelve la desigualdad } 2x - 5 > 3", "x > 4", "x < 4", "x > -4", "x < -4", "A", null, "B"),
            Question(3002, "MAT", "MAT-4", "\\text{¿Cuál es el conjunto solución de } x^2 - 4x \\leq 0?", "\\{x | 0 \\leq x \\leq 4\\}", "\\{x | x \\leq 0 \\text{ o } x \\geq 4\\}", "\\{x | x \\geq 0\\}", "\\{x | x \\leq 4\\}", "A", null, "B"),
            Question(3003, "MAT", "MAT-4", "\\text{Resuelve la desigualdad } \\frac{3x + 1}{2} < 4", "x < \\frac{7}{3}", "x > \\frac{7}{3}", "x < 5", "x > 5", "A", null, "B"),
            Question(3004, "MAT", "MAT-4", "\\text{¿Cuál es la solución de } -2x + 7 \\geq 1?", "x \\leq 3", "x \\geq 3", "x \\leq -3", "x \\geq -3", "A", null, "B"),
            Question(3005, "MAT", "MAT-4", "\\text{Determina el conjunto solución de } |x - 2| < 5", "\\{-3 < x < 7\\}", "\\{x < -3 \\text{ o } x > 7\\}", "\\{-7 < x < 3\\}", "\\{x < 7\\}", "A", null, "B"),

            Question(4001, "MAT", "MAT-5", "\\text{Resuelve el sistema: } \\begin{cases} 2x + y = 5 \\\\ x - y = 1 \\end{cases}", "(x,y) = (2,1)", "(x,y) = (1,2)", "(x,y) = (3,-1)", "(x,y) = (0,5)", "A", null, "B"),
            Question(4002, "MAT", "MAT-5", "\\text{¿Cuál es la solución del sistema } \\begin{cases} 3x - 2y = 4 \\\\ 5x + y = 11 \\end{cases}?", "(x,y) = (2,1)", "(x,y) = (1,2)", "(x,y) = (3,1)", "(x,y) = (0,4)", "A", null, "B"),
            Question(4003, "MAT", "MAT-5", "\\text{Encuentra } x \\text{ e } y \\text{ en } \\begin{cases} x + y = 7 \\\\ 2x - y = 4 \\end{cases}", "(x,y) = (3,4)", "(x,y) = (4,3)", "(x,y) = (2,5)", "(x,y) = (5,2)", "B", null, "B"),
            Question(4004, "MAT", "MAT-5", "\\text{Resuelve el sistema } \\begin{cases} 4x + 3y = 24 \\\\ x - 2y = -3 \\end{cases}", "(x,y) = (3,4)", "(x,y) = (2,4)", "(x,y) = (4,3)", "(x,y) = (5,1)", "A", null, "B"),
            Question(4005, "MAT", "MAT-5", "\\text{¿Cuál es la solución del sistema } \\begin{cases} 6x + y = 9 \\\\ 2x - 3y = 4 \\end{cases}?", "(x,y) = (1,3)", "(x,y) = (2,1)", "(x,y) = (0,9)", "(x,y) = (3,1)", "D", null, "B"),

            Question(6001, "MAT", "MAT-6", "\\text{¿Cuál es el dominio de la función } f(x) = \\frac{1}{x-3}?", "\\{x \\in \\mathbb{R} \\mid x \\neq 3\\}", "\\{x \\in \\mathbb{R} \\mid x \\neq 0\\}", "\\{x \\in \\mathbb{R} \\mid x > 3\\}", "\\{x \\in \\mathbb{R}\\}", "A", null, "B"),
            Question(6002, "MAT", "MAT-6", "\\text{Si } f(x) = 2x^2 - 3x + 1, \\text{calcula } f(2).", "3", "5", "7", "9", "C", null, "B"),
            Question(6003, "MAT", "MAT-6", "\\text{¿Cuál es la imagen de } x = -1 \\text{ para } f(x) = x^3 + 2x?", "-1", "-3", "1", "3", "B", null, "B"),
            Question(6004, "MAT", "MAT-6", "\\text{La función } f(x) = \\sqrt{x-1} \\text{ tiene dominio }:", "\\{x \\in \\mathbb{R} \\mid x \\geq 1\\}", "\\{x \\in \\mathbb{R} \\mid x > 1\\}", "\\{x \\in \\mathbb{R} \\mid x \\leq 1\\}", "\\{x \\in \\mathbb{R} \\mid x < 1\\}", "A", null, "B"),
            Question(6005, "MAT", "MAT-6", "\\text{Dada la función } f(x) = 3x - 5, \\text{ ¿cuál es } f^{-1}(x)?", "f^{-1}(x) = \\frac{x+5}{3}", "f^{-1}(x) = 3x + 5", "f^{-1}(x) = \\frac{3}{x-5}", "f^{-1}(x) = \\frac{x-5}{3}", "A", null, "B"),

            Question(7001, "MAT", "MAT-7", "\\text{¿Cuál es el valor de } \\sin 30^\\circ?", "0", "0.5", "\\frac{\\sqrt{3}}{2}", "1", "B", null, "B"),
            Question(7002, "MAT", "MAT-7", "\\text{En un triángulo rectángulo, si el cateto opuesto mide 3 y el adyacente 4, ¿cuánto mide la hipotenusa?}", "5", "6", "7", "8", "A", null, "B"),
            Question(7003, "MAT", "MAT-7", "\\text{El coseno de } 0^\\circ \\text{ es }:", "0", "0.5", "1", "-1", "C", null, "B"),
            Question(7004, "MAT", "MAT-7", "\\text{¿Cuál es el valor de } \\tan 45^\\circ?", "0", "1", "\\sqrt{3}", "\\frac{1}{\\sqrt{3}}", "B", null, "B"),
            Question(7005, "MAT", "MAT-7", "\\text{Si } \\sin \\theta = \\frac{3}{5}, \\text{ y } \\theta \\text{ está en el primer cuadrante, ¿cuál es } \\cos \\theta?", "\\frac{4}{5}", "\\frac{3}{5}", "\\frac{5}{3}", "\\frac{1}{2}", "A", null, "B"),

            Question(8001, "MAT", "MAT-8", "\\text{La función } y = \\sin x \\text{ tiene periodo }:", "\\pi", "2\\pi", "\\frac{\\pi}{2}", "4\\pi", "B", null, "B"),
            Question(8002, "MAT", "MAT-8", "\\text{La función } y = \\cos x \\text{ es simétrica respecto al eje }:", "x", "y", "origen", "ninguno", "B", null, "B"),
            Question(8003, "MAT", "MAT-8", "\\text{El valor máximo de } y = \\tan x \\text{ es }:", "\\infty", "1", "0", "No tiene máximo", "D", null, "B"),
            Question(8004, "MAT", "MAT-8", "\\text{¿Cuál es la derivada de } f(x) = \\sin x?", "\\cos x", "-\\sin x", "-\\cos x", "\\sin x", "A", null, "B"),
            Question(8005, "MAT", "MAT-8", "\\text{El valor de } \\sin 90^\\circ \\text{ es }:", "0", "1", "-1", "\\frac{\\sqrt{2}}{2}", "B", null, "B"),

            Question(9001, "MAT", "MAT-9", "\\text{¿Cuál es el valor de } \\log_{10} 1000?", "1", "2", "3", "4", "C", null, "B"),
            Question(9002, "MAT", "MAT-9", "\\text{Si } f(x) = e^x, \\text{ entonces } f'(x) = ?", "e^x", "x e^{x-1}", "x e^x", "e", "A", null, "B"),
            Question(9003, "MAT", "MAT-9", "\\text{¿Cuál es la solución de } e^{2x} = 1?", "x = 0", "x = 1", "x = \\frac{1}{2}", "x = -1", "A", null, "B"),
            Question(9004, "MAT", "MAT-9", "\\text{Si } \\log_a b = 2 \\text{ y } \\log_a c = 3, \\text{ ¿cuánto vale } \\log_a (b c)?", "5", "6", "1", "\\frac{5}{6}", "A", null, "B"),
            Question(9005, "MAT", "MAT-9", "\\text{¿Cuál es la propiedad correcta del logaritmo?}", "\\log (xy) = \\log x + \\log y", "\\log (x + y) = \\log x + \\log y", "\\log (x^y) = y + \\log x", "\\log \\left(\\frac{x}{y}\\right) = \\log x \\cdot \\log y", "A", null, "B"),

            Question(10001, "MAT", "MAT-10", "\\text{¿Cuál es la pendiente de la recta } y = 3x + 5?", "3", "5", "-3", "0", "A", null, "B"),
            Question(10002, "MAT", "MAT-10", "\\text{Ecuación de la recta que pasa por } (1, 2) \\text{ y tiene pendiente } 4:", "y = 4x - 2", "y = 4x + 2", "y = 4x - 4", "y = 4x + 6", "A", null, "B"),
            Question(10003, "MAT", "MAT-10", "\\text{La forma general de la ecuación de la recta es:}", "Ax + By + C = 0", "y = mx + b", "x = y + b", "y = Ax + C", "A", null, "B"),
            Question(10004, "MAT", "MAT-10", "\\text{Si dos rectas son paralelas, sus pendientes:}", "Son iguales", "Son inversas", "Son negativas", "No tienen pendiente", "A", null, "B"),
            Question(10005, "MAT", "MAT-10", "\\text{¿Cuál es la pendiente de la recta perpendicular a } y = \\frac{1}{2}x + 3?", "-2", "\\frac{1}{2}", "2", "-\\frac{1}{2}", "A", null, "B"),

            Question(11001, "MAT", "MAT-11", "\\text{¿Cuál es la ecuación general de una circunferencia con centro en } (h, k) \\text{ y radio } r?", "(x - h)^2 + (y - k)^2 = r^2", "x^2 + y^2 = r", "(x + h)^2 + (y + k)^2 = r^2", "x^2 + y^2 = r^2", "A", null, "B"),
            Question(11002, "MAT", "MAT-11", "\\text{¿Cuál es el centro y radio de la circunferencia } x^2 + y^2 - 4x + 6y - 12 = 0?", "Centro (2, -3), radio 5", "Centro (-2, 3), radio 5", "Centro (2, 3), radio 6", "Centro (-2, -3), radio 6", "A", null, "B"),
            Question(11003, "MAT", "MAT-11", "\\text{¿Qué representa la ecuación } (x - 1)^2 + (y + 2)^2 = 9?", "Una circunferencia con centro en (1, -2) y radio 3", "Una circunferencia con centro en (-1, 2) y radio 9", "Una elipse con centro en (1, -2)", "Una parábola con foco en (1, -2)", "A", null, "B"),
            Question(11004, "MAT", "MAT-11", "\\text{¿Cómo se obtiene el radio } r \\text{ de la circunferencia si se conoce la ecuación } (x - h)^2 + (y - k)^2 = r^2?", "Es la raíz cuadrada del término independiente", "Es el coeficiente de } x", "Es el coeficiente de } y", "Es el valor de } h", "A", null, "B"),
            Question(11005, "MAT", "MAT-11", "\\text{¿Qué tipo de curva representa la ecuación } x^2 + y^2 = 0?", "Un punto en el origen", "Una circunferencia con radio 0", "Una línea", "No representa una curva real", "A", null, "B"),

            Question(12001, "MAT", "MAT-12", "\\text{¿Cuál es la ecuación general de una elipse con centro en } (h, k)?", "\\frac{(x - h)^2}{a^2} + \\frac{(y - k)^2}{b^2} = 1", "\\frac{(x - h)^2}{b^2} - \\frac{(y - k)^2}{a^2} = 1", "(x - h)^2 + (y - k)^2 = r^2", "y = mx + b", "A", null, "B"),
            Question(12002, "MAT", "MAT-12", "\\text{Si } a > b, \\text{ ¿cuál es el eje mayor de la elipse?}", "El eje horizontal", "El eje vertical", "El eje inclinado", "No tiene eje mayor", "A", null, "B"),
            Question(12003, "MAT", "MAT-12", "\\text{¿Dónde están los focos de la elipse si el centro está en } (0,0)?", "(\\pm c, 0) \\text{ o } (0, \\pm c) \\text{ donde } c^2 = a^2 - b^2", "(0,0)", "(a,b)", "No tiene focos", "A", null, "B"),
            Question(12004, "MAT", "MAT-12", "\\text{La suma de las distancias de cualquier punto de la elipse a los focos es:}", "Constante e igual a } 2a", "Variable", "Constante e igual a } 2b", "Variable e igual a } a + b", "A", null, "B"),
            Question(12005, "MAT", "MAT-12", "\\text{¿Qué pasa si } a = b \\text{ en la ecuación de la elipse?}", "Se convierte en una circunferencia", "Se convierte en una parábola", "Se convierte en una hipérbola", "No representa una figura geométrica", "A", null, "B"),

            Question(13001, "MAT", "MAT-13", "\\text{¿Cuál es la ecuación canónica de una hipérbola con centro en } (h, k)?", "\\frac{(x - h)^2}{a^2} - \\frac{(y - k)^2}{b^2} = 1", "\\frac{(x - h)^2}{a^2} + \\frac{(y - k)^2}{b^2} = 1", "(x - h)^2 + (y - k)^2 = r^2", "\\frac{(y - k)^2}{a^2} - \\frac{(x - h)^2}{b^2} = 1", "A", null, "B"),
            Question(13002, "MAT", "MAT-13", "\\text{¿Qué caracteriza a una hipérbola respecto a sus focos?}", "La diferencia de distancias a los focos es constante", "La suma de distancias a los focos es constante", "Tiene un solo foco", "No tiene focos", "A", null, "B"),
            Question(13003, "MAT", "MAT-13", "\\text{¿Cómo se calcula la distancia } c \\text{ del centro a los focos en una hipérbola?}", "c^2 = a^2 + b^2", "c^2 = a^2 - b^2", "c^2 = b^2 - a^2", "c^2 = a^2 \\cdot b^2", "A", null, "B"),
            Question(13004, "MAT", "MAT-13", "\\text{¿Qué representa la ecuación } \\frac{x^2}{4} - \\frac{y^2}{9} = 1?", "Una hipérbola horizontal", "Una hipérbola vertical", "Una elipse", "Una parábola", "A", null, "B"),
            Question(13005, "MAT", "MAT-13", "\\text{¿Cuál es la condición para que una cónica sea una hipérbola en su forma general } Ax^2 + Bxy + Cy^2 + Dx + Ey + F = 0?", "A y C tienen signos opuestos", "A = C", "B = 0", "A = 0", "A", null, "B"),

            Question(14001, "MAT", "MAT-14", "\\text{¿Cuál es la forma general de la ecuación de segundo grado?}", "Ax^2 + Bx + C = 0", "Ax + B = 0", "Ax^2 + B = 0", "Ax^2 + C = 0", "A", null, "B"),
            Question(14002, "MAT", "MAT-14", "\\text{¿Qué determina el discriminante } \\Delta = B^2 - 4AC \\text{ de una ecuación cuadrática?}", "El número y tipo de soluciones", "El valor del vértice", "La pendiente", "El valor de C", "A", null, "B"),
            Question(14003, "MAT", "MAT-14", "\\text{Si } \\Delta < 0 \\text{ en una ecuación cuadrática, entonces:}", "Tiene dos soluciones complejas", "Tiene una sola solución real", "Tiene dos soluciones reales", "No tiene solución", "A", null, "B"),
            Question(14004, "MAT", "MAT-14", "\\text{¿Cuál es la fórmula general para resolver } Ax^2 + Bx + C = 0?", "x = \\frac{-B \\pm \\sqrt{B^2 - 4AC}}{2A}", "x = \\frac{-B \\pm \\sqrt{AC}}{2A}", "x = \\frac{-B}{2A}", "x = \\frac{-C \\pm \\sqrt{B^2 - 4A}}{2A}", "A", null, "B"),
            Question(14005, "MAT", "MAT-14", "\\text{¿Qué representa gráficamente una ecuación de segundo grado en una variable?}", "Una parábola", "Una recta", "Una circunferencia", "Una hipérbola", "A", null, "B"),

            Question(15001, "MAT", "MAT-15", "\\text{¿Cuál es el límite de } \\lim_{x \\to 2} (3x + 1)?", "7", "6", "5", "8", "A", null, "A1"),
            Question(15002, "MAT", "MAT-15", "\\text{Si } \\lim_{x \\to a} f(x) = L \\text{, entonces:}", "f(x) se aproxima a L cuando x se acerca a a", "f(a) = L", "x siempre vale a", "f(x) = a", "A", null, "A1"),
            Question(15003, "MAT", "MAT-15", "\\text{¿Qué representa } \\lim_{x \\to \\infty} \\frac{1}{x}?", "0", "1", "Infinito", "Indeterminado", "A", null, "A1"),
            Question(15004, "MAT", "MAT-15", "\\text{¿Qué tipo de indeterminación representa } \\frac{0}{0}?", "Indeterminación", "Infinito", "Límite nulo", "No existe", "A", null, "A1"),
            Question(15005, "MAT", "MAT-15", "\\text{¿Cuál es el valor de } \\lim_{x \\to 0} \\frac{\\sin x}{x}?", "1", "0", "Infinito", "No existe", "A", null, "A1"),

            Question(16001, "MAT", "MAT-16", "\\text{¿Qué representa la derivada de una función?}", "La pendiente de la tangente en un punto", "El área bajo la curva", "El valor máximo de la función", "La constante de integración", "A", null, "A1"),
            Question(16002, "MAT", "MAT-16", "\\text{¿Cuál es la derivada de } f(x) = x^2?", "2x", "x", "x^2", "2", "A", null, "A1"),
            Question(16003, "MAT", "MAT-16", "\\text{¿Cuál es la derivada de una constante } c?", "0", "1", "c", "c^2", "A", null, "A1"),
            Question(16004, "MAT", "MAT-16", "\\text{¿Cuál es la notación de Leibniz para la derivada de } y = f(x)?", "\\frac{dy}{dx}", "f'(x)", "\\frac{dx}{dy}", "Df(x)", "A", null, "A1"),
            Question(16005, "MAT", "MAT-16", "\\text{¿Cuál es la derivada de } f(x) = \\sin x?", "\\cos x", "-\\cos x", "\\sin x", "-\\sin x", "A", null, "A1"),

            Question(17001, "MAT", "MAT-17", "\\text{¿Qué representa una integral definida?}", "El área bajo la curva entre dos puntos", "La pendiente de la curva", "La longitud de la curva", "El volumen de la región", "A", null, "A1"),
            Question(17002, "MAT", "MAT-17", "\\text{¿Cuál es la integral de } f(x) = x^n \\text{ con } n \\neq -1?", "\\frac{x^{n+1}}{n+1} + C", "\\frac{1}{x} + C", "n x^{n-1} + C", "x^{n+1} + C", "A", null, "A1"),
            Question(17003, "MAT", "MAT-17", "\\text{¿Cuál es la integral de } f(x) = \\cos x?", "\\sin x + C", "-\\sin x + C", "\\cos x + C", "-\\cos x + C", "A", null, "A1"),
            Question(17004, "MAT", "MAT-17", "\\int_0^1 x^2\\,dx = ?", "\\frac{1}{3}", "1", "\\frac{1}{2}", "\\frac{2}{3}", "A", null, "A1"),
            Question(17005, "MAT", "MAT-17", "\\text{¿Qué relación existe entre derivada e integral?}", "La integral es la operación inversa de la derivada", "La derivada es una parte de la integral", "Ambas operaciones no tienen relación", "Ambas calculan el área", "A", null, "A1"),
        )
    }

    fun getBiologyQuestions(): List<Question> {
        return listOf(
            Question(101, "BIO", "BIO-1", "¿Cuál es el nivel más básico de organización de la materia viva?", "Célula", "Molécula", "Átomo", "Tejido", "C", null, "A"),
            Question(102, "BIO", "BIO-1", "¿Qué estructura regula la entrada y salida de sustancias en la célula?", "Pared celular", "Membrana plasmática", "Núcleo", "Citoplasma", "B", null, "A"),
            Question(103, "BIO", "BIO-1", "¿Qué orgánulo celular contiene el ADN?", "Lisosoma", "Ribosoma", "Mitocondria", "Núcleo", "D", null, "A"),
            Question(104, "BIO", "BIO-1", "¿Cuál de los siguientes no es un organelo?", "Núcleo", "Ribosoma", "ADN", "Aparato de Golgi", "C", null, "A"),
            Question(105, "BIO", "BIO-1", "¿Qué tipo de célula no tiene núcleo definido?", "Animal", "Vegetal", "Procariota", "Eucariota", "C", null, "A"),

            Question(106, "BIO", "BIO-2", "¿Cuál es la molécula que almacena energía en las células?", "ADN", "ATP", "ARN", "Glucógeno", "B", null, "A"),
            Question(107, "BIO", "BIO-2", "¿Qué proceso convierte la glucosa en energía?", "Fotosíntesis", "Respiración celular", "Digestión", "Fermentación", "B", null, "A"),
            Question(108, "BIO", "BIO-2", "¿Dónde ocurre principalmente la respiración celular?", "Ribosoma", "Cloroplasto", "Núcleo", "Mitocondria", "D", null, "A"),
            Question(109, "BIO", "BIO-2", "¿Qué orgánulo se encarga de la fotosíntesis?", "Cloroplasto", "Lisosoma", "Mitocondria", "Aparato de Golgi", "A", null, "A"),
            Question(110, "BIO", "BIO-2", "¿Qué enzimas catalizan las reacciones metabólicas?", "Hormonas", "Proteínas", "Vitaminas", "Enzimas", "D", null, "A"),

            Question(111, "BIO", "BIO-3", "¿Qué tipo de reproducción requiere de dos progenitores?", "Asexual", "Sexual", "Mitosis", "Bipartición", "B", null, "A"),
            Question(112, "BIO", "BIO-3", "¿En qué fase de la mitosis se alinean los cromosomas en el centro?", "Profase", "Metafase", "Anafase", "Telofase", "B", null, "A"),
            Question(113, "BIO", "BIO-3", "¿Cómo se llama la división celular que produce gametos?", "Mitosis", "Meiosis", "Fisión binaria", "Duplicación", "B", null, "A"),
            Question(114, "BIO", "BIO-3", "¿Qué tipo de reproducción es más rápida?", "Sexual", "Asexual", "Por fecundación", "Meiótica", "B", null, "A"),
            Question(115, "BIO", "BIO-3", "¿La fecundación es característica de qué tipo de reproducción?", "Asexual", "Bipartición", "Sexual", "Esporulación", "C", null, "A"),

            Question(116, "BIO", "BIO-4", "¿Quién propuso las leyes de la herencia?", "Watson", "Crick", "Mendel", "Darwin", "C", null, "A"),
            Question(117, "BIO", "BIO-4", "¿Qué representa una letra mayúscula en genética?", "Recesivo", "Dominante", "Mutación", "Codón", "B", null, "A"),
            Question(118, "BIO", "BIO-4", "¿Qué estructura porta la información genética?", "Proteínas", "Glucosa", "ADN", "Lípidos", "C", null, "A"),
            Question(119, "BIO", "BIO-4", "¿Qué célula transmite la herencia?", "Neurona", "Esperma", "Célula madre", "Célula somática", "B", null, "A"),
            Question(120, "BIO", "BIO-4", "¿Qué significa homocigoto?", "Dos genes distintos", "Dos genes iguales", "Un solo gen", "Sin genes", "B", null, "A"),

            Question(121, "BIO", "BIO-5", "¿Cuál es el mecanismo propuesto por Darwin para la evolución?", "Mutación", "Adaptación", "Selección natural", "Deriva genética", "C", null, "A"),
            Question(122, "BIO", "BIO-5", "¿Qué indica el registro fósil?", "Cambios climáticos", "Evidencia evolutiva", "Distribución vegetal", "Movimiento de placas", "B", null, "A"),
            Question(123, "BIO", "BIO-5", "¿Qué estructuras indican un ancestro común?", "Órganos homólogos", "Órganos análogos", "Mutaciones", "Órganos únicos", "A", null, "A"),
            Question(124, "BIO", "BIO-5", "¿Qué tipo de selección favorece a los extremos?", "Estabilizadora", "Disruptiva", "Direccional", "Neutral", "B", null, "A"),
            Question(125, "BIO", "BIO-5", "¿Cuál es una fuente de variabilidad genética?", "Reproducción asexual", "Mutación", "Homeostasis", "Mitocondria", "B", null, "A"),

            Question(126, "BIO", "BIO-6", "¿Cómo se llama el lugar donde vive un organismo?", "Ecosistema", "Hábitat", "Nicho", "Población", "B", null, "A"),
            Question(127, "BIO", "BIO-6", "¿Qué representa un ecosistema?", "Sólo animales", "Interacción entre seres vivos y ambiente", "Solo plantas", "Cadena trófica", "B", null, "A"),
            Question(128, "BIO", "BIO-6", "¿Qué ciclo incluye fotosíntesis y respiración?", "Ciclo del nitrógeno", "Ciclo del carbono", "Ciclo del agua", "Ciclo del fósforo", "B", null, "A"),
            Question(129, "BIO", "BIO-6", "¿Qué nivel de organización incluye diferentes especies?", "Población", "Comunidad", "Célula", "Órgano", "B", null, "A"),
            Question(130, "BIO", "BIO-6", "¿Qué es la biodiversidad?", "Riqueza de agua", "Variedad de especies", "Tipo de suelo", "Abundancia de clorofila", "B", null, "A"),
        )
    }

    fun getMexicanHistoryQuestions(): List<Question> {
        return listOf(
            Question(301, "HMX", "HMX-1", "¿Qué institución regulaba la vida religiosa y educativa en la Nueva España?", "El cabildo", "La Audiencia", "La Iglesia", "El Virreinato", "C", null, "A"),
            Question(302, "HMX", "HMX-1", "¿Cuál era la principal actividad económica de la Nueva España?", "La minería", "El comercio con Asia", "La pesca", "La agricultura de exportación", "A", null, "A"),
            Question(303, "HMX", "HMX-1", "¿Qué grupo social predominaba en el gobierno virreinal?", "Indígenas", "Criollos", "Peninsulares", "Mestizos", "C", null, "A"),
            Question(304, "HMX", "HMX-1", "¿Qué fue el sistema de encomiendas?", "Un método para educar indígenas", "Un sistema fiscal", "Una forma de esclavitud indígena", "Una institución militar", "C", null, "B"),
            Question(305, "HMX", "HMX-1", "¿Qué institución representaba al rey de España en la Nueva España?", "El cabildo", "El virrey", "El corregidor", "El inquisidor", "B", null, "A"),

            Question(306, "HMX", "HMX-2", "¿Quién encabezó el inicio de la Independencia en 1810?", "José María Morelos", "Vicente Guerrero", "Miguel Hidalgo", "Agustín de Iturbide", "C", null, "A"),
            Question(307, "HMX", "HMX-2", "¿Cuál fue el documento que proclamaba la independencia?", "Plan de Ayala", "Plan de Iguala", "Constitución de Cádiz", "Sentimientos de la Nación", "B", null, "B"),
            Question(308, "HMX", "HMX-2", "¿Qué papel jugó José María Morelos en la independencia?", "Organizó el ejército insurgente", "Negoció con España", "Dirigió la Inquisición", "Promovió la paz", "A", null, "B"),
            Question(309, "HMX", "HMX-2", "¿Qué buscaba el movimiento de Independencia?", "Más impuestos", "Autonomía local", "Independencia total de España", "Apoyo francés", "C", null, "A"),
            Question(310, "HMX", "HMX-2", "¿Qué sucedió con Miguel Hidalgo tras ser capturado?", "Fue liberado", "Fue desterrado", "Fue fusilado", "Fue nombrado virrey", "C", null, "A"),

            Question(311, "HMX", "HMX-3", "¿Quién fue el primer emperador del México independiente?", "Benito Juárez", "Agustín de Iturbide", "Antonio López de Santa Anna", "Guadalupe Victoria", "B", null, "A"),
            Question(312, "HMX", "HMX-3", "¿Qué tipo de gobierno se instauró tras la caída del imperio de Iturbide?", "Teocracia", "Monarquía constitucional", "República federal", "Dictadura", "C", null, "A"),
            Question(313, "HMX", "HMX-3", "¿Qué conflicto marcó esta etapa?", "La intervención estadounidense", "La guerra cristera", "La guerra de Reforma", "La revolución", "A", null, "B"),
            Question(314, "HMX", "HMX-3", "¿Quién fue presidente en múltiples ocasiones y tuvo gran influencia?", "Juárez", "Iturbide", "Santa Anna", "Obregón", "C", null, "B"),
            Question(315, "HMX", "HMX-3", "¿Qué documento estableció el sistema federal en México?", "Constitución de 1824", "Plan de Ayutla", "Acta de Independencia", "Plan de Tuxtepec", "A", null, "A"),

            Question(316, "HMX", "HMX-4", "¿Qué presidente impulsó las Leyes de Reforma?", "Santa Anna", "Juárez", "Porfirio Díaz", "Madero", "B", null, "B"),
            Question(317, "HMX", "HMX-4", "¿Qué buscaban las Leyes de Reforma?", "Apoyar a la Iglesia", "Eliminar la educación pública", "Separar Iglesia y Estado", "Fortalecer al clero", "C", null, "A"),
            Question(318, "HMX", "HMX-4", "¿Qué país intervino en México durante esta etapa?", "España", "Estados Unidos", "Francia", "Inglaterra", "C", null, "B"),
            Question(319, "HMX", "HMX-4", "¿Qué evento representó la victoria republicana ante el Imperio?", "Batalla de Puebla", "Fusilamiento de Maximiliano", "Plan de Tuxtepec", "Firma del Tratado de Córdoba", "B", null, "A"),
            Question(320, "HMX", "HMX-4", "¿Quién encabezó la resistencia liberal?", "Porfirio Díaz", "Venustiano Carranza", "Juárez", "Miguel Lerdo", "C", null, "A"),

            Question(321, "HMX", "HMX-5", "¿Quién fue el dictador durante el Porfiriato?", "Juárez", "Madero", "Obregón", "Porfirio Díaz", "D", null, "A"),
            Question(322, "HMX", "HMX-5", "¿Qué lema representaba la política porfirista?", "Tierra y libertad", "Sufragio efectivo, no reelección", "Orden y progreso", "Pan y circo", "C", null, "A"),
            Question(323, "HMX", "HMX-5", "¿Qué sector fue beneficiado durante el Porfiriato?", "Campesinado", "Iglesia", "Extranjeros e inversionistas", "Obreros", "C", null, "B"),
            Question(324, "HMX", "HMX-5", "¿Qué tipo de desarrollo tuvo México en este periodo?", "Cultural", "Económico y de infraestructura", "Militar", "Tecnológico", "B", null, "A"),
            Question(325, "HMX", "HMX-5", "¿Qué originó el fin del Porfiriato?", "Una invasión", "La muerte de Díaz", "La Revolución Mexicana", "Un golpe militar", "C", null, "A"),

            Question(326, "HMX", "HMX-6", "¿En qué año inició la Revolución Mexicana?", "1910", "1920", "1900", "1888", "A", null, "A"),
            Question(327, "HMX", "HMX-6", "¿Qué documento político impulsó Francisco I. Madero?", "Plan de San Luis", "Plan de Ayutla", "Constitución de 1917", "Plan de Agua Prieta", "A", null, "B"),
            Question(328, "HMX", "HMX-6", "¿Qué personaje fue clave en el sur del país durante la revolución?", "Obregón", "Carranza", "Zapata", "Huerta", "C", null, "A"),
            Question(329, "HMX", "HMX-6", "¿Qué objetivo tenía la revolución?", "Eliminar el clero", "Terminar con la dictadura porfirista", "Invadir EUA", "Reinstaurar el imperio", "B", null, "A"),
            Question(330, "HMX", "HMX-6", "¿Qué general derrocó a Madero?", "Zapata", "Huerta", "Carranza", "Villa", "B", null, "B"),

            Question(331, "HMX", "HMX-7", "¿Qué presidente impulsó la educación rural?", "Plutarco Elías Calles", "Álvaro Obregón", "Lázaro Cárdenas", "Manuel Ávila Camacho", "B", null, "B"),
            Question(332, "HMX", "HMX-7", "¿Qué organización política se creó en 1929?", "PRI", "PAN", "PRD", "Partido Liberal", "A", null, "B"),
            Question(333, "HMX", "HMX-7", "¿Qué caracterizó la reconstrucción nacional?", "Guerra civil", "Estabilidad política y modernización", "Dictadura", "Intervención extranjera", "B", null, "A"),
            Question(334, "HMX", "HMX-7", "¿Qué institución se fortaleció en este periodo?", "Ejército", "Iglesia", "SEP", "Banco de México", "C", null, "A"),
            Question(335, "HMX", "HMX-7", "¿Qué presidente inició la política de reparto agrario?", "Calles", "Obregón", "Cárdenas", "Carranza", "C", null, "A"),

            Question(336, "HMX", "HMX-8", "¿Qué presidente nacionalizó el petróleo?", "Lázaro Cárdenas", "Manuel Ávila Camacho", "Miguel Alemán", "Echeverría", "A", null, "A"),
            Question(337, "HMX", "HMX-8", "¿Qué sector económico creció en el llamado 'milagro mexicano'?", "Primario", "Industrial", "Turístico", "Agrícola", "B", null, "A"),
            Question(338, "HMX", "HMX-8", "¿Qué movimiento estudiantil fue reprimido en 1968?", "UNAM libre", "Movimiento de Reforma", "Movimiento del 68", "Movimiento pro democracia", "C", null, "B"),
            Question(339, "HMX", "HMX-8", "¿Qué presidente creó el ISSSTE?", "Cárdenas", "Ávila Camacho", "Adolfo López Mateos", "Díaz Ordaz", "C", null, "A"),
            Question(340, "HMX", "HMX-8", "¿Qué característica tuvo el sistema político mexicano en el siglo XX?", "Pluripartidismo", "Unipartidismo", "Monarquía", "Federalismo centralizado", "B", null, "A"),
        )
    }

    fun getWorldHistoryQuestions(): List<Question> {
        return listOf(
            // HUN-1: La Historia
            Question(1, "HUN", "HUN-1", "¿Qué estudia la Historia como disciplina?", "El pasado humano", "El futuro de la humanidad", "La naturaleza", "Los animales", "A", null, "A"),
            Question(2, "HUN", "HUN-1", "¿Cuál es una fuente primaria para el estudio de la historia?", "Libro de texto", "Carta de un soldado", "Artículo de revista", "Enciclopedia", "B", null, "A"),
            Question(3, "HUN", "HUN-1", "¿Qué permite la periodización histórica?", "Inventar hechos históricos", "Ubicar hechos en el tiempo", "Eliminar eventos irrelevantes", "Memorizar fechas", "B", null, "A"),
            Question(4, "HUN", "HUN-1", "¿Cuál es el objetivo principal del historiador?", "Escribir novelas", "Difundir mitos", "Investigar y explicar hechos del pasado", "Predecir el futuro", "C", null, "A"),
            Question(5, "HUN", "HUN-1", "¿Qué herramienta utiliza principalmente el historiador?", "Microscopio", "Cálculo diferencial", "Análisis de fuentes", "Diseño gráfico", "C", null, "A"),

            // HUN-2: Las revoluciones burguesas
            Question(6, "HUN", "HUN-2", "¿En qué siglo ocurrió la Revolución Francesa?", "XVII", "XVIII", "XIX", "XX", "B", null, "A"),
            Question(7, "HUN", "HUN-2", "¿Qué documento surgió durante la Revolución Francesa?", "La Biblia", "La Constitución de Cádiz", "La Declaración de los Derechos del Hombre y del Ciudadano", "El Código Napoleónico", "C", null, "A"),
            Question(8, "HUN", "HUN-2", "¿Qué clase social lideró las revoluciones burguesas?", "Nobleza", "Clero", "Burguesía", "Campesinado", "C", null, "A"),
            Question(9, "HUN", "HUN-2", "¿Qué país fue escenario de la Independencia de las Trece Colonias?", "Francia", "México", "Estados Unidos", "Alemania", "C", null, "A"),
            Question(10, "HUN", "HUN-2", "¿Cuál fue una consecuencia de las revoluciones burguesas?", "Mayor poder del rey", "Establecimiento de monarquías absolutas", "Difusión del pensamiento liberal", "Expansión del feudalismo", "C", null, "A"),

            // HUN-3: Pensamientos y movimientos del siglo XIX
            Question(11, "HUN", "HUN-3", "¿Qué ideología defendía la propiedad privada y la libre empresa?", "Liberalismo", "Socialismo", "Absolutismo", "Comunismo", "A", null, "A"),
            Question(12, "HUN", "HUN-3", "¿Quién propuso el socialismo científico junto con Engels?", "Smith", "Rousseau", "Karl Marx", "Napoleón", "C", null, "A"),
            Question(13, "HUN", "HUN-3", "¿Qué movimiento defendía los derechos del proletariado?", "Romanticismo", "Socialismo", "Feudalismo", "Liberalismo", "B", null, "A"),
            Question(14, "HUN", "HUN-3", "¿Cuál fue una característica del nacionalismo en el siglo XIX?", "Defensa del absolutismo", "Búsqueda de la unificación territorial", "Apoyo al colonialismo", "Rechazo de la identidad cultural", "B", null, "A"),
            Question(15, "HUN", "HUN-3", "¿Qué corriente influyó en la Revolución Industrial?", "Feudalismo", "Comunismo", "Liberalismo", "Romanticismo", "C", null, "A"),

            Question(16, "HUN", "HUN-4", "¿Qué país europeo lideró la expansión imperialista en África durante el siglo XIX?", "Francia", "Alemania", "Gran Bretaña", "Italia", "C", null, "A"),
            Question(17, "HUN", "HUN-4", "¿Cuál fue una consecuencia directa del imperialismo europeo en Asia?", "El fortalecimiento de los imperios asiáticos", "La independencia inmediata de las colonias", "La explotación de recursos y pueblos", "La erradicación del comercio", "C", null, "A"),
            Question(18, "HUN", "HUN-4", "¿Qué justificación ideológica se utilizó para el imperialismo en el siglo XIX?", "La democracia directa", "El darwinismo social", "El marxismo", "La teoría heliocéntrica", "B", null, "B"),
            Question(19, "HUN", "HUN-4", "¿Qué conferencia dividió África entre potencias europeas sin considerar a los pueblos africanos?", "Conferencia de París", "Conferencia de Berlín", "Conferencia de Viena", "Conferencia de Yalta", "B", null, "A"),
            Question(20, "HUN", "HUN-4", "¿Cuál fue una característica económica del imperialismo?", "Reducción del comercio", "Cooperación con las colonias", "Búsqueda de nuevos mercados", "Desmilitarización", "C", null, "A"),

            Question(21, "HUN", "HUN-5", "¿Qué evento detonó la Primera Guerra Mundial?", "La invasión de Polonia", "El asesinato del archiduque Francisco Fernando", "La firma del Tratado de Versalles", "La Revolución rusa", "B", null, "A"),
            Question(22, "HUN", "HUN-5", "¿Cuál fue una de las principales alianzas en la Primera Guerra Mundial?", "Eje Roma-Berlín", "OTAN", "Triple Entente", "Pacto de Varsovia", "C", null, "A"),
            Question(23, "HUN", "HUN-5", "¿Qué tratado puso fin oficialmente a la Primera Guerra Mundial?", "Tratado de Tordesillas", "Tratado de Berlín", "Tratado de Versalles", "Tratado de Ginebra", "C", null, "A"),
            Question(24, "HUN", "HUN-5", "¿Cuál fue una consecuencia del Tratado de Versalles para Alemania?", "Expansión territorial", "Pérdida de colonias y pago de reparaciones", "Alianza con Estados Unidos", "Neutralidad política", "B", null, "A"),
            Question(25, "HUN", "HUN-5", "¿Qué arma cambió radicalmente el combate durante la Primera Guerra Mundial?", "Espada", "Catapulta", "Gas mostaza", "Ballesta", "C", null, "A"),

            Question(26, "HUN", "HUN-6", "¿Qué acontecimiento económico marcó el inicio de la Gran Depresión?", "La caída del Muro de Berlín", "El crack de la bolsa en 1929", "El Plan Marshall", "La invasión de Etiopía", "B", null, "A"),
            Question(27, "HUN", "HUN-6", "¿Qué régimen político se consolidó en Italia entre guerras?", "Comunismo", "Fascismo", "Democracia liberal", "Monarquía absoluta", "B", null, "A"),
            Question(28, "HUN", "HUN-6", "¿Qué líder implementó el New Deal en Estados Unidos?", "Theodore Roosevelt", "Woodrow Wilson", "Franklin D. Roosevelt", "Harry Truman", "C", null, "A"),
            Question(29, "HUN", "HUN-6", "¿Qué país experimentó una revolución comunista en 1917?", "Alemania", "Francia", "China", "Rusia", "D", null, "A"),
            Question(30, "HUN", "HUN-6", "¿Qué país fue invadido por Italia en 1935 como parte de su política expansionista?", "Egipto", "Etiopía", "Grecia", "Irán", "B", null, "A"),

            Question(31, "HUN", "HUN-7", "¿Qué hecho marcó el inicio de la Segunda Guerra Mundial?", "El bombardeo de Pearl Harbor", "La invasión alemana a Polonia", "La guerra civil española", "El pacto de no agresión", "B", null, "A"),
            Question(32, "HUN", "HUN-7", "¿Qué países conformaron el Eje?", "Francia, Reino Unido y EE.UU.", "Alemania, Italia y Japón", "URSS, China y EE.UU.", "Canadá, Brasil y México", "B", null, "A"),
            Question(33, "HUN", "HUN-7", "¿Qué acontecimiento provocó la entrada de Estados Unidos en la Segunda Guerra Mundial?", "El ataque a Pearl Harbor", "La invasión de Francia", "El pacto Ribbentrop-Mólotov", "El desembarco en Normandía", "A", null, "A"),
            Question(34, "HUN", "HUN-7", "¿Qué batalla representó un punto de inflexión en el frente oriental?", "Batalla de Berlín", "Batalla de Londres", "Batalla de Stalingrado", "Batalla del Mar del Coral", "C", null, "A"),
            Question(35, "HUN", "HUN-7", "¿Qué ciudad fue destruida por una bomba atómica en 1945?", "Tokio", "Osaka", "Hiroshima", "Kioto", "C", null, "A"),

            Question(36, "HUN", "HUN-8", "¿Qué bloque lideraba Estados Unidos durante la Guerra Fría?", "El bloque socialista", "El bloque capitalista", "El bloque neutral", "El bloque no alineado", "B", null, "A"),
            Question(37, "HUN", "HUN-8", "¿Qué organismo se creó en 1949 como una alianza militar liderada por EE.UU.?", "ONU", "Pacto de Varsovia", "OTAN", "UNESCO", "C", null, "A"),
            Question(38, "HUN", "HUN-8", "¿Qué evento puso al mundo al borde de una guerra nuclear en 1962?", "La guerra de Corea", "La invasión de Bahía de Cochinos", "La crisis de los misiles en Cuba", "La guerra de Vietnam", "C", null, "A"),
            Question(39, "HUN", "HUN-8", "¿Qué construcción simbolizó la división entre el Este y el Oeste?", "La Torre Eiffel", "El Canal de Suez", "El Muro de Berlín", "La Muralla China", "C", null, "A"),
            Question(40, "HUN", "HUN-8", "¿Qué doctrina estadounidense justificó la intervención en América Latina durante la Guerra Fría?", "Doctrina Truman", "Doctrina Monroe", "Doctrina Eisenhower", "Doctrina Carter", "B", null, "A"),

            Question(41, "HUN", "HUN-9", "¿Qué evento marcó el fin de la Guerra Fría?", "La caída del Muro de Berlín", "La firma del Tratado de Versalles", "El atentado a las Torres Gemelas", "La invasión de Irak", "A", null, "A"),
            Question(42, "HUN", "HUN-9", "¿Qué organización surgió como una unión económica y política en Europa?", "UNESCO", "OEA", "Unión Europea", "OTAN", "C", null, "A"),
            Question(43, "HUN", "HUN-9", "¿Qué ataque terrorista ocurrió en EE.UU. el 11 de septiembre de 2001?", "Ataque a Oklahoma", "Torres Gemelas", "Pentágono", "Pearl Harbor", "B", null, "A"),
            Question(44, "HUN", "HUN-9", "¿Qué país se convirtió en una potencia económica emergente en el siglo XXI?", "Italia", "India", "Sudáfrica", "México", "B", null, "A"),
            Question(45, "HUN", "HUN-9", "¿Qué conflicto bélico involucró la invasión de Irak en 2003?", "Guerra del Golfo", "Guerra de Vietnam", "Segunda Guerra Mundial", "Guerra de Irak", "D", null, "A"),
        )
    }

    fun getChemistryQuestions(): List<Question> {
        return listOf(
            // Temas básicos (QUI-1)
            Question(id=5001, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué es un átomo?", optionA="La partícula más pequeña de un elemento que conserva sus propiedades", optionB="Una molécula compleja", optionC="Un compuesto", optionD="Una mezcla homogénea", answer="A", image=null, level="B"),
            Question(id=5002, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué partículas subatómicas conforman un átomo?", optionA="Protones, neutrones y electrones", optionB="Protones y neutrinos", optionC="Electrones y fotones", optionD="Neutrones y positrones", answer="A", image=null, level="A"),
            Question(id=5003, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué es un elemento químico?", optionA="Una sustancia formada por un solo tipo de átomo", optionB="Una mezcla de sustancias", optionC="Un compuesto químico", optionD="Un isótopo", answer="A", image=null, level="B"),
            Question(id=5004, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué indica el número atómico de un elemento?", optionA="Número de protones en el núcleo", optionB="Número de neutrones", optionC="Número de electrones libres", optionD="Número de átomos en una molécula", answer="A", image=null, level="B"),
            Question(id=5005, codeSubject="QUI", codeTopic="QUI-1", description="¿Qué es un isótopo?", optionA="Átomos del mismo elemento con diferente número de neutrones", optionB="Un compuesto químico", optionC="Una molécula", optionD="Una mezcla", answer="A", image=null, level="C"),

// Agua (QUI-2)
            Question(id=5011, codeSubject="QUI", codeTopic="QUI-2", description="¿Cuál es la fórmula molecular del agua?", optionA="H2O", optionB="CO2", optionC="O2", optionD="NaCl", answer="A", image=null, level="A"),
            Question(id=5012, codeSubject="QUI", codeTopic="QUI-2", description="¿Qué propiedad del agua permite que sea un buen solvente?", optionA="Su polaridad", optionB="Su temperatura alta", optionC="Su color", optionD="Su presión", answer="A", image=null, level="B"),
            Question(id=5013, codeSubject="QUI", codeTopic="QUI-2", description="¿Qué es la cohesión en el agua?", optionA="Atracción entre moléculas de agua", optionB="Atracción entre agua y otras sustancias", optionC="Evaporación del agua", optionD="Disolución de sales", answer="A", image=null, level="B"),
            Question(id=5014, codeSubject="QUI", codeTopic="QUI-2", description="¿Cuál es el punto de ebullición del agua a presión atmosférica?", optionA="100 °C", optionB="0 °C", optionC="50 °C", optionD="212 °C", answer="A", image=null, level="A"),
            Question(id=5015, codeSubject="QUI", codeTopic="QUI-2", description="¿Qué fenómeno explica que el agua suba por tubos delgados?", optionA="Capilaridad", optionB="Presión atmosférica", optionC="Evaporación", optionD="Condensación", answer="A", image=null, level="B"),

// Aire (QUI-3)
            Question(id=5021, codeSubject="QUI", codeTopic="QUI-3", description="¿De qué gases está compuesto principalmente el aire?", optionA="Nitrógeno y oxígeno", optionB="Dióxido de carbono y argón", optionC="Helio y hidrógeno", optionD="Ozono y vapor de agua", answer="A", image=null, level="B"),
            Question(id=5022, codeSubject="QUI", codeTopic="QUI-3", description="¿Qué porcentaje de oxígeno contiene el aire aproximadamente?", optionA="21%", optionB="78%", optionC="1%", optionD="50%", answer="A", image=null, level="A"),
            Question(id=5023, codeSubject="QUI", codeTopic="QUI-3", description="¿Qué es la presión atmosférica?", optionA="El peso del aire sobre la superficie terrestre", optionB="La fuerza del viento", optionC="La temperatura del aire", optionD="La humedad relativa", answer="A", image=null, level="B"),
            Question(id=5024, codeSubject="QUI", codeTopic="QUI-3", description="¿Qué instrumento se usa para medir la presión atmosférica?", optionA="Barómetro", optionB="Termómetro", optionC="Anemómetro", optionD="Higrómetro", answer="A", image=null, level="B"),
            Question(id=5025, codeSubject="QUI", codeTopic="QUI-3", description="¿Qué es la composición del aire seco?", optionA="Principalmente nitrógeno, oxígeno y argón", optionB="Solo oxígeno", optionC="Solo dióxido de carbono", optionD="Solo vapor de agua", answer="A", image=null, level="C"),

            // Alimentos (QUI-4)
            Question(id=5031, codeSubject="QUI", codeTopic="QUI-4", description="¿Qué macronutriente proporciona la mayor cantidad de energía?", optionA="Grasas", optionB="Carbohidratos", optionC="Proteínas", optionD="Vitaminas", answer="A", image=null, level="B"),
            Question(id=5032, codeSubject="QUI", codeTopic="QUI-4", description="¿Qué elemento químico es fundamental en las proteínas?", optionA="Nitrógeno", optionB="Carbono", optionC="Oxígeno", optionD="Hidrógeno", answer="A", image=null, level="A"),
            Question(id=5033, codeSubject="QUI", codeTopic="QUI-4", description="¿Cuál es el papel del agua en los alimentos?", optionA="Disolvente y medio para reacciones químicas", optionB="Fuente de energía", optionC="Protector solar", optionD="Vitaminas", answer="A", image=null, level="B"),
            Question(id=5034, codeSubject="QUI", codeTopic="QUI-4", description="¿Qué vitaminas son solubles en agua?", optionA="Vitaminas del complejo B y vitamina C", optionB="Vitaminas A y D", optionC="Vitaminas E y K", optionD="Vitaminas liposolubles", answer="A", image=null, level="C"),
            Question(id=5035, codeSubject="QUI", codeTopic="QUI-4", description="¿Qué reacción química ocurre en la digestión?", optionA="Hidrólisis", optionB="Oxidación", optionC="Condensación", optionD="Sublimación", answer="A", image=null, level="B"),

            // La energía y las reacciones químicas (QUI-5)
            Question(id=5041, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué es una reacción química?", optionA="Proceso donde se transforman sustancias en otras", optionB="Mezcla física", optionC="Cambio de estado", optionD="Cambio de temperatura", answer="A", image=null, level="B"),
            Question(id=5042, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué es la energía de activación?", optionA="Energía mínima para iniciar una reacción química", optionB="Energía liberada en la reacción", optionC="Energía almacenada en enlaces", optionD="Energía del ambiente", answer="A", image=null, level="C"),
            Question(id=5043, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué es una reacción exotérmica?", optionA="Reacción que libera calor", optionB="Reacción que absorbe calor", optionC="Reacción que no cambia temperatura", optionD="Reacción que produce luz", answer="A", image=null, level="B"),
            Question(id=5044, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué es una reacción endotérmica?", optionA="Reacción que absorbe energía", optionB="Reacción que libera energía", optionC="Reacción sin cambio energético", optionD="Reacción explosiva", answer="A", image=null, level="B"),
            Question(id=5045, codeSubject="QUI", codeTopic="QUI-5", description="¿Qué ley química establece que la masa se conserva en una reacción?", optionA="Ley de conservación de la masa", optionB="Ley de conservación de la energía", optionC="Ley de Boyle", optionD="Ley de Avogadro", answer="A", image=null, level="A"),

            // Química del carbono (QUI-6)
            Question(id=5051, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué es un hidrocarburo?", optionA="Compuesto formado por carbono e hidrógeno", optionB="Compuesto formado por oxígeno e hidrógeno", optionC="Compuesto inorgánico", optionD="Elemento puro", answer="A", image=null, level="B"),
            Question(id=5052, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué tipo de enlace predomina en los compuestos de carbono?", optionA="Enlace covalente", optionB="Enlace iónico", optionC="Enlace metálico", optionD="Enlace de hidrógeno", answer="A", image=null, level="A"),
            Question(id=5053, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué es un isómero en química orgánica?", optionA="Compuestos con misma fórmula molecular pero diferente estructura", optionB="Compuestos con diferente fórmula", optionC="Mezcla de sustancias", optionD="Moléculas idénticas", answer="A", image=null, level="C"),
            Question(id=5054, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué es un alqueno?", optionA="Hidrocarburo con al menos un doble enlace carbono-carbono", optionB="Hidrocarburo saturado", optionC="Alcohol", optionD="Ácido carboxílico", answer="A", image=null, level="B"),
            Question(id=5055, codeSubject="QUI", codeTopic="QUI-6", description="¿Qué es la reacción de combustión?", optionA="Reacción donde un compuesto reacciona con oxígeno liberando energía", optionB="Reacción de mezcla", optionC="Reacción de descomposición", optionD="Reacción de neutralización", answer="A", image=null, level="B"),
        )
    }

    fun getPhysicsQuestions(): List<Question> {
        return listOf(
            Question(id=4001, codeSubject="FIS", codeTopic="FIS-1", description="¿Qué es la velocidad en cinemática?", optionA="La rapidez con dirección", optionB="La distancia recorrida", optionC="El tiempo empleado", optionD="La aceleración media", answer="A", image=null, level="B"),
            Question(id=4002, codeSubject="FIS", codeTopic="FIS-1", description="¿Cuál es la unidad de medida de la aceleración?", optionA="Metro por segundo", optionB="Metro por segundo cuadrado", optionC="Segundo", optionD="Newton", answer="B", image=null, level="A"),
            Question(id=4003, codeSubject="FIS", codeTopic="FIS-1", description="¿Qué representa un gráfico de posición vs tiempo?", optionA="La velocidad", optionB="La aceleración", optionC="La posición en función del tiempo", optionD="El desplazamiento total", answer="C", image=null, level="B"),
            Question(id=4004, codeSubject="FIS", codeTopic="FIS-1", description="¿Qué es la aceleración?", optionA="Cambio de posición en el tiempo", optionB="Cambio de velocidad en el tiempo", optionC="Distancia total recorrida", optionD="Rapidez constante", answer="B", image=null, level="B"),
            Question(id=4005, codeSubject="FIS", codeTopic="FIS-1", description="¿Qué es un movimiento rectilíneo uniforme?", optionA="Movimiento con aceleración constante", optionB="Movimiento con velocidad constante en línea recta", optionC="Movimiento circular", optionD="Movimiento oscilatorio", answer="B", image=null, level="A"),

            Question(id=4011, codeSubject="FIS", codeTopic="FIS-2", description="¿Qué afirma la primera ley de Newton o ley de inercia?", optionA="La fuerza es proporcional a la aceleración", optionB="Un objeto en reposo o en movimiento rectilíneo uniforme permanece así a menos que una fuerza externa actúe", optionC="Para cada acción hay una reacción igual y opuesta", optionD="La gravedad actúa siempre hacia abajo", answer="B", image=null, level="A"),
            Question(id=4012, codeSubject="FIS", codeTopic="FIS-2", description="¿Cuál es la fórmula que representa la segunda ley de Newton?", optionA="F = m/a", optionB="F = m * a", optionC="F = m + a", optionD="F = m - a", answer="B", image=null, level="B"),
            Question(id=4013, codeSubject="FIS", codeTopic="FIS-2", description="¿Qué tipo de fuerza mantiene a los planetas en órbita?", optionA="Fuerza electromagnética", optionB="Fuerza de gravedad", optionC="Fuerza nuclear fuerte", optionD="Fuerza de fricción", answer="B", image=null, level="B"),
            Question(id=4014, codeSubject="FIS", codeTopic="FIS-2", description="¿Qué ley de Newton explica la acción y reacción?", optionA="Primera ley", optionB="Segunda ley", optionC="Tercera ley", optionD="Ley de gravitación universal", answer="C", image=null, level="A"),
            Question(id=4015, codeSubject="FIS", codeTopic="FIS-2", description="¿Qué es la gravedad según Newton?", optionA="Una fuerza que atrae los objetos con masa", optionB="Una fuerza que repele los objetos", optionC="Una forma de energía", optionD="Una propiedad del tiempo", answer="A", image=null, level="B"),

            Question(id=4021, codeSubject="FIS", codeTopic="FIS-3", description="¿Qué es el trabajo en física?", optionA="Fuerza por desplazamiento", optionB="Energía sin desplazamiento", optionC="Velocidad multiplicada por tiempo", optionD="Masa por aceleración", answer="A", image=null, level="B"),
            Question(id=4022, codeSubject="FIS", codeTopic="FIS-3", description="¿Cuál es la unidad de trabajo en el Sistema Internacional?", optionA="Newton", optionB="Joule", optionC="Watt", optionD="Pascal", answer="B", image=null, level="A"),
            Question(id=4023, codeSubject="FIS", codeTopic="FIS-3", description="¿Qué ley establece la conservación de la energía?", optionA="Primera ley de Newton", optionB="Ley de gravitación universal", optionC="Primera ley de la termodinámica", optionD="Ley de conservación de la energía", answer="D", image=null, level="B"),
            Question(id=4024, codeSubject="FIS", codeTopic="FIS-3", description="¿Qué es la energía cinética?", optionA="Energía almacenada en objetos en reposo", optionB="Energía del movimiento", optionC="Energía térmica", optionD="Energía eléctrica", answer="B", image=null, level="B"),
            Question(id=4025, codeSubject="FIS", codeTopic="FIS-3", description="¿Qué relación existe entre trabajo y energía?", optionA="Son conceptos independientes", optionB="El trabajo realizado sobre un objeto cambia su energía", optionC="El trabajo es la fuerza sin desplazamiento", optionD="La energía es siempre constante", answer="B", image=null, level="C"),

            Question(id=4031, codeSubject="FIS", codeTopic="FIS-4", description="¿Qué estudia la termodinámica?", optionA="El movimiento de los cuerpos", optionB="Las transformaciones de la energía y el calor", optionC="La velocidad", optionD="La luz", answer="B", image=null, level="B"),
            Question(id=4032, codeSubject="FIS", codeTopic="FIS-4", description="¿Cuál es la ley cero de la termodinámica?", optionA="Si dos sistemas están en equilibrio térmico con un tercero, están en equilibrio entre sí", optionB="La energía se conserva", optionC="El calor fluye de frío a caliente", optionD="La entropía siempre disminuye", answer="A", image=null, level="C"),
            Question(id=4033, codeSubject="FIS", codeTopic="FIS-4", description="¿Qué es la entropía?", optionA="Una medida del desorden en un sistema", optionB="Energía almacenada", optionC="La energía térmica", optionD="Trabajo realizado", answer="A", image=null, level="C"),
            Question(id=4034, codeSubject="FIS", codeTopic="FIS-4", description="¿Qué indica la primera ley de la termodinámica?", optionA="La energía no se crea ni se destruye", optionB="El calor siempre fluye de caliente a frío", optionC="La energía se pierde", optionD="La presión aumenta con la temperatura", answer="A", image=null, level="B"),
            Question(id=4035, codeSubject="FIS", codeTopic="FIS-4", description="¿Cuál es una aplicación práctica de la termodinámica?", optionA="El motor de combustión interna", optionB="La luz visible", optionC="El sonido", optionD="La electricidad estática", answer="A", image=null, level="B"),

            Question(id=4041, codeSubject="FIS", codeTopic="FIS-5", description="¿Qué es una onda mecánica?", optionA="Una perturbación que se propaga en un medio", optionB="Una onda que no necesita medio", optionC="Una onda electromagnética", optionD="Una onda de luz", answer="A", image=null, level="B"),
            Question(id=4042, codeSubject="FIS", codeTopic="FIS-5", description="¿Cuál es la característica principal de una onda transversal?", optionA="Las partículas se mueven en la misma dirección que la onda", optionB="Las partículas se mueven perpendicularmente a la dirección de propagación", optionC="No tiene frecuencia", optionD="Viaja solo en líquidos", answer="B", image=null, level="B"),
            Question(id=4043, codeSubject="FIS", codeTopic="FIS-5", description="¿Qué propiedad de la onda determina su tono?", optionA="Amplitud", optionB="Frecuencia", optionC="Velocidad", optionD="Longitud de onda", answer="B", image=null, level="B"),
            Question(id=4044, codeSubject="FIS", codeTopic="FIS-5", description="¿Qué es la interferencia de ondas?", optionA="La superposición de dos o más ondas", optionB="La reflexión de una onda", optionC="La absorción de energía", optionD="La dispersión de luz", answer="A", image=null, level="C"),
            Question(id=4045, codeSubject="FIS", codeTopic="FIS-5", description="¿Cuál es la velocidad aproximada del sonido en el aire?", optionA="340 m/s", optionB="3,000 m/s", optionC="150 m/s", optionD="1,000 m/s", answer="A", image=null, level="B"),

            Question(id=4051, codeSubject="FIS", codeTopic="FIS-6", description="¿Qué estudia el electromagnetismo?", optionA="La interacción entre cargas eléctricas y campos magnéticos", optionB="El movimiento de los cuerpos", optionC="La propagación de ondas sonoras", optionD="La termodinámica", answer="A", image=null, level="B"),
            Question(id=4052, codeSubject="FIS", codeTopic="FIS-6", description="¿Cuál es la unidad de carga eléctrica?", optionA="Coulomb", optionB="Voltio", optionC="Amperio", optionD="Ohmio", answer="A", image=null, level="A"),
            Question(id=4053, codeSubject="FIS", codeTopic="FIS-6", description="¿Qué representa la Ley de Ohm?", optionA="V = I * R", optionB="F = m * a", optionC="E = mc²", optionD="P = W / t", answer="A", image=null, level="B"),
            Question(id=4054, codeSubject="FIS", codeTopic="FIS-6", description="¿Qué es un campo magnético?", optionA="Una región donde una fuerza magnética es detectable", optionB="Una partícula subatómica", optionC="Un tipo de energía", optionD="Un tipo de radiación", answer="A", image=null, level="B"),
            Question(id=4055, codeSubject="FIS", codeTopic="FIS-6", description="¿Qué partículas son responsables de la corriente eléctrica?", optionA="Protones", optionB="Neutrones", optionC="Electrones", optionD="Fotones", answer="C", image=null, level="B"),
        )
    }

    fun getSpanishQuestions(): List<Question> {
        return listOf(
            Question(201, "ESP", "ESP-1", "¿Cuál es la principal función de la lengua en la comunicación humana?", "Expresar sentimientos", "Transmitir información", "Ordenar ideas", "Reforzar la memoria", "B", null, "A"),
            Question(202, "ESP", "ESP-1", "¿Qué elementos intervienen en el proceso comunicativo?", "Receptor, canal y código", "Emisor, receptor, canal y código", "Emisor, receptor y mensaje", "Mensaje y contexto", "B", null, "A"),
            Question(203, "ESP", "ESP-1", "¿Qué es un canal en la comunicación?", "El medio físico por el que se transmite el mensaje", "El contenido del mensaje", "El lenguaje usado", "El contexto de la situación", "A", null, "A"),
            Question(204, "ESP", "ESP-1", "¿Qué tipo de lenguaje utilizamos al hablar con amigos?", "Formal", "Académico", "Informal", "Técnico", "C", null, "A"),
            Question(205, "ESP", "ESP-1", "¿Qué función del lenguaje predomina en una orden?", "Referencial", "Apelativa", "Fática", "Poética", "B", null, "A"),

            Question(206, "ESP", "ESP-2", "¿Qué tipo de texto busca convencer al lector?", "Narrativo", "Descriptivo", "Expositivo", "Argumentativo", "D", null, "A"),
            Question(207, "ESP", "ESP-2", "¿Cuál es la principal característica de un texto descriptivo?", "Presenta hechos", "Describe cualidades", "Cuenta una historia", "Argumenta ideas", "B", null, "A"),
            Question(208, "ESP", "ESP-2", "¿Qué texto se enfoca en informar objetivamente?", "Narrativo", "Expositivo", "Argumentativo", "Descriptivo", "B", null, "A"),
            Question(209, "ESP", "ESP-2", "¿Cuál es una forma discursiva que relata sucesos en orden cronológico?", "Argumentativa", "Narrativa", "Expositiva", "Descriptiva", "B", null, "A"),
            Question(210, "ESP", "ESP-2", "¿Qué se busca en un texto argumentativo?", "Narrar hechos", "Describir lugares", "Convencer con razones", "Informar datos", "C", null, "A"),

            Question(211, "ESP", "ESP-3", "¿Qué se evalúa al comprender un texto?", "Ortografía", "Lectura en voz alta", "Entonación", "Interpretación del contenido", "D", null, "A"),
            Question(212, "ESP", "ESP-3", "¿Qué es una idea principal?", "Una anécdota", "Un dato secundario", "La información más relevante del texto", "Un ejemplo", "C", null, "A"),
            Question(213, "ESP", "ESP-3", "¿Qué permite la lectura crítica?", "Memorizar datos", "Comprender mejor la ortografía", "Cuestionar e interpretar la información", "Leer más rápido", "C", null, "A"),
            Question(214, "ESP", "ESP-3", "¿Qué se debe identificar primero al leer un texto?", "El título", "El tema principal", "El autor", "La editorial", "B", null, "A"),
            Question(215, "ESP", "ESP-3", "¿Qué indica un conector como 'por lo tanto'?", "Contraste", "Causa", "Consecuencia", "Tiempo", "C", null, "A"),

            Question(216, "ESP", "ESP-4", "¿Qué clase de palabra indica acción?", "Sustantivo", "Adjetivo", "Verbo", "Adverbio", "C", null, "A"),
            Question(217, "ESP", "ESP-4", "¿Cuál es un ejemplo de adjetivo?", "Correr", "Bonito", "Casa", "Rápidamente", "B", null, "A"),
            Question(218, "ESP", "ESP-4", "¿Qué función tiene el sustantivo en una oración?", "Describe", "Modifica", "Nombrar personas, objetos o lugares", "Expresa acciones", "C", null, "A"),
            Question(219, "ESP", "ESP-4", "¿Qué indica el tiempo verbal?", "Cantidad", "Lugar", "Momento de la acción", "Intención", "C", null, "A"),
            Question(220, "ESP", "ESP-4", "¿Cuál es una oración en tiempo futuro?", "Yo comí", "Él come", "Nosotros comeremos", "Tú comías", "C", null, "A"),

            Question(221, "ESP", "ESP-5", "¿Qué es un párrafo?", "Una palabra aislada", "Un conjunto de frases sin relación", "Una oración larga", "Un conjunto de oraciones sobre una idea principal", "D", null, "A"),
            Question(222, "ESP", "ESP-5", "¿Qué debe tener una introducción?", "Conclusiones", "Desarrollo de ideas", "Presentación del tema", "Bibliografía", "C", null, "A"),
            Question(223, "ESP", "ESP-5", "¿Qué conecta ideas en un texto?", "Oraciones simples", "Puntos y comas", "Conectores", "Signos de interrogación", "C", null, "A"),
            Question(224, "ESP", "ESP-5", "¿Cuál es la función del desarrollo en un texto?", "Presentar el tema", "Dar ejemplos y argumentos", "Finalizar ideas", "Redactar el título", "B", null, "A"),
            Question(225, "ESP", "ESP-5", "¿Qué caracteriza una conclusión efectiva?", "Introduce nuevas ideas", "Resume y cierra el texto", "Evita opiniones", "Amplía el tema", "B", null, "A"),

            Question(226, "ESP", "ESP-6", "¿Qué es un sinónimo de ‘feliz’?", "Triste", "Alegre", "Cansado", "Serio", "B", null, "A"),
            Question(227, "ESP", "ESP-6", "¿Qué es un antónimo?", "Una palabra compuesta", "Una palabra con significado opuesto", "Una palabra técnica", "Una palabra inventada", "B", null, "A"),
            Question(228, "ESP", "ESP-6", "¿Qué significa ‘sustituir’?", "Romper", "Colocar junto", "Reemplazar", "Aumentar", "C", null, "A"),
            Question(229, "ESP", "ESP-6", "¿Qué palabra es un sinónimo de ‘rápido’?", "Veloz", "Lento", "Despacio", "Parado", "A", null, "A"),
            Question(230, "ESP", "ESP-6", "¿Qué palabra es un antónimo de ‘grande’?", "Alto", "Pequeño", "Ancho", "Enorme", "B", null, "A"),

            Question(231, "ESP", "ESP-7", "¿Cuál es la forma correcta?", "Hizo un oyito", "Hizo un hoyito", "Hizo un hoito", "Hizo un oíto", "B", null, "A"),
            Question(232, "ESP", "ESP-7", "¿Cuál palabra está escrita correctamente?", "Esajerar", "Exagerar", "Exajerar", "Esagerar", "B", null, "A"),
            Question(233, "ESP", "ESP-7", "¿Qué signo indica una pausa breve?", "Punto", "Coma", "Dos puntos", "Punto y coma", "B", null, "A"),
            Question(234, "ESP", "ESP-7", "¿Cómo se escribe correctamente?", "A ser el trabajo", "Hacer el trabajo", "Hacer él trabajo", "Aser el trabajo", "B", null, "A"),
            Question(235, "ESP", "ESP-7", "¿Cuál es la forma correcta?", "Hiba a salir", "Iva a salir", "Iba a salir", "Hiva a salir", "C", null, "A"),
        )
    }

    fun getGeographyQuestions(): List<Question> {
        return listOf(
            // Tema: La Tierra, base del desarrollo del hombre (GEO-1)
            Question(id=2001, codeSubject="GEO", codeTopic="GEO-1", description="¿Cuál es la principal característica que hace a la Tierra habitable para el ser humano?", optionA="Su atmósfera y temperatura", optionB="Su cercanía al Sol", optionC="Su superficie líquida", optionD="Su composición de gases nobles", answer="A", image=null, level="A"),
            Question(id=2002, codeSubject="GEO", codeTopic="GEO-1", description="¿Qué capa de la Tierra está formada principalmente por roca sólida?", optionA="Núcleo externo", optionB="Manto", optionC="Corteza", optionD="Núcleo interno", answer="C", image=null, level="B"),
            Question(id=2003, codeSubject="GEO", codeTopic="GEO-1", description="¿Qué fenómeno explica la formación de montañas y terremotos?", optionA="Erosión", optionB="Movimiento de placas tectónicas", optionC="Sedimentación", optionD="Viento", answer="B", image=null, level="B"),
            Question(id=2004, codeSubject="GEO", codeTopic="GEO-1", description="¿Cuál es el porcentaje aproximado de agua que cubre la superficie terrestre?", optionA="30%", optionB="50%", optionC="70%", optionD="90%", answer="C", image=null, level="A"),
            Question(id=2005, codeSubject="GEO", codeTopic="GEO-1", description="¿Qué recurso natural ha sido fundamental para el desarrollo de las primeras civilizaciones humanas?", optionA="Petróleo", optionB="Agua dulce", optionC="Carbón", optionD="Gas natural", answer="B", image=null, level="A"),

            // Tema: Geografía humana: el paisaje cultural (espacio geográfico) (GEO-2)
            Question(id=2011, codeSubject="GEO", codeTopic="GEO-2", description="¿Qué estudia la geografía humana?", optionA="El relieve terrestre", optionB="La relación entre los humanos y su entorno", optionC="Los fenómenos atmosféricos", optionD="Las formaciones rocosas", answer="B", image=null, level="A"),
            Question(id=2012, codeSubject="GEO", codeTopic="GEO-2", description="¿Qué es el paisaje cultural?", optionA="Un paisaje natural sin intervención humana", optionB="El conjunto de elementos creados por la actividad humana en un espacio", optionC="Una zona protegida por ley", optionD="Un área exclusivamente rural", answer="B", image=null, level="A"),
            Question(id=2013, codeSubject="GEO", codeTopic="GEO-2", description="¿Cuál de los siguientes es un ejemplo de paisaje cultural?", optionA="Selva tropical", optionB="Ciudad histórica", optionC="Desierto", optionD="Glaciar", answer="B", image=null, level="A"),
            Question(id=2014, codeSubject="GEO", codeTopic="GEO-2", description="¿Qué factores influyen en la configuración del espacio geográfico?", optionA="Solo factores naturales", optionB="Factores económicos, sociales y naturales", optionC="Únicamente la política", optionD="Solo la tecnología", answer="B", image=null, level="B"),
            Question(id=2015, codeSubject="GEO", codeTopic="GEO-2", description="¿Qué herramienta es fundamental para el estudio del espacio geográfico?", optionA="Mapa", optionB="Microscopio", optionC="Telescopio", optionD="Cámara fotográfica", answer="A", image=null, level="A"),
        )
    }

    fun getLiteratureQuestions(): List<Question> {
        return listOf(
            // Tema: El texto (LIT-1)
            Question(id=1001, codeSubject="LIT", codeTopic="LIT-1", description="¿Qué es un texto literario?", optionA="Un texto informativo", optionB="Un texto que transmite emociones y experiencias", optionC="Un texto técnico", optionD="Un texto publicitario", answer="B", image=null, level="A"),
            Question(id=1002, codeSubject="LIT", codeTopic="LIT-1", description="¿Cuál es la función principal de un texto narrativo?", optionA="Informar datos", optionB="Describir un paisaje", optionC="Contar una historia", optionD="Persuadir al lector", answer="C", image=null, level="A"),
            Question(id=1003, codeSubject="LIT", codeTopic="LIT-1", description="¿Qué elemento no pertenece a la estructura básica de un texto?", optionA="Introducción", optionB="Cuerpo", optionC="Conclusión", optionD="Índice", answer="D", image=null, level="B"),
            Question(id=1004, codeSubject="LIT", codeTopic="LIT-1", description="¿Qué recurso literario consiste en la repetición de sonidos similares?", optionA="Metáfora", optionB="Aliteración", optionC="Hipérbole", optionD="Personificación", answer="B", image=null, level="B"),
            Question(id=1005, codeSubject="LIT", codeTopic="LIT-1", description="¿Cuál es el propósito principal del texto expositivo?", optionA="Entretener", optionB="Explicar o informar", optionC="Convencer", optionD="Describir emociones", answer="B", image=null, level="A"),

            // Tema: Géneros y corrientes literarias (LIT-2)
            Question(id=1011, codeSubject="LIT", codeTopic="LIT-2", description="¿Cuál es un género literario fundamental?", optionA="Narrativo", optionB="Periodístico", optionC="Científico", optionD="Legal", answer="A", image=null, level="A"),
            Question(id=1012, codeSubject="LIT", codeTopic="LIT-2", description="¿Qué corriente literaria se caracteriza por la objetividad y el rechazo a lo subjetivo?", optionA="Realismo", optionB="Romanticismo", optionC="Modernismo", optionD="Surrealismo", answer="A", image=null, level="B"),
            Question(id=1013, codeSubject="LIT", codeTopic="LIT-2", description="¿Cuál de estas obras pertenece al Romanticismo?", optionA="Don Quijote", optionB="Cien años de soledad", optionC="Los miserables", optionD="El canto de las sirenas", answer="C", image=null, level="B"),
            Question(id=1014, codeSubject="LIT", codeTopic="LIT-2", description="¿Qué género literario está relacionado con la representación teatral?", optionA="Poesía", optionB="Ensayo", optionC="Drama", optionD="Novela", answer="C", image=null, level="A"),
            Question(id=1015, codeSubject="LIT", codeTopic="LIT-2", description="¿Qué característica define al Modernismo?", optionA="Rechazo al simbolismo", optionB="Búsqueda de la belleza formal", optionC="Predominio del realismo social", optionD="Uso exclusivo del verso libre", answer="B", image=null, level="B"),

            // Tema: Redacción y técnicas de investigación documental (LIT-3)
            Question(id=1021, codeSubject="LIT", codeTopic="LIT-3", description="¿Qué es la redacción?", optionA="Proceso de creación y organización de textos", optionB="Lectura rápida de textos", optionC="Corrección de errores ortográficos", optionD="Recopilación de datos", answer="A", image=null, level="A"),
            Question(id=1022, codeSubject="LIT", codeTopic="LIT-3", description="¿Cuál es una técnica básica de investigación documental?", optionA="Entrevistas personales", optionB="Consulta de fuentes bibliográficas", optionC="Experimentos de laboratorio", optionD="Observación directa", answer="B", image=null, level="A"),
            Question(id=1023, codeSubject="LIT", codeTopic="LIT-3", description="¿Qué se debe evitar en la redacción académica?", optionA="Claridad y precisión", optionB="Plagio y copia textual sin citar", optionC="Uso de citas bibliográficas", optionD="Organización lógica", answer="B", image=null, level="A"),
            Question(id=1024, codeSubject="LIT", codeTopic="LIT-3", description="¿Qué elemento debe incluir una ficha bibliográfica?", optionA="Resumen del texto", optionB="Datos de la fuente consultada", optionC="Opinión personal", optionD="Título del capítulo", answer="B", image=null, level="B"),
            Question(id=1025, codeSubject="LIT", codeTopic="LIT-3", description="¿Cuál es la función de un índice en un trabajo escrito?", optionA="Presentar la conclusión", optionB="Enumerar capítulos y secciones con su ubicación", optionC="Resumir el contenido", optionD="Introducir el tema", answer="B", image=null, level="B"),
        )
    }

    fun getPhilosophyQuestions(): List<Question> {
        return listOf(
            // Tema: Lógica (FIL-1)
            Question(id=3001, codeSubject="FIL", codeTopic="FIL-1", description="¿Qué estudia la lógica en filosofía?", optionA="Las leyes del pensamiento correcto", optionB="La ética", optionC="La historia de la filosofía", optionD="La estética", answer="A", image=null, level="B"),
            Question(id=3002, codeSubject="FIL", codeTopic="FIL-1", description="¿Cuál es un ejemplo de argumento válido?", optionA="Si llueve, la calle está mojada. Está lloviendo. Por lo tanto, la calle está mojada.", optionB="La calle está mojada, por lo tanto llueve.", optionC="Si estudio, aprobaré. No aprobé, entonces no estudié.", optionD="Si estudio, aprobaré. No aprobé, por lo tanto estudiaré.", answer="A", image=null, level="B"),
            Question(id=3003, codeSubject="FIL", codeTopic="FIL-1", description="¿Qué es una falacia lógica?", optionA="Un razonamiento correcto", optionB="Un error en el razonamiento", optionC="Una teoría ética", optionD="Un método científico", answer="B", image=null, level="B"),
            Question(id=3004, codeSubject="FIL", codeTopic="FIL-1", description="¿Qué tipo de lógica estudia las proposiciones y sus relaciones?", optionA="Lógica simbólica", optionB="Lógica inductiva", optionC="Lógica formal", optionD="Lógica deductiva", answer="C", image=null, level="C"),
            Question(id=3005, codeSubject="FIL", codeTopic="FIL-1", description="¿Cuál es el principio de no contradicción?", optionA="Una proposición puede ser verdadera y falsa al mismo tiempo", optionB="Una proposición no puede ser verdadera y falsa simultáneamente", optionC="Todo es relativo", optionD="Nada existe", answer="B", image=null, level="B"),

            // Tema: Ética (FIL-2)
            Question(id=3011, codeSubject="FIL", codeTopic="FIL-2", description="¿Qué estudia la ética?", optionA="La naturaleza del ser", optionB="Los principios del comportamiento moral", optionC="Las leyes físicas", optionD="La estructura del lenguaje", answer="B", image=null, level="A"),
            Question(id=3012, codeSubject="FIL", codeTopic="FIL-2", description="¿Cuál filósofo es conocido por la ética del deber?", optionA="Aristóteles", optionB="Immanuel Kant", optionC="John Stuart Mill", optionD="Friedrich Nietzsche", answer="B", image=null, level="B"),
            Question(id=3013, codeSubject="FIL", codeTopic="FIL-2", description="¿Qué significa el utilitarismo?", optionA="Buscar el máximo bienestar para el mayor número", optionB="Obedecer normas sin cuestionar", optionC="Priorizar el deber individual", optionD="Negar la existencia del bien y el mal", answer="A", image=null, level="B"),
            Question(id=3014, codeSubject="FIL", codeTopic="FIL-2", description="¿Qué es la ética aplicada?", optionA="Estudio de problemas morales concretos", optionB="Teoría general de la moral", optionC="Estudio de lógica formal", optionD="Análisis de textos antiguos", answer="A", image=null, level="B"),
            Question(id=3015, codeSubject="FIL", codeTopic="FIL-2", description="¿Cuál es un valor ético fundamental?", optionA="Verdad", optionB="Belleza", optionC="Potencia", optionD="Cantidad", answer="A", image=null, level="A"),

            // Tema: Disciplinas y problemas de la Filosofía (FIL-3)
            Question(id=3021, codeSubject="FIL", codeTopic="FIL-3", description="¿Cuál es una disciplina principal de la filosofía?", optionA="Matemáticas", optionB="Metafísica", optionC="Biología", optionD="Psicología", answer="B", image=null, level="A"),
            Question(id=3022, codeSubject="FIL", codeTopic="FIL-3", description="¿Qué problema aborda la epistemología?", optionA="La naturaleza del conocimiento", optionB="La estructura del universo", optionC="Las leyes físicas", optionD="Los sistemas económicos", answer="A", image=null, level="B"),
            Question(id=3023, codeSubject="FIL", codeTopic="FIL-3", description="¿Cuál es el objeto de estudio de la estética?", optionA="La belleza y el arte", optionB="La lógica", optionC="La ética", optionD="La política", answer="A", image=null, level="A"),
            Question(id=3024, codeSubject="FIL", codeTopic="FIL-3", description="¿Qué filósofo es conocido por cuestionar todo con la duda metódica?", optionA="Sócrates", optionB="Descartes", optionC="Platón", optionD="Aristóteles", answer="B", image=null, level="B"),
            Question(id=3025, codeSubject="FIL", codeTopic="FIL-3", description="¿Qué disciplina filosófica estudia el ser y la existencia?", optionA="Ontología", optionB="Lógica", optionC="Epistemología", optionD="Ética", answer="A", image=null, level="B"),
        )
    }

     */


}