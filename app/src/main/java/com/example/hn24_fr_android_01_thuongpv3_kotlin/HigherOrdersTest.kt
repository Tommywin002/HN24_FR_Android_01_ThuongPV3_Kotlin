package com.example.hn24_fr_android_01_thuongpv3_kotlin

fun sum(a: Int, b: Int) = a + b
fun sub(a: Int, b: Int) = a - b
fun mul(a: Int, b: Int) = a * b
fun div(a: Int, b: Int) = a / b

fun calculateSum(): (Int, Int) -> Int {
    return ::sum
}

fun calculateSub(): (Int, Int) -> Int {
    return ::sub
}

fun calculateMul(): (Int, Int) -> Int {
    return ::mul
}

fun calculateDiv(): (Int, Int) -> Int {
    return ::div
}

fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    println("Sum: " + calculate(2, 3, ::sum))
    println("Sub: " + calculate(2, 3, ::sub))
    println("Mul: " + calculate(2, 3, ::mul))
    println("Div: " + calculate(2, 3, ::div))

//    Tương tự như các hàm trả về 1 kiểu dữ liệu nào đó thì mình cần gắn giá trị mà hàm đó trả về cho 1 biến
//    xong mình mới sử dụng biến đó được, ở đây sau khi gán thì mình có thể sử dụng các biến đó như các hàm sum,sub,mul,div
    val sumResult = calculateSum()
    println("Sum: " + sumResult(2, 3))
    val subResult = calculateSub()
    println("Sub: " + subResult(2, 3))
    val mulResult = calculateMul()
    println("Mul: " + mulResult(2, 3))
    val divResult = calculateDiv()
    println("Div: " + divResult(2, 3))
}

