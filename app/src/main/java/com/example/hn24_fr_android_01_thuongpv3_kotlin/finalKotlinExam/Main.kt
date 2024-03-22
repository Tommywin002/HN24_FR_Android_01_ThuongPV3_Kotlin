package com.example.hn24_fr_android_01_thuongpv3_kotlin.finalKotlinExam

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Scanner

fun main() {
    chooseCommand();
}

fun chooseCommand() {
    val sc = Scanner(System.`in`)
    println("Input your selection by number: ")
    println("1. Add user")
    println("2. Display user")
    println("3. Find user by name")
    println("4. Sort user by name")
    println("0. Exit")
    when(checkNumberType(sc)){
        1 -> addUser()
        2 -> displayUser()
        3 -> findUserByName()
        4 -> sortUserByName()
        5 -> println("The end")
    }
}

fun sortUserByName() {
    val userManager = UserManager()
    userManager.sortUserByName()
    chooseCommand()
}

fun findUserByName() {
    val userManager = UserManager()
    userManager.findUserByName()
    chooseCommand()
}

fun displayUser() {
    val userManager = UserManager()
    userManager.displayUser()
    chooseCommand()
}

fun addUser() = runBlocking<Unit> {
    val globalCorountien = GlobalScope.launch {
        val userManager = UserManager()
        userManager.addUser()

    }
    globalCorountien.join()
    chooseCommand()
}

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