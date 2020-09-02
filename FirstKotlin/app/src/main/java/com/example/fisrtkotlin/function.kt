package com.example.fisrtkotlin

fun main(){ // 코틀린 시작 명령
    helloWorld()
    println(add(4,5))
}

// 1. 함수
// 변수가없고, 리턴값도 없을 때
fun helloWorld(){
    println("Hello World!")
}
// 변수가 있고, 리턴값도 있을 때 변수와 리턴값 모두 타입을 설정해줘야한다.
fun add(a : Int, b : Int) : Int{
    return a+b
}

