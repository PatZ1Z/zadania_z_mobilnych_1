package com.example.zadania_z_mobilnych_1



// Interfejs IPytanie
interface IPytanie {
    fun zadawajPytanie()           // Metoda do zadawania pytania
    fun sprawdzOdpowiedz(odpowiedz: Int): Boolean // Metoda do sprawdzania odpowiedzi
}

// Klasa PytanieWielokrotnegoWyboru
class PytanieWielokrotnegoWyboru(
    private val pytanie: String,
    private val odpowiedzi: Array<String>,
    private val poprawnaOdpowiedz: Int
) : IPytanie {

    // Implementacja metody interfejsu IPytanie
    override fun zadawajPytanie() {
        println(pytanie)
        for ((index, odpowiedz) in odpowiedzi.withIndex()) {
            println("${index + 1}. $odpowiedz")
        }
    }

    // Implementacja metody interfejsu IPytanie
    override fun sprawdzOdpowiedz(odpowiedz: Int): Boolean {
        return odpowiedz == poprawnaOdpowiedz
    }
}

// Klasa PytaniePrawdaFalsz
class PytaniePrawdaFalsz(
    private val pytanie: String,
    private val poprawnaOdpowiedz: Int // 1 = Prawda, 2 = Fałsz
) : IPytanie {

    // Implementacja metody interfejsu IPytanie
    override fun zadawajPytanie() {
        println(pytanie)
        println("1. Prawda")
        println("2. Fałsz")
    }

    // Implementacja metody interfejsu IPytanie
    override fun sprawdzOdpowiedz(odpowiedz: Int): Boolean {
        return odpowiedz == poprawnaOdpowiedz
    }
}

// Klasa Quiz
class Quiz(private val pytania: List<IPytanie>) {

    private var wynik = 0

    fun rozpocznij() {
        for (pytanie in pytania) {
            pytanie.zadawajPytanie()
            var odpowiedz: Int

            // Sprawdzanie, czy użytkownik podał prawidłową liczbę
            while (true) {
                val input = readLine()
                if (input != null && input.toIntOrNull() != null && input.toInt() in 1..2) {
                    odpowiedz = input.toInt()
                    break
                } else {
                    println("Wprowadź prawidłową odpowiedź (liczba 1 lub 2). Spróbuj ponownie.")
                }
            }

            if (pytanie.sprawdzOdpowiedz(odpowiedz)) {
                println("Poprawna odpowiedź!")
                wynik++
            } else {
                println("Niepoprawna odpowiedź!")
            }
            println()
        }

        println("Twój wynik: $wynik/${pytania.size}")
    }
}

// Program główny
fun main() {
    // Tworzenie pytań
    val pytanie1 = PytanieWielokrotnegoWyboru(
        "Jakie jest największe miasto w Polsce?",
        arrayOf("Warszawa", "Kraków", "Gdańsk", "Poznań"),
        1 // Poprawna odpowiedź: Warszawa (1)
    )

    val pytanie2 = PytaniePrawdaFalsz(
        "Czy Ziemia jest płaska?",
        2 // Poprawna odpowiedź: Fałsz (2)
    )

    // Dodanie pytań do quizu
    val pytania = listOf(pytanie1, pytanie2)

    // Tworzenie obiektu quizu
    val quiz = Quiz(pytania)

    // Rozpoczęcie quizu
    quiz.rozpocznij()
}
