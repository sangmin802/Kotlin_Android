package com.example.letwithrunapplyalso

// let
// let 함수는 매개변수화된 타입 T의 확장함수이다.
// (extenstion) 자기 자신을 받아서 R을 반환하는 ((T) -> R) 람다식을 입력으로 받고, 블럭 함수의 반환값 R을 반환한다.
// fun <T, R> T.let(block : (t) -> R) : R

fun main(){
    val person = makePerson("", 0)
//    val person = makePerson("Junsung", 26)
//    단 하나의 변수만 받아서 그냥 안써주고 it으로 퉁
    val resultIt = person.let {
        if(person.name === ""){
            it.name = "Sangmin"
            it.age = 26
        }else{
            null
        }
        it
    }

    println(resultIt)

    val resultStr = person.let {
        it.name = "Taekyun"
        it.age = 26
        it.gender = "male"
        "${it.name}, ${it.age} and ${it.gender}"
    }

    println(resultStr)

    val resultUnit = person.let {
        it.name = "Jaeyun"
        it.age = 26
    }

    println(resultUnit)
}
//https://blog.yena.io/studynote/2020/04/15/Kotlin-Scope-Functions.html

data class makePerson(var name : String, var age : Number, var gender : String = "secret")