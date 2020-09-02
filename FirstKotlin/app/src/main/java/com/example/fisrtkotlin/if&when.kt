package com.example.fisrtkotlin

fun main(){
    maxBy(5,2)
    checkNum(80)
}

// 조건식
//if
fun maxBy(a : Int, b : Int) : String {
    var result : String
    if(a > b){
        result = "a : ${a}"
    }else{
        result = "b : ${b}"
    }
    return "${result}가 더 큽니다."
}

// 코틀린에는 JS에서 자주 쓴 a > b ? a : b 같은 삼항 연상자가 없기때문에, 아래처럼 쓰면 된다.
fun maxBy2(a : Int, b : Int) : Int = if(a > b) a else b

//when
// while과 비슷하다
fun checkNum(score : Int){
    // 방법1
    when(score){
        0 -> println("this is ${score}")
        1 -> println("this is ${score}")
        2,3 -> println("this is 2 or 3")
        else -> println("I don't know")
    }

    // 방법2
    // 변수에 return을 담는 방법은, else를 꼭 포함시켜야 한다.
    var b : Int = when(score){
        1 -> 1
        2 -> 2
        else -> 3
    }
    println("b : ${b}")

    // 범위를 주고 싶을 때
    when(score){
        in 90..100 -> println("You are great!")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}