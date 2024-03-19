package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment3.question1

import java.util.Scanner

open class Person(_name: String, _gender: String, _birth: String, _address: String) {
    open var name: String = _name
    open var gender: String = _gender
    open var birth: String = _birth
    open var address:String = _address
    init {

    }
    constructor() : this("unknow", "unknow", "unknow", "unknow") {

    }
    open fun inputInfo() {
        val sc = Scanner(System.`in`)

        print("input name: ")
        name = sc.nextLine()

        print("input gender (male or female): ")
        do {
            gender = sc.next()
        }while (!checkGenderFormat(gender))

        print("input date of birth: ")
        do {
            birth = sc.next()
        }while (!checkDateOfBirthFormat(birth))

        print("input address: ")
        address = sc.next()
    }

    open fun showInfo(){
        println("Name: $name")
        println("Gender: $gender")
        println("Date of birth: $birth")
        println("Address: $address")
    }
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
fun checkGenderFormat(gender: String): Boolean{
    var checkGenderForm1: Boolean = gender.contains("male");
    var checkGenderForm2: Boolean = gender.contains("female");
    if (!checkGenderForm1 && !checkGenderForm2)
    {
        println("Please input correct gender form.");
        return false;
    }
    return true;
}

