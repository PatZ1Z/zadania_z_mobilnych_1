package com.example.zadania_z_mobilnych_1

import kotlin.random.Random

object QuotesToSigleton{
    var QuotesList = mutableListOf(
        "The only way to do great work is to love what you do.",
        "Success is not final, failure is not fatal: It is the courage to continue that counts.",
        "Life is what happens when you're busy making other plans.",
        "In the middle of every difficulty lies opportunity.",
        "Your time is limited, so don’t waste it living someone else’s life.",
        "It always seems impossible until it’s done.",
        "Don’t wait. The time will never be just right.",
        "Success is not how high you have climbed, but how you make a positive difference to the world.",
        "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.",
        "The best way to predict your future is to create it."
    )

    fun GetQuotes(): List<String>{
        return QuotesList
    }

}


object QuotesControl{
    var Quotes = QuotesToSigleton.GetQuotes()
    var NumberOfQuotes = Quotes.size

    fun addQuote(AddQuote: String){
        QuotesToSigleton.QuotesList.add(AddQuote)
    }

    fun getRandomQuote(){
        var rnd = Random.nextInt(0, NumberOfQuotes + 1)

        println(Quotes[rnd])
    }
}

fun main(){

    QuotesControl.addQuote("Coś tam, Coś tam co podniesie cie na duchu")
    QuotesControl.getRandomQuote()
}