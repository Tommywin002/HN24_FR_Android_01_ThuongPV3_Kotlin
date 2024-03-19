package com.example.hn24_fr_android_01_thuongpv3_kotlin

fun main(){
    val person = Person()
    person.name = "Tom"
    println(person.name)
}
const val PREFIX = "Kotlin"
class Person{
    var name: String = "Tom"
        get() {
            return field.trim()
        }
        set(value) {
            field = PREFIX + value
        }
}