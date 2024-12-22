package com.example.zadania_z_mobilnych_1

import kotlin.random.Random

interface RollingTool{
    fun roll();
}

class Coin : RollingTool{

    override  fun roll(){
        var rnd = Random.nextInt(1,3)
        if(rnd == 1){
            println("Heads")
        }
        else{
            println("Tails")
        }
    }
}

class Dice : RollingTool{
    override fun roll(){
        var rnd = Random.nextInt(1,7)
        println("You got: ")
        when(rnd){
            1 -> {println("1")}
            2 -> {println("2")}
            3 -> {println("3")}
            4 -> {println("4")}
            5 -> {println("5")}
            6 -> {println("6")}

        }
    }


}


fun main(){
    println("1 - Coin flip")
    println("2 - Dice roll")
    var input = readln().toInt()
    if(input == 1){
        val coin = Coin()
        coin.roll()
    }
    if(input == 2){
        val dice = Dice()
        dice.roll()
    }
}
