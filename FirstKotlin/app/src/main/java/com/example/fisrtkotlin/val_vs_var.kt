package com.example.fisrtkotlin

// 2. val vs var
// val === const
// var === let
// 아래처럼 선언을 해줄 때에는 타입명을 굳이 지정해주지않아도 할당된 값으로 스스로 타입을 정함
// 단, 값을 바로 할당해주지않는다면 타입명을 지정해줘야한다.
fun hi(){
    val a : Int = 10
    var b : Int = 9
    val c = 100
    b = 100
    val d : String
    var name = "Sangmin"
}