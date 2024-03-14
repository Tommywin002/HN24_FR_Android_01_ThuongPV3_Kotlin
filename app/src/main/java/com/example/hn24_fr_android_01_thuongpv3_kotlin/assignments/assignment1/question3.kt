package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment1

import java.util.Scanner

fun main(){
    val sc =  Scanner(System.`in`)
    var n: Int = 0
    var checkArrayIndex : Boolean = false
    print("input array size: ")
    while (checkArrayIndex == false){
        if(sc.hasNextInt()){
            n = sc.nextInt()
            checkArrayIndex = true;
        }
        else{
            println("input again")
            sc.next()
        }
    }
    var arrayOfNumber = IntArray(n)
    print("input array: ")
    for(i in 0 until  arrayOfNumber.size){
        var checkNumberInArray : Boolean = false
        while (checkNumberInArray == false){
            if(sc.hasNextInt()){
                arrayOfNumber[i] = sc.nextInt()
                checkNumberInArray = true;
            }
            else{
                println("input again")
                sc.nextLine()
            }
        }
    }
    arrayOfNumber.sort()
    for (i in 0 until arrayOfNumber.size){
        print(arrayOfNumber[i])
        if (i < arrayOfNumber.size - 1){
            print(", ")
        }
    }
}