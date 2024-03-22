package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment5

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    val channel1 = Channel<Int>()
    runBlocking {
        launch {
            while (true) {
                val randomNumber = Random.nextInt(1, 21)
                println(randomNumber)
                channel1.send(randomNumber)
                delay(2000)
            }
        }
        launch {
            while (true) {
                val number = channel1.receive()
                val square = number * number
                println(square)
                println()
            }
        }
    }
}
