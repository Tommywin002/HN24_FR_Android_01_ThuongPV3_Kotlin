package com.example.trainingkotlin.lectures.lambda

var sum = { a: Int, b: Int -> a + b }
var sub = { a: Int, b: Int -> a - b }
var mul = { a: Int, b: Int -> a * b }
var div = { a: Int, b: Int -> a / b }

fun main() {

    println("Sum: " + sum(2, 3))
    println("Sub: " + sub(2, 3))
    println("Mul: " + mul(2, 3))
    println("Div: " + div(2, 3))
}