package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment1

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    var count: Int = 0
    var inputString: String?
    inputString = sc.nextLine()
    val words = inputString.split(" ")
    for (i in 0 until words.size){
        count++
    }
    println("Number of word is $count")
    var arrayStringInput = inputString.split(" ")
    for(i in 0 until arrayStringInput.size)
    {
        if(i == 0 || arrayStringInput[i - 1].last() == '.' || arrayStringInput[i - 1].last() == '?' || arrayStringInput[i - 1].last() == '!'){
            print(arrayStringInput[i].capitalize())
            print(" ")
        }
    }

    /*val inputStringAfterUpperCase = inputString.split(". ").joinToString(". ") { it.capitalize() }
    println(inputStringAfterUpperCase)*/

}

