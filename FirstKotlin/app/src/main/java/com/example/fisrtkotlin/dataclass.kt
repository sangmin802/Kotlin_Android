package com.example.fisrtkotlin

fun main(){
    val ticketA = Ticket("KoreanAir", "Sangmin", "2020-09-04", 26)
    val ticketB = TicketNormal("KoreanAir", "Sangmin", "2020-09-04", 26)
    println(ticketA) // 내용을 바로 볼 수 있음
    println(ticketB) // 내용이 담겨져있는 주소로 나옴
}

// Data Class
//      데이터를 담는 클래스
data class Ticket(
    val companyName : String,
    val name : String,
    var date : String,
    var seatNumber : Int
)
// 이게 끝임
// 일반 클래스
class TicketNormal(
    val companyName : String,
    val name : String,
    var date : String,
    var seatNumber : Int
)