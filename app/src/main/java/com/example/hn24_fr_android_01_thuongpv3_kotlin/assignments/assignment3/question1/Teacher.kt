package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment3.question1

import java.util.Scanner
const val PREFIX_TEACHER = "GV"
class Teacher: Person(){
    private var id: String = "Unknow"
    private var classManaged: String = "Unknow"
    private var salary: Float = 0.0f
    private var workedTime: Int = 0
    companion object{
        var teacherIdList = ArrayList<Int>()
    }
    fun getId(): String{
        return id
    }
    fun getSalary(): Float{
        return salary
    }

    override fun inputInfo() {
        val sc = Scanner(System.`in`)

        println()
        println("Input teacher id: ")
        var inputTeacherIdNumber = checkNumType(sc)
        while (inputTeacherIdNumber in teacherIdList) {
            println("Id existed")
            inputTeacherIdNumber = checkNumType(sc)
        }
        id = PREFIX_TEACHER + inputTeacherIdNumber.toString()
        teacherIdList.add(inputTeacherIdNumber)
        super.inputInfo()
        println("input salary: ")
        salary = checkNumType(sc).toFloat()

        println("input time of work: ")
        workedTime = checkNumType(sc)

        println("input class name: ")
        do {
            classManaged = sc.next()
        }while (!checkClassManaged(classManaged))
    }

    override fun showInfo() {
        println("ID: $id")
        super.showInfo()
        println("Class: $classManaged")
        println("Work time: $workedTime")
        println("Salary for a hour: $salary")
        if (classManaged[0] == 'G' || classManaged[0] == 'H' || classManaged[0] == 'I' || classManaged[0] == 'K') {
            val totalSalary = salary * workedTime.toFloat()
            println("Salary: $totalSalary")
        }
        else if (classManaged[0] == 'L' || classManaged[0] == 'M') {
            val total = salary * workedTime.toFloat() + 500000
            println("Salary: $total")
        }
        println()

    }
    fun updateTeacherInfo(id: String){
        val sc = Scanner(System.`in`)
        this.id = id
        super.inputInfo()
        println("input salary: ")
        salary = checkNumType(sc).toFloat()

        println("input time of work: ")
        workedTime = checkNumType(sc)

        println("input class name: ")
        do {
            classManaged = sc.next()
        }while (!checkClassManaged(classManaged))
    }

}
fun checkNumType(sc: Scanner): Int{
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
fun checkClassManaged(classManage: String): Boolean {
    if(classManage[0] == 'G' || classManage[0] == 'H' || classManage[0] == 'I' || classManage[0] == 'K' || classManage[0] == 'L' || classManage[0] == 'M'){
        return true
    }
    print("input again")
    return false
}
