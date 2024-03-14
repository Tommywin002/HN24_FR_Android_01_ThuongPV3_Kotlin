package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment1

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    var inputNumber: Int = 0
    var checkInputNumber : Boolean = false
    while (checkInputNumber == false){
        if(sc.hasNextInt()){
            inputNumber = sc.nextInt()
            checkInputNumber = true;
        }
        else{
            println("input again")
            sc.nextLine()
        }
    }
    print(Integer.toBinaryString(inputNumber))
    println("")
    print(Integer.toHexString(inputNumber))
}
