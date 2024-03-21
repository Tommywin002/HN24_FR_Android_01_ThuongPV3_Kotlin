package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment4

import java.lang.reflect.Field
import java.lang.reflect.Method
class People(){
    var age = 0
    private var gender = "Unknow"
    private fun getGender(): String {
        return gender
    }
    fun getAge(): Int{
        return age
    }
}
fun main(){
    val people = People()
    val fields: Array<Field> = People::class.java.declaredFields
    val methods: Array<Method> = People::class.java.declaredMethods
    for(field in fields){
        field.isAccessible = true
        val value = field.get(people)
        println("${field.name}: $value")
    }
    for(method in methods){
        method.isAccessible = true
        val func = method.name
        println("${method.name}: $func")
    }
}