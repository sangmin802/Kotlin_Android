package com.example.fisrtkotlin

fun main(){
    forAndWhile()
}

// For & While
// JS랑 거의 똑같은수준
fun forAndWhile(){
// For
    val classes = arrayListOf("바드", "워로드", "서머너", "디스트로이어")
    for(name in classes){
        println("저의 직업은 ${name} 입니다")
    }
    for((index, name) in classes.withIndex()){
        println("저의 ${index+1}번째 직업은 ${name} 입니다")
    }

    // a..b - a~b까지
    var sum : Int = 0
    for(i in 1..10){
        sum+=i
    }
    println(sum)

    // step c - c단계? 만 적용
    for(i in 1..10 step 2){
        println("Step2 ${i}")
    }

    // a downTo b - a부터 b로 역순
    for(i in 10 downTo 1){
        println("10 downTo 1 ${i}")
    }

    // a until b - a~b인데, b는빼고
    for(i in 1 until 10){
        println("1 until 10 ${i}")
    }

// While
    var index = 0
    while(index < 10){
        println("current index : ${index}")
        index++
    }
}