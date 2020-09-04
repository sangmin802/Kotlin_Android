package com.example.fisrtkotlin

fun main(){
//    val book = Book() <- private이라 안됨
    val book = Book.BookFactory.create() // Companion은 생략가능하다.
    println("${book.id} ${book.name}")
}

// Companion Object
//      정적인 메소드나 정적인 변수를 만들 때 사용한다.
class Book private constructor(val id : Int, val name : String){
//    private은 해당 클래스는 외부에서는 접근이 불가능하고 내부에서만 접근가능하다.
//    따라서, companimon object를 사용하여 해당 private 클래스의 속성들을 읽어올 수 있다.(static같은 역활)
    companion object BookFactory : IdProvider {
        override fun getId() : Int {
            return 444
        }
        val myBook = "animal farm"
        fun create() = Book(getId(), myBook)
    }
}

interface IdProvider { // 클래스랑 비슷한역할인데 차이가있음
    fun getId() : Int
}