package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment3.question1

import java.util.Scanner
const val PREFIX = "SV"
class Student: Person() {
    private var id: String = "Unknow"
    private var email: String = "Unknow"
    private var score: Float = 0.0f

    companion object {
        private var idList = mutableListOf<Int>()
    }
    fun getId(): String{
        return id
    }
    fun getScore(): Float{
        return score
    }
    override fun inputInfo() {
        val sc = Scanner(System.`in`)
        print("input student id: ")
        var idNumber = checkNumberType(sc)
        while (idNumber in idList) {
            println("id existed. ")
            idNumber = checkNumberType(sc)
        }
        id = PREFIX + idNumber.toString()
        idList.add(idNumber)

        super.inputInfo()

        print("input average score: ")
        do {
            score = checkNumberType(sc).toFloat()
        }while (score < 0 || score > 10)

        print("input email: ")
        do {
            email = sc.next()
        }while (!checkEmailType(email))
        println()
    }
    override fun showInfo() {
        println("ID: $id")
        super.showInfo()
        println("Email: $email")
        println("Average score: $score")
        if(score >= 8)
            println("This student got scholarship")
        println()
    }
    fun updateInfo(id: String){
        val sc = Scanner(System.`in`)
        this.id = id
        super.inputInfo()

        print("input average score: ")
        do {
            score = checkNumberType(sc).toFloat()
        }while (score < 0 || score > 10)

        print("input email: ")
        do {
            email = sc.next()
        }while (!checkEmailType(email))
    }
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
fun checkEmailType(email: String): Boolean{
    val trueForm = '@'
    val checkFormat = email.contains(trueForm)
    if(checkFormat)
        return true
    return false
}