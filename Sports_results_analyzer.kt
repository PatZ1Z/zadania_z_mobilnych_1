package com.example.zadania_z_mobilnych_1

class SportsResultsAnalyzer {
    private val results = mutableListOf<Int>()

    fun addResult(score: Int) {
        results.add(score)
        println("Added score: $score")
    }

    fun filterResults(threshold: Int) {
        val filtered = results.filter { it > threshold }
        println("Results above $threshold: $filtered")
    }

    fun addBonusPoints(bonus: Int) {
        val updatedResults = results.map { it + bonus }
        println("Updated results with bonus: $updatedResults")
    }

    fun sumResults() {
        println("Total sum of results: ${results.sum()}")
    }

    fun maxResult() {
        val max = results.maxOrNull()
        println("Maximum result: ${max ?: "No results available."}")
    }

    fun differenceBetweenMaxAndMin() {
        val max = results.maxOrNull()
        val min = results.minOrNull()
        if (max != null && min != null) {
            println("Difference between max and min result: ${max - min}")
        } else {
            println("No results available.")
        }
    }

    fun countMatchesAbove(threshold: Int) {
        val count = results.count { it > threshold }
        println("Number of matches above $threshold: $count")
    }
}

fun main() {
    val analyzer = SportsResultsAnalyzer()

    while (true) {
        println("Sports Results Analyzer Menu:")
        println("1. Add match result")
        println("2. Filter results above threshold")
        println("3. Add bonus points to all results")
        println("4. Sum all results")
        println("5. Find maximum result")
        println("6. Find difference between max and min result")
        println("7. Count matches above threshold")
        println("8. Exit")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Enter match result:")
                val score = readLine()?.toIntOrNull()
                if (score != null) {
                    analyzer.addResult(score)
                } else {
                    println("Invalid input. Please enter a number.")
                }
            }
            2 -> {
                println("Enter threshold:")
                val threshold = readLine()?.toIntOrNull()
                if (threshold != null) {
                    analyzer.filterResults(threshold)
                } else {
                    println("Invalid input. Please enter a number.")
                }
            }
            3 -> {
                println("Enter bonus points:")
                val bonus = readLine()?.toIntOrNull()
                if (bonus != null) {
                    analyzer.addBonusPoints(bonus)
                } else {
                    println("Invalid input. Please enter a number.")
                }
            }
            4 -> analyzer.sumResults()
            5 -> analyzer.maxResult()
            6 -> analyzer.differenceBetweenMaxAndMin()
            7 -> {
                println("Enter threshold:")
                val threshold = readLine()?.toIntOrNull()
                if (threshold != null) {
                    analyzer.countMatchesAbove(threshold)
                } else {
                    println("Invalid input. Please enter a number.")
                }
            }
            8 -> {
                println("Exiting the Sports Results Analyzer. Goodbye!")
                break
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}