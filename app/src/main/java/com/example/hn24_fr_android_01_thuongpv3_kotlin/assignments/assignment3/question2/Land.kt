package com.example.hn24_fr_android_01_thuongpv3_kotlin.assignments.assignment3.question2

class Land(_id: String, _date: String, _price: Float, _type: String, _acreage: Float){
    private var id = _id
    private var date = _date
    private var price = _price
    private var type = _type
    private var acreage = _acreage
    companion object{
        var landList = mutableListOf<Land>()
    }
    fun getLandDate(): String{
        return date
    }
    fun getTotalMoney(): Float{
        val totalWithoutVAT: Float
        var total = 0f
        if(type.equals("A")){
            totalWithoutVAT = (acreage * price * 1.5).toFloat()
            total = totalWithoutVAT + totalWithoutVAT * 10 / 100
        }else if(type.equals("B")){
            totalWithoutVAT = acreage * price
            total = totalWithoutVAT + totalWithoutVAT * 10 / 100
        }else if(type.equals("C")){
            totalWithoutVAT = acreage * price
            total = totalWithoutVAT
        }
        return total
    }
    fun printLandTransaction(){
        println("id: $id")
        println("date: $date")
        println("price: $price")
        println("type: $type")
        println("acreage: $acreage")
        val totalWithoutVAT: Float
        var total = 0f
        if(type.equals("A")){
            totalWithoutVAT = (acreage * price * 1.5).toFloat()
            total = totalWithoutVAT + totalWithoutVAT * 10 / 100
        }else if(type.equals("B")){
            totalWithoutVAT = acreage * price
            total = totalWithoutVAT + totalWithoutVAT * 10 / 100
        }else if(type.equals("C")){
            totalWithoutVAT = acreage * price
            total = totalWithoutVAT
        }
        println("Total: $total")
    }

}