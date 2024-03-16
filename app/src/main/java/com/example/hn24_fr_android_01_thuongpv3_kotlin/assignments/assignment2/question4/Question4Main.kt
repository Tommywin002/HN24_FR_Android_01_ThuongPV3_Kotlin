package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment2.question4

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val inputNumber = checkNumberType(sc)
    var sumNumber: Int;
    //using lambda expression
    print("Using lambda expression: ")
    sumNumber = caculateSumNumberByLambdaExpression(inputNumber)
    println(sumNumber)

    //using higher orders function
    print("Using higher orders function: ")
    sumNumber = caculateSumNumberByHigherOrderFunction(inputNumber)
    println(sumNumber)
}
//lambda expression function
var sum = { a: Int, b: Int -> a + b }
fun caculateSumNumberByLambdaExpression(inputNumber: Int): Int{
    var total = 0
    var number = inputNumber
    while (number >= 10){
        val remainder = number % 10
        number = number / 10
        total = sum(total, remainder)
    }
    return total + number
}

//higher orders function
fun caculateSumNumberByHigherOrderFunction(inputNumber: Int): Int{
    var number = inputNumber
    var total = 0
    while (number >= 10){
        val reminders = number % 10
        number = number / 10
        total = calculate(total, reminders, ::sumNumber)
    }
    return total + number;
}
fun calculate(a: Int, b: Int,  caculate: (a: Int, b: Int) -> Int): Int{
    return caculate(a, b)
}
fun sumNumber(a: Int, b: Int): Int = a + b

//check number type correct or not
fun checkNumberType(sc: Scanner): Int{
    var number: Int = 0
    var checkInputNumber: Boolean = false
    while (!checkInputNumber){
        if(sc.hasNextInt()){
            number = sc.nextInt()
            if(number > 0){
                checkInputNumber = true
            }
            else{
                sc.nextLine()
            }
        }
        else{
            println("input again")
            sc.next()
        }
    }
    return number
}