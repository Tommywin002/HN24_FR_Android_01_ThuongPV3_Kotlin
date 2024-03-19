package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment3.question1

import java.util.Scanner


fun main(){
    chooseSelection()
}

fun chooseSelection() {
    val studentList = mutableMapOf<String, Student>()
    val teacherList = mutableMapOf<String, Teacher>()
    val sc = Scanner(System.`in`)
    while (true){
        println("input your selection: ")
        println("1. add")
        println("2. update")
        println("3. delete")
        println("4. sort")
        println("5. print students")
        println("6. print teachers")
        println("7. sort student score")
        println("8. sort teacher salary")
        println("0. exit")
        when(sc.nextLine()){
            "add" -> addPerson(studentList, teacherList)
            "update" -> updatePerson(studentList, teacherList)
            "delete" -> deletePerson(studentList, teacherList)
            "sort" -> sortPersonByName(studentList, teacherList)
            "print students" -> printStudentList(studentList)
            "print teachers" -> printTeacherList(teacherList)
            "sort student score" -> sortAndPrintStudentScore(studentList)
            "sort teacher salary" -> sortAndPrintTeacherScore(teacherList)
            "exit" -> break
            else -> println("input again")
        }
    }
}

fun sortAndPrintTeacherScore(teacherList: MutableMap<String, Teacher>) {
    val sortedTeacherMap = teacherList.entries.sortedBy { it.value.getSalary() }.associate { it.toPair() }
    for((key, value ) in sortedTeacherMap){
        value.showInfo()
    }
}

fun sortAndPrintStudentScore(studentList: MutableMap<String, Student>) {
    val sortedStudentMap = studentList.entries.sortedBy { it.value.getScore() }.associate { it.toPair() }
    for((key, value ) in sortedStudentMap){
        value.showInfo()
    }
}

fun printTeacherList(teacherList: MutableMap<String, Teacher>) {
    for((key, value ) in teacherList){
        value.showInfo()
    }
}

fun printStudentList(studentList: MutableMap<String, Student>) {
    for((key, value ) in studentList){
        value.showInfo()
    }
}

fun sortPersonByName(studentList: MutableMap<String, Student>, teacherList: MutableMap<String, Teacher>) {
    val sortedStudentMapByName = studentList.entries.sortedBy { it.value.name }.associate { it.toPair() }
    val sortedTeacherMapByName = teacherList.entries.sortedBy { it.value.name }.associate { it.toPair() }
    for((key, value ) in sortedStudentMapByName){
        value.showInfo()
    }
    for((key, value ) in sortedTeacherMapByName){
        value.showInfo()
    }
}

fun deletePerson(studentList: MutableMap<String, Student>, teacherList: MutableMap<String, Teacher>) {
    val sc = Scanner(System.`in`)
    println("input: ")
    println("1. Student")
    println("2. Teacher")
    val input = readLine()
    var isCorrect = true
    when(input){
        "student" -> {
            print("input id of student: ")
            val n = sc.nextLine()
            var inputKey: String = ""
            for((key, value ) in studentList){
                if(key.equals(n)){
                    inputKey = key
                }
            }
            studentList.remove(inputKey)
            isCorrect = false
        }
        "teacher" ->{
            print("input id of teacher: ")
            var n = sc.nextLine()
            var inputKey: String = ""
            for((key, value ) in teacherList){
                if(key.equals(n)){
                    inputKey = key
                }
            }
            teacherList.remove(inputKey)
            isCorrect = false
        }
    }
}

fun updatePerson(studentList: MutableMap<String, Student>, teacherList: MutableMap<String, Teacher>) {
    val sc = Scanner(System.`in`)
    println("input: ")
    println("1. Student")
    println("2. Teacher")
    val input = readLine()
    when(input){
        "student" -> {
            print("input id of student: ")
            var n = sc.nextLine()

        }

        "teacher" ->{
            print("input id of teacher: ")
            var n = sc.nextLine()

        }
    }
}

fun addPerson(studentList: MutableMap<String, Student>, teacherList: MutableMap<String, Teacher>) {
    val sc = Scanner(System.`in`)
    println("input: ")
    println("1. Student")
    println("2. Teacher")
    val input = readLine()
    var isCorrect = true
    when(input){
        "student" -> {
            print("input number of student: ")
            val n = checkNumberFormat(sc)
            for (i in 0 until n){
                val student = Student()
                student.inputInfo()
                studentList[student.getId()] = student
            }
            isCorrect = false
        }
        "teacher" ->{
            print("input number of teacher: ")
            val n = checkNumberFormat(sc)
            for (i in 0 until n){
                val teacher = Teacher()
                teacher.inputInfo()
                teacherList[teacher.getId()] = teacher
            }
            isCorrect = false
        }
    }
}
fun checkNumberFormat(sc: Scanner): Int{
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


