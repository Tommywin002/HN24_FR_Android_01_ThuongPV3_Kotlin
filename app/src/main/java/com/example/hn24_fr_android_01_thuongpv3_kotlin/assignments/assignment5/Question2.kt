package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Flow
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {
    println("flow function: ")
    runBlocking {
        foo().collect() { value -> println(value) }
    }
}
fun foo(): kotlinx.coroutines.flow.Flow<Int> = flow{
    var total = 0
    for(i in 0..10){
        emit(sumNumberFrom0ToN(10))
        delay(500)
    }
}

fun sumNumberFrom0ToN(n: Int): Int{
    var total = 0
    for(i in 0 .. n){
        total += i
    }
    return total
}