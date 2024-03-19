package com.example.trainingkotlin.lectures.oop

abstract class Staff(var name: String) {
    protected var salary = 0.0
    abstract fun setSalary()
}

class ProductionStaff(
    name: String,
    private var basicSalary: Double,
    private var numberProduct: Int
) :
    Staff(name) {

    override fun setSalary() {
        salary = basicSalary + numberProduct * 5000
    }

    fun showInfo() {
        setSalary()
        println("Production Staff [Name = $name, Salary = $salary]")
    }
}

class OfficeStaff(name: String, private var numberWorkDay: Int) :
    Staff(name) {

    override fun setSalary() {
        salary = numberWorkDay * 100000.0
    }

    fun showInfo() {
        setSalary()
        println("Office Staff [Name = $name, Salary = $salary]")
    }
}

fun main() {
    val productionStaff = ProductionStaff("Huan", 23.2, 10)
    val officeStaff = OfficeStaff("Lan", 10)
    productionStaff.showInfo()
    officeStaff.showInfo()
}