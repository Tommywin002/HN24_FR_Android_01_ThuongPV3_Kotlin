package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment3.question2

class House(_id: String, _date: String, _price: Float, _type: String, _address: String, _acreage: Float) {
    private var id = _id
    private var date = _date
    private var price = _price
    private var type = _type
    private var address = _address
    private var acreage = _acreage
    companion object{
        var houseList = mutableListOf<House>()
    }
    fun getHouseDate(): String{
        return date
    }
    fun printHouseTransaction(){
        println("id: $id")
        println("date: $date")
        println("price: $price")
        println("type: $type")
        println("address: $address")
        println("acreage: $acreage")
        val totalWithoutVAT: Float
        var total = 0f
        if(type.equals("A")){
            totalWithoutVAT = acreage * price
            total = totalWithoutVAT + totalWithoutVAT * 10 / 100
        }else if(type.equals("B")){
            totalWithoutVAT = acreage * price
            total = totalWithoutVAT
        }else if(type.equals("C")){
            totalWithoutVAT = acreage * price
            total = totalWithoutVAT - totalWithoutVAT * 10 / 100
        }
        println("Total: $total")
    }
}