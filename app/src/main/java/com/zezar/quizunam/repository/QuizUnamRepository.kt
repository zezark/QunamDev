package com.zezar.quizunam.repository

import com.zezar.quizunam.model.Field
import com.zezar.quizunam.model.Question
import com.zezar.quizunam.model.Subject
import com.zezar.quizunam.model.Topic

object QuizUnamRepository {



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

            Question(
                id = 1,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el resultado de 2x + 3x?",
                optionA = "5",
                optionB = "5x",
                optionC = "6x",
                optionD = "2x^3",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 2,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el valor de x en la ecuación 2x = 8?",
                optionA = "2",
                optionB = "4",
                optionC = "8",
                optionD = "16",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 1,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el resultado de 2x + 3x?",
                optionA = "5",
                optionB = "5x",
                optionC = "6x",
                optionD = "2x^3",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 2,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el valor de x en la ecuación 2x = 8?",
                optionA = "2",
                optionB = "4",
                optionC = "8",
                optionD = "16",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 1,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el resultado de 2x + 3x?",
                optionA = "5",
                optionB = "5x",
                optionC = "6x",
                optionD = "2x^3",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 2,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el valor de x en la ecuación 2x = 8?",
                optionA = "2",
                optionB = "4",
                optionC = "8",
                optionD = "16",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 1,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el resultado de 2x + 3x?",
                optionA = "5",
                optionB = "5x",
                optionC = "6x",
                optionD = "2x^3",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 2,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el valor de x en la ecuación 2x = 8?",
                optionA = "2",
                optionB = "4",
                optionC = "8",
                optionD = "16",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 1,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el resultado de 2x + 3x?",
                optionA = "5",
                optionB = "5x",
                optionC = "6x",
                optionD = "2x^3",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 2,
                codeSubject = "MAT",
                codeTopic = "ALG",
                description = "¿Cuál es el valor de x en la ecuación 2x = 8?",
                optionA = "2",
                optionB = "4",
                optionC = "8",
                optionD = "16",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 3,
                codeSubject = "MAT",
                codeTopic = "GEO",
                description = "¿Cuál es la suma de los ángulos interiores de un triángulo?",
                optionA = "180°",
                optionB = "90°",
                optionC = "360°",
                optionD = "270°",
                answer = "A",
                image = null,
                level = "A"
            ),
            Question(
                id = 101,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "¿Cuál es el nivel más básico de organización de la materia viva?",
                optionA = "Célula",
                optionB = "Molécula",
                optionC = "Átomo",
                optionD = "Tejido",
                answer = "C",
                image = null,
                level = "A"
            ),
            Question(
                id = 102,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "¿Qué nivel de organización se encuentra entre el órgano y el organismo?",
                optionA = "Célula",
                optionB = "Sistema",
                optionC = "Tejido",
                optionD = "Molécula",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 103,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "¿Cuál de los siguientes ejemplos corresponde al nivel de tejido?",
                optionA = "Sistema nervioso",
                optionB = "Piel",
                optionC = "Neurona",
                optionD = "Epitelio",
                answer = "D",
                image = null,
                level = "A"
            ),
            Question(
                id = 104,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "Ordena correctamente los niveles de organización: célula, órgano, tejido, sistema.",
                optionA = "Célula → Tejido → Órgano → Sistema",
                optionB = "Célula → Órgano → Tejido → Sistema",
                optionC = "Tejido → Célula → Sistema → Órgano",
                optionD = "Sistema → Órgano → Tejido → Célula",
                answer = "A",
                image = null,
                level = "A"
            ),
            Question(
                id = 105,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "¿En qué nivel de organización se encuentra una proteína?",
                optionA = "Célula",
                optionB = "Organelo",
                optionC = "Molécula",
                optionD = "Tejido",
                answer = "C",
                image = null,
                level = "A"
            ),
            Question(
                id = 106,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "¿Cuál de los siguientes es un ejemplo de nivel de organización supramolecular?",
                optionA = "Átomo",
                optionB = "Molécula",
                optionC = "Membrana celular",
                optionD = "Tejido epitelial",
                answer = "C",
                image = null,
                level = "A"
            ),
            Question(
                id = 107,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "¿Qué nivel de organización incluye a individuos de la misma especie que habitan un área común?",
                optionA = "Comunidad",
                optionB = "Ecosistema",
                optionC = "Población",
                optionD = "Biosfera",
                answer = "C",
                image = null,
                level = "A"
            ),
            Question(
                id = 108,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "¿Qué nivel de organización representa un conjunto de órganos que cumplen una función específica?",
                optionA = "Organismo",
                optionB = "Sistema",
                optionC = "Tejido",
                optionD = "Órgano",
                answer = "B",
                image = null,
                level = "A"
            ),
            Question(
                id = 109,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "¿Cuál de los siguientes niveles de organización es el más complejo?",
                optionA = "Tejido",
                optionB = "Célula",
                optionC = "Sistema",
                optionD = "Órgano",
                answer = "C",
                image = null,
                level = "A"
            ),
            Question(
                id = 110,
                codeSubject = "BIO",
                codeTopic = "BIO-1",
                description = "¿Cuál de estos ejemplos pertenece al nivel ecológico de organización?",
                optionA = "Cloroplasto",
                optionB = "Comunidad",
                optionC = "Sistema digestivo",
                optionD = "Mitocondria",
                answer = "B",
                image = null,
                level = "A"
            )
        )
    }

}