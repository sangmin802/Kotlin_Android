package com.example.fisrtkotlin

fun main(){
    arrayList()
}

// Array and List
fun arrayList(){
    // Array - 처음에 정해주는 할당(크기)가 있으며, 수정이 가능하다
    val array = arrayOf(1,2,"a",3,4f)
    array[0] = 3
    println(array)

    // List
    //  1. List - 수정이 불가능한 리스트
    val list = listOf(1,2,"b",3,11L)
    val listResult = list.get(0) // 수정은 불가능하고 가져오는것만 가능하다
    println(listResult)

    //  2. MutableList - 수정, 변경이 가능한 리스트(대표 : arrayList)
    //  제일 많이 사용할 것 같다.
    val arrayList = arrayListOf<Int>(0,10)
    arrayList.add(20)
    arrayList.add(30)
    arrayList[0] = 1
    println(arrayList)
}