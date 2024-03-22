package com.example.hn24_fr_android_01_thuongpv3_kotlin.finalKotlinExam

import com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment3.question1.checkEmailType
import kotlinx.coroutines.delay
import java.util.Scanner
import kotlin.random.Random

class UserManager {
    companion object {
        var userList = ArrayList<User>()
    }
    suspend fun addUser(){
        val sc = Scanner(System.`in`)
        println("input number of user")
        var num = checkNumberForm(sc)
        for (i in 0 until num){
            println("input name: ")
            var name: String = sc.next()

            println("input age: ")
            var age = checkNumberForm(sc)

            println("input email: ")
            var email = sc.next()
            while (!checkUserEmailType(email)) {
                if (checkUserEmailType(email) == false){
                    println("input email correct form!")
                }
                email = sc.next()
            }

            var user = User(name, age, email)
            userList.add(user)
            val randomDelayTime = Random.nextLong(500, 2001)
            delay(randomDelayTime)
        }
    }
    fun displayUser(){
        println("List of user: ")
        for(user in userList){
            println("Name: ${user.userName}")
            println("Age: ${user.userAge}")
            println("Email: ${user.userEmail}")
            println()
        }
    }
    fun findUserByName(){
        val sc = Scanner(System.`in`)
        println("input name: ")
        val nameSearched = sc.next()
        for(user in userList){
            if(user.userName.contains(nameSearched)) {
                println("Name: ${user.userName}")
                println("Age: ${user.userAge}")
                println("Email: ${user.userEmail}")
                println()
            }
        }
    }
    val sortedList: (ArrayList<User>) -> Unit = { listBeforeSort: ArrayList<User> ->  listBeforeSort.sortBy { it.userName }}
    fun sortUserByName(){
        sortedList(userList)
        displayUser()
    }
}
fun checkNumberForm(sc: Scanner): Int{
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
fun checkUserEmailType(email: String): Boolean{
    val trueForm = "@gmail.com"
    val checkFormat = email.contains(trueForm)
    if(checkFormat)
        return true
    return false
}