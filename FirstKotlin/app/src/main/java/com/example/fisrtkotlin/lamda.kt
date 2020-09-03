package com.example.fisrtkotlin

fun main(){
// 람다식 함수의 기본 정의
    println(square(12))
    println(nameAge("Sangmin", 26))

// 확장함수
    val text = "Sangmin said, "
    println(text.pizzeIsGreat())

// 확장함수 + 람다식
    println(extendString("Sangmin", 26))
    println(loaChar("모여요꿈동산","바드",998))

// 람다식 함수의 Return
    println(calculateGrade(90))

// 람다식 함수를 표현하는방법
// 1.
    val lambda : (Double) -> String = {number ->
        when(number){
            4.2343 -> "맞아요"
            else -> "달라요"
        }
    }
    println(invokeLambda(lambda))
// 2. 람다 리터럴
//    * 만약 보내지는 인자가 람다식 함수 단 하나(처음이자 마지막)일 경우, ()를 지워줘도 된다
    println(invokeLambda{
        when(it){
            5.2343 -> "맞아요"
            else -> "달라요"
        }
    })
}


// 람다식 함수
// 람다식 함수는 value 처럼 다룰 수 있는 익명함수이다.
// JavaScript에 추가된 Arrow function 처럼 함수를 인자로 보내는 콜백함수들
//      - 메소드에 파라미터로 넘겨줄 수 있다 fun maxBy(람다식 함수)
//        JS라면 arr.forEach(() => {}) - forEach메소드에 메소드를 파라미터로 보내줌
//      - return 값으로 사용할 수 있다.

// 람다식 함수의 기본 정의
// val lamdaName : 입력인자타입 -> 리턴타입(없으면안씀) = {변수 -> 코드이름}
// val lamdaName = {변수 : Int -> 코드이름}
val square : (Int) -> Int = {number -> number*number}
val nameAge = {name : String, age : Int ->
    "My name is ${name}, I'm ${age}"
}

// 람다식 함수의 Return
// 기본적으로 람다식 함수의 마지막 구문은 늘 return되는 값이다.
val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다식 함수를 표현하는 방법
// 중요한점
//      * 람다식 함수를 인자로 받는 함수는, 변수 입력칸에 변수명과 해당 람다식함수의 인자타입과 리턴타입을 기재해줘야한다.
fun invokeLambda(getLambda : (Double) -> String) : String {
    return getLambda(5.2343)
}

// 확장함수
// JS에서 prototype같은거인듯
// 기존 String 객체에 사용자지정 속성을 추가한 것
//      ex) String.(인자), Number.()...
// this는 내가 보내준 string객체이며 인자가 하나일경우 it으로 받을 수 있다. 아니면 다 써줘야함
val pizzeIsGreat : String.() -> String = {
    this+"Pizze is the best!"
}

// 확장함수 + 람다식
// 변수1개
fun extendString(name : String, age : Int) : String {
    val introduceMySelf : String.(Int) -> String = {
        "I am ${this} and ${it} years old"
    }
    return name.introduceMySelf(age)
}
// 변수2개
// 1. loaChar 실행
// 2. String 클래스(객체)에 상속받는 람다식 함수 생성
// 3. name은 String 타입이고,
//    String 클래스에는 introduceMySelf라는 람다식 메소드가 생성되어있기 때문에
//    name은 해당 메소드를 사용할 수 있음. 그리고 그 결과를 반환.
fun loaChar(name : String, job : String, lv : Int) : String {
    val introduceMySelf : String.(String, Int) -> String = {_job, _lv ->
        "Name is ${this}, Class is ${_job}, Item Level is ${_lv}"
    }
    return name.introduceMySelf(job, lv)
}
// 확장함수 vs 람다식함수
// 두개의 큰 차이는 없지만, 확장함수는 기존에 있는 class에 사용자지정 메소드를 추가한다.

// 익명 내부 함수
// 나중에, 버튼클릭처럼 이벤트를 부여해줄 때 익명내부함수가 아닌 람다식 함수를 이용해 좀 더 짧게 코드를 짤 수 있다.
// 단 몇몇 조건이 있는데,
//      1. 코틀린 인터페이스가아닌 자바 인터페이스인 경우
//      2. 그 인터페이스는 단 하나의 메소드만 실행할 경우