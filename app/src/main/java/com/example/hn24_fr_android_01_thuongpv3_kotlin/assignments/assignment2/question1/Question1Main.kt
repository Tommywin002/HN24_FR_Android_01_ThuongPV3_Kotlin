package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment2.question1

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    var inputNumber = 0
    var count = 0
    var checkInputNumber = false
    while (!checkInputNumber){
        if(sc.hasNextInt()){
            inputNumber = sc.nextInt()
            if(inputNumber > 0){
                checkInputNumber = true
            }
            else{
                sc.nextLine()
            }
        }
        else{
            println("Input again")
            sc.next()
        }
    }

    //using lambda expression
    println("Using lambda expression")
    for (i in 2 until inputNumber / 2){
        val minusNunber: Int = inputNumber - i
        //println("$i $minusNunber")
        if(checkPrimeUsingLambdaExpression(i) && checkPrimeUsingLambdaExpression(minusNunber)){
            print(" $inputNumber = $i + $minusNunber |")
            count++
        }
    }
    if(count == 0){
        println("There is no number")
    }
    println("")

    //using higher orders function
    println("Using higher orders function")
    checkIsPrimeNumberOfSum(inputNumber) { i, j ->
        print(" $inputNumber = $i + $j |")
    }
}

//lambda expression function
fun checkPrimeUsingLambdaExpression(number: Int): Boolean{
    return number > 1 && (2 until number).none(){number % it == 0}
}

//higher orders function
fun checkIsPrimeNumberOfSum(number1: Int, checkNumber: (Int, Int) -> Unit) {
    var count = 0
    for (i in 2 until number1 / 2){
        val minusNunber: Int = number1 - i
        if(checkPrimeNumber(i) && checkPrimeNumber(minusNunber)){
            checkNumber(i, minusNunber)
            count++
        }
    }
    if (count == 0)
        println("There is no number")
}
fun checkPrimeNumber(number: Int): Boolean{
    if(number <= 1)
        return false
    for(i in 2 until number){
        if (number % i == 0)
            return false
    }
    return true
}