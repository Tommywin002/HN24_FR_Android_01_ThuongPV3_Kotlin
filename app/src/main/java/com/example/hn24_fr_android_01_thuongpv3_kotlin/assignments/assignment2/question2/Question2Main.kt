package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment2.question2

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val inputNumber1: Int = checkNumberType(sc)
    val inputNumber2: Int = checkNumberType(sc)
    var count = 0
    print("Prime number between $inputNumber1 and $inputNumber2 is: ")
    println()
    //using lambda expression
    print("Using lambda expression: ")
    for(i in inputNumber1 + 1 until inputNumber2){
        if (checkPrimeUsingLambdaExpression(i))
        {
            print("$i ")
            count++
        }
    }
    if (count == 0)
        println("There is no number.")
    println()

    //using higher orders function
    print("Using higher orders function: ")
    checkPrimeNumberBetween2InputNumber(inputNumber1, inputNumber2){
        i -> print("$i ")
    }

}
//lambda expression function
fun checkPrimeUsingLambdaExpression(number: Int): Boolean{
    return number > 1 && (2 until number).none {number % it == 0}
}

//higher order function
fun checkPrimeNumberBetween2InputNumber(number1: Int, number2: Int, printNumber: (Int) -> Unit){
    var count = 0
    for(i in number1 + 1 until number2){
        if(checkPrimeNumber(i)) {
            printNumber(i)
            count++
        }
    }
    if (count == 0)
        print("There is no number")
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

//check number type correct or not
fun checkNumberType(sc: Scanner): Int{
    var number = 0
    var checkInputNumber = false
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