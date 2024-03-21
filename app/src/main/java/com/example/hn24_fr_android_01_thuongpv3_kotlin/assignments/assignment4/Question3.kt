package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment4

fun main() {
    var array = arrayOf(1, 3, 4, 2, 5, 100, 10, 30, 12)
    println("Max: ${findMax(array, 4, 8)}")
}
fun <N: Comparable<N>> findMax(array: Array<N>, begin: Int, end: Int): N{
    var max: N = array[0]
    for(i in begin until end){
        if(max.compareTo(array[i]) == -1){
            max = array[i]
        }
    }
    return max
}