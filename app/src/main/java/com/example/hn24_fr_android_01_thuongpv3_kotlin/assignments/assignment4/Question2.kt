package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment4

fun main(){
    var array = arrayOf("tom", "mama", "family", "computer")
    swapIndex(array, 1, 3)
    for(i in array){
        print("$i ")
    }
}
fun <T> swapIndex(array: Array<T>, firstIndex: Int, lastIndex: Int){
    val temp: T = array[firstIndex]
    array[firstIndex] = array[lastIndex]
    array[lastIndex] = temp

}