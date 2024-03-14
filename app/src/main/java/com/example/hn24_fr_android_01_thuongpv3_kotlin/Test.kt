package com.example.hn24_fr_android_01_thuongpv3_kotlin

fun main(){
    var a = 3
    var b = 2
    var c = 0
    val max = if(a > b){
        c = a + b
        c
    } else{
        a - b
    }
    println(max)
}