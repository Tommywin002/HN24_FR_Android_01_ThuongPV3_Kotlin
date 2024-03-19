package com.example.trainingkotlin.lectures.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.*

fun main() {

//    //demo
//    runBlocking {
//        val channel = Channel<Int>()
//        launch {
//            for (x in 1..5){
//                channel.send(x*x)
//            }
//        }
//        repeat(5){
//            println(channel.receive())
//        }
//        println("done")
//    }

//    //Iteration over
//    runBlocking {
//        val channel = Channel<Int>()
//        launch {
//            for (x in 1..5) {
//                channel.send(x * x)
//            }
//        }
//        for (c in channel) {
//            println(channel.receive())
//        }
//        println("done")
//    }

//    //cloce channel
//    runBlocking {
//        val channel = Channel<Int>()
//        launch {
//            for (x in 1..5) {
//                channel.send(x * x)
//            }
//            channel.close()
//        }
//        for (c in channel) {
//            println(channel.receive())
//        }
//        println("done")
//    }
//        runBlocking {
//        val channel = Channel<Int>()
//        launch {
//            for (x in 1..10) {
//                if (x==5) channel.close(Throwable())
//                channel.send(x * x)
//            }
//        }
//        for (y in 1..5) {
//            println(channel.receive())
//        }
//        println("done")
//    }

//    //produce
//    runBlocking {
//        val squares: ReceiveChannel<Int> = produceSquares()
//        squares.consumeEach { println("number $it") }
//        println("Done")
//    }

//    //actor
//    runBlocking {
//        val myactor =myActor()
//        myactor.send(123)
//        println("Done")
//    }

//    //buffered channel
//    runBlocking {
//        val channel = Channel<Int>(capacity = 4)
//        val sender = launch {
//            repeat(10){
//                channel.send(it)
//                println("Sending $it")
//            }
//        }
//        delay(1000)
//        sender.cancel()
//    }

//    //Conflated channel
//    runBlocking {
//        val channel = Channel<Int>(Channel.CONFLATED)
//        val sender = launch {
//            repeat(5) {
//                println("Sending $it")
//                channel.send(it)
//            }
//        }
//        delay(1000)
//        channel.consumeEach { println("item = $it") }
//        sender.cancel()
//    }

//    //Unlimited channel
//        runBlocking {
//        val channel = Channel<Int>(Channel.UNLIMITED)
//        val sender = launch {
//            repeat(7) {
//                channel.send(it)
//            }
//        }
//        delay(1000)
//        repeat(7){
//            val value = channel.receive()
//            println("number $value")
//        }
//        sender.cancel()
//    }
}

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) {
        send(x * x)
    }
}

fun CoroutineScope.myActor(): SendChannel<Int> = actor {
    val value = receive()
    println(value)
}