package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment2.question3

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    var inputNumber = checkNumberType(sc)
    //using lambda expression
    print("Using lambda expression: ")
    var sumNumberInput: Int = caculateSumNumberToZero(inputNumber)
    println("Sum: $sumNumberInput")

    //using higher orders function
    print("Using higher orders function: ")
    sumNumberInput = caculateSumUsingHigherOrdersFunction(inputNumber,  ::caculateSumNumber)
    println("Sum: $sumNumberInput")
}
//lambda expression function
var sum = { a: Int, b: Int -> a + b }
fun caculateSumNumberToZero(number: Int): Int{
    if(number != 1)
        return sum(number, caculateSumNumberToZero(number - 1))
    return number
}

//higher orders function
fun caculateSumUsingHigherOrdersFunction(inputNumber: Int, caculate: (a: Int, b: Int) -> Int): Int{
    if(inputNumber != 1)
        return caculate(inputNumber, caculateSumUsingHigherOrdersFunction(inputNumber - 1, ::caculateSumNumber))
    return inputNumber
}
fun caculateSumNumber(a: Int, b: Int): Int = a + b

//check number type correct or not
fun checkNumberType(sc: Scanner): Int{
    var number: Int = 0
    var checkInputNumber: Boolean = false
    while (checkInputNumber == false){
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