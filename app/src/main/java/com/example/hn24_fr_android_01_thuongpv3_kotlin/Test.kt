package com.example.hn24_fr_android_01_thuongpv3_kotlin

fun main(){
    var a = 1
    var b = 2
    val max = if(a > b){
        a + b
    } else{
        a - b
    }
    println(max)
}