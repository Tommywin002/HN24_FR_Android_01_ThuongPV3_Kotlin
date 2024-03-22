package com.example.hn24_fr_android_01_thuongpv3_kotlin.finalKotlinExam

class User(_name: String, _age: Int, _email: String) {
    var userName = _name
    var userAge = _age
    var userEmail = _email
    constructor() : this("Unknow", 0, "Unknow")

}