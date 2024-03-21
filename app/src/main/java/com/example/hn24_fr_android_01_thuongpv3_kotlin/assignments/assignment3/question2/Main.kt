package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment3.question2

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Scanner

@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    inputCommand()
}

@RequiresApi(Build.VERSION_CODES.O)
fun inputCommand() {
    val sc = Scanner(System.`in`)
    val landList = Land.landList
    val houseList = House.houseList
    println("input your command: ")
    println("1. Add")
    println("2. Print")
    println("3. Print number of house and land")
    println("4. Print land average price")
    println("5. Print previous month transaction")
    println("0. Exit")
    when(checkNumberType(sc)){
        1 -> addTransaction(landList, houseList)
        2 -> printTransaction(landList, houseList)
        3 -> printNumberOfTransaction(landList, houseList)
        4 -> printLandAveragePrice(landList)
        5 -> printPreviousMonthTransaction(landList, houseList)
        0 -> print("Done")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun printPreviousMonthTransaction(landList: MutableList<Land>, houseList: MutableList<House>) {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val today = LocalDate.now()
    val lastMonth = today.minusMonths(1)

    for (landListDate in landList){
        val transactionDate = LocalDate.parse(landListDate.getLandDate().trim(), formatter)
        if(transactionDate.year == today.year && transactionDate.month == lastMonth.month){
            landListDate.printLandTransaction()
        }
    }

    for (houseListDate in houseList){
        val transactionDate = LocalDate.parse(houseListDate.getHouseDate().trim(), formatter)
        if(transactionDate.year == today.year && transactionDate.month == lastMonth.month){
            houseListDate.printHouseTransaction()
        }
    }
}

fun printLandAveragePrice(landList: MutableList<Land>) {
    var total = 0f
    for (i in landList){
        total += i.getTotalMoney()
    }
    println("Average money: ${total / landList.size}")
}

fun printNumberOfTransaction(landList: MutableList<Land>, houseList: MutableList<House>) {
    println("Number of house transaction: ${landList.size}")
    println("Number of land transaction: ${houseList.size}")
}

@RequiresApi(Build.VERSION_CODES.O)
fun printTransaction(landList: MutableList<Land>, houseList: MutableList<House>) {
    println("List of land transaction: ")
    for(i in houseList){
        i.printHouseTransaction()
    }
    println("List of house transaction: ")
    for(i in landList){
        i.printLandTransaction()
    }
    inputCommand()
}

@RequiresApi(Build.VERSION_CODES.O)
fun addTransaction(landList: MutableList<Land>, houseList: MutableList<House>) {
    val sc = Scanner(System.`in`)
    println("Choose transaction: ")
    println("1. Land")
    println("2. House")
    val inputCommand = checkNumberType(sc)
    when(inputCommand){
        1 -> {
            var land = setLand(sc)
            landList.add(land)
        }
        2 -> {
            var house = setHouse(sc)
            houseList.add(house)
        }
    }
    inputCommand()
}

//set house and land
fun setHouse(sc: Scanner): House {
    println("input house transaction: ")

    println("input id: ")
    var id = sc.next()

    println("input date: ")
    var date: String
    do {
        date = sc.next()
    }while (!checkDateOfBirthFormat(date))

    println("input price: ")
    var price = checkFloatType(sc)

    println("type: ")
    println("1. Luxury")
    println("2. High class")
    println("3. Normal")
    var type: String = checkHouseTypeFormat(sc)

    println("input acreage: ")
    var acrreage = checkFloatType(sc)

    println("input address: ")
    var address = sc.next()

    var house = House(id, date, price, type, address, acrreage)
    return house
}
fun setLand(sc: Scanner): Land{
    println("input land transaction: ")

    println("input id: ")
    var id = sc.next()

    println("input date: ")
    var date: String
    do {
        date = sc.next()
    }while (!checkDateOfBirthFormat(date))

    println("input price: ")
    var price = checkFloatType(sc)

    println("input type: ")
    var type: String = ""
    do {
        type = sc.next()
    }while (!checkLandTypeFormat(type))

    println("input acreage: ")
    var acrreage = checkFloatType(sc)

    var land = Land(id, date, price, type, acrreage)
    return land
}

//check function
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
fun checkDateOfBirthFormat(dateOfBirth: String): Boolean{
    var len: Int = dateOfBirth.length;
    if(len == 10 ) {
        if (dateOfBirth[2] != '/' && dateOfBirth[5] != '/') {
            println("Please input correct date of birth form.");
            return false;
        }
    }
    else
    {
        System.out.println("Please input correct date of birth form.");
        return false;
    }
    return true;
}
fun checkFloatType(sc: Scanner): Float {
    var number = 0f
    var checkInputNumber = false
    while (!checkInputNumber){
        if(sc.hasNextFloat()){
            number = sc.nextFloat()
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
fun checkLandTypeFormat(type: String): Boolean{
    if(type.length == 1){
        if(type[0] == 'A' || type[0] == 'B' || type[0] == 'C'){
            return true
        }
    }
    return false
}
fun checkHouseTypeFormat(sc: Scanner): String{
    var num = checkNumberType(sc)
    when(num){
        1 -> return "Luxury"
        2 -> return "High-class"
        3 -> return "Normal"
    }
    return "Unknow"
}
