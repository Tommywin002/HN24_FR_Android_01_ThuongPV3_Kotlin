package com.example.trainingkotlin.lectures.oop

import kotlin.math.max

abstract class Customer(var amountOfProduct: Int, var price: Double) {
    abstract fun getBill()
    abstract fun getTotal(): Double
}

class CustomerA(amountOfProduct: Int, price: Double) : Customer(amountOfProduct, price) {
    override fun getTotal(): Double {
        return amountOfProduct * price * 1.1
    }

    override fun getBill() {
        println("CustomerA: Bill [Amount: $amountOfProduct, price: $price, total: " + getTotal())
    }
}

class CustomerB(amountOfProduct: Int, price: Double, private var numberOfYear: Int) :
    Customer(amountOfProduct, price) {
    override fun getTotal(): Double {
        val saleOff = max(numberOfYear * 0.05, 0.5)
        return amountOfProduct * price * (1 - saleOff) * 1.1
    }

    override fun getBill() {
        println("CustomerB: Bill [Amount: $amountOfProduct, price: $price, year: $numberOfYear, total: " + getTotal())
    }
}

class CustomerC(amountOfProduct: Int, price: Double) : Customer(amountOfProduct, price) {
    override fun getTotal(): Double {
        return amountOfProduct * price * 0.5 * 1.1
    }

    override fun getBill() {
        println("CustomerC: Bill [Amount: $amountOfProduct, price: $price, total: " + getTotal())
    }
}

fun main() {
    val customerA = CustomerA(10, 20.0)
    val customerB = CustomerB(10, 20.0, 15)
    val customerC = CustomerC(10, 20.0)
    customerA.getBill()
    customerB.getBill()
    customerC.getBill()
}