package com.example.fisrtkotlin

fun main(){
    // class 생성
    val human = Human("Sangmin")
    println("${human.name} said, \"${human.eatingCake()}\"")

    // class default값 설정
    val stranger = Human()
    println("${stranger.name} said, \"${stranger.eatingCake()}\"")

    // class 안의 class
    // 여기서 26의 값을 지우면 아래 부 생성자 consturctor는 비활성화된다다
    val human2 = Human("Sangmin", 26)

    // class 상속
    val korean = Korean()
    korean.singASong()
}

// Class
//  * method는 그냥 똑같이 지정해주면 되고, property는 앞에 선언식을 써주긴 해야하는것같다
//  * 해당 클래스(객체)를 생성할 때 변수를 지정해주고, 주 생성자-constructor로 받을 수 있다.
//  * 주 생성자에서 직접 property를 설정할 수 있다.
//  * 주 생성자-constructor는 생략이 가능하다.
//  * 주 생성자 안에서 부 생성자를 여러개 만들 수 있다
//  * 부 생성자는 주 생성자에게 꼭 상속을 받아야한다
open class Human (val name : String = "Anonymous"){
    // init - 해당 class가 생성될 때 가장 먼저 실행되는것
    init {
        println("New human has been born!!")
    }
    // 부 생성자
    constructor(name : String, age : Int) : this(name){
        println("my name is ${name}, ${age} years old")
    }
    fun eatingCake() : String { // 메소드
        return "This is so YUMMMYYY~~~~"
    }
    open fun singASong(){
        println("Yeah, it won't be that easy. The world that allowed me.")
    }
}

// class 상속
//  * JS에서 extends를 썼지만, 코틀린에서는 상속을 시켜주는 class앞에 open을 써주고,
//  * 타입지정처럼 `: 상속class()`를 해주면 된다.
//  * 상속받은 자식 class에서는 상속해준 부모의 class의 mehods와 property를 사용할 수 있는데,
//  * 만약 동일한 methods명이나 property명을 사용하고싶다면 override로 덮고, 부모에게서 open을 써준다.
//  * 단, `super.`를 통해 부모의 것도 호출할 수 있다.
class Korean : Human(){
    override fun singASong(){
        super.singASong()
        println("그래, 그리 쉽지는 않겠지. 나를 허락해준 세상이란")
        println("my name is ${name}")
    }
}