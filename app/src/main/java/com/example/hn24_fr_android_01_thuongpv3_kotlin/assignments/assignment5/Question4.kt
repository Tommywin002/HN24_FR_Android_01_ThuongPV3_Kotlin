package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment5

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    var total = 0
    val channel = Channel<Int>()
    runBlocking {
        launch {
            while (total > -100 || total < 100) {
                val randomNumber = Random.nextInt(-100, 1)
                println("First number: $randomNumber")
                channel.send(randomNumber)
                delay(1000)
            }
        }
        launch {
            while (total > -100 || total < 100) {
                val randomMinusNumber = Random.nextInt(0, 101)
                println("Second number: $randomMinusNumber")
                val firstNumber = channel.receive()
                total = randomMinusNumber + firstNumber
                println("Total: $total")
                delay(1000)
            }
        }
    }
}

