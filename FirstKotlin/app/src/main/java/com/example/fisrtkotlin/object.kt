package com.example.fisrtkotlin

fun main(){
//  object
    val car = carFactory.makeCar(10)
    val car2 = carFactory.makeCar(200)

    println(car)
    println(car2)
    println(carFactory.cars.toString())
    println(carFactory.cars.size.toString())

//  class
    val car3 = carFactory2()
    car3.makeCar(20)
    val car4 = carFactory2()
    car4.makeCar(400)

    println(car3.cars.toString())
    println(car3.cars.size.toString())
    println(car4.cars.toString())
    println(car4.cars.size.toString())
//  결과를 보면 차이가 있음
//  carFactory 라는 object가 생성되어 계속 쌓이고있음
//  carFactory2 라는 클래스가 생성되는것이 아닌, 동일한 제작과정을 가진 공장일 뿐. 뱉어내는것은 다 다른 변수에 담김
}

// Object
// singleton pattern
// 매번 새로운 객체를 생성하지 않고 오직 하나의 객체만 생성하어 사용하려고 할때 사용한다.
object carFactory {
    val cars = arrayListOf<car>() // 생성된 data클래스 담는 배열
    fun makeCar(horsePower : Int) : car {
        val car = car(horsePower)
        cars.add(car)
        return car // 생성된 data클래스 반환
    }
}

class carFactory2 {
    val cars = arrayListOf<car>() // 생성된 data클래스 담는 배열
    fun makeCar(horsePower : Int) : car {
        val car = car(horsePower)
        cars.add(car)
        return car // 생성된 data클래스 반환
    }
}

data class car(val horsePower : Int)