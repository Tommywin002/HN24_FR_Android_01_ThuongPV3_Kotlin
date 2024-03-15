package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment1

import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    var year: Int = 0
    var checkType: Boolean = false
    println("input year: ")
    while (checkType == false){
        if(sc.hasNextInt()){
            year = sc.nextInt()
            if(year > 0){
                checkType = true;
            }
        }
        else{
            println("input again")
            sc.nextLine()
        }
    }
    var month: Int = 0
    checkType = false
    println("input month: ")
    while (checkType == false){
        if(sc.hasNextInt()){
            month = sc.nextInt()
            if(month in 1..12){
                checkType = true;
            }
        }
        else{
            println("input again")
            sc.nextLine()
        }
    }
    var day = when(month){
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        else -> {
            if(year % 4 == 0 && year % 100 != 0 && year % 400 != 0)
                29
            else
                28
        }
    }
    /*day = if(year % 4 == 0 && year % 100 != 0 && year % 400 != 0){
        if(month == 2){
            29
        }
        else{
            if (month == 4 || month == 6 || month == 9 || month == 11){
                30
            }
            else{
                31
            }
        }
    } else {
        if(month == 2){
            28
        }
        else{
            if (month == 4 || month == 6 || month == 9 || month == 11){
                30
            }
            else{
                31
            }
        }
    }*/
    println("Year: $year, month: $month have $day days ")
}