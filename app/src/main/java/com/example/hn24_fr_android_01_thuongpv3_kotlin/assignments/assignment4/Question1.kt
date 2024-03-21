package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment4

fun main(){
    val number = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val oddNumber = countNumber(number){it % 2 != 0}
    val evenNumber = countNumber(number){it % 2 == 0}
    val primeNumber = countNumber(number){ checkPrimeNumber(it) }
    println("Count odd number: $oddNumber")
    println("Count even number: $evenNumber")
    println("Count prime number: $primeNumber")
}
fun <T> countNumber(collection: Collection<T>, predicate: (T) -> Boolean): Int {
    var count = 0
    for (i in collection){
        if(predicate(i)){
            count++
        }
    }
    return count
}
fun checkPrimeNumber(number: Int): Boolean{
    if(number <= 1)
        return false
    for(i in 2 until number){
        if (number % i == 0)
            return false
    }
    return true
}