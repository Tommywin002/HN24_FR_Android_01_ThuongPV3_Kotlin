package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment5

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    var n = sc.nextInt()
    val coroutineScope = CoroutineScope(Dispatchers.Default)
    //corountine scope
    coroutineScope.launch {
        val fibonacciNumber = fibonacci(n)

        println("Corountien scope: $fibonacciNumber")
    }
    //Thread.sleep(2000)

    runBlocking {
        val fiboNumber = fibonacci(n)
        println("Fibo number: $fiboNumber")
    }
    coroutineScope.cancel()

}
fun fibonacci(n: Int): Int {
    if (n <= 1) {
        return n
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2)
    }
}