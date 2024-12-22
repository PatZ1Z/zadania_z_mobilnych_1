package com.example.zadania_z_mobilnych_1

class StepCounter {
    companion object {
        private var stepCount: Int = 0

        fun incrementStep() {
            stepCount++
        }

        fun resetSteps() {
            stepCount = 0
        }

        fun getStepCount(): Int {
            return stepCount
        }
    }

    fun takeStep() {
        incrementStep()
        println("You took a step! Total steps: ${getStepCount()}")
    }
}

fun main() {
    val stepCounter = StepCounter()
    while (true) {
        println("Step Counter Menu:")
        println("1. Take a step")
        println("2. Reset step counter")
        println("3. Show total steps")
        println("4. Exit")

        when (readLine()?.toIntOrNull()) {
            1 -> stepCounter.takeStep()
            2 -> {
                StepCounter.resetSteps()
                println("Step counter reset to 0.")
            }
            3 -> println("Total steps: ${StepCounter.getStepCount()}")
            4 -> {
                println("Exiting the Step Counter. Goodbye!")
                break
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}