package com.example.coruoutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//fun main() = runBlocking {
////    예제1
////      서로 의존성있는 메소드일 때
////      코루틴 내부에서 중단메소드를 활용하면 꿈의 코드처럼 순차적으로 작동된다.
//    var one = 0
//    var two = 0
//    val time = measureTimeMillis {
//        one = doSomethingUsefulOne() // 첫번째 중단
//        two = doSomethingUsefulTwo(one) // 두번째 중단
//        println("The answer is ${one+two}")
//    }
//    println("Completed in $time ms")
//}
//
//suspend fun doSomethingUsefulTwo(_one : Int): Int {
//    delay(1000)
//    return _one+13
//}
//
//suspend fun doSomethingUsefulOne(): Int {
//    delay(1000)
//    return 29
//}

fun main() = runBlocking {
//    예제2
//      예제 1과 동일하게 스레드 내부에서 중단함수가 있기 때문에 메인스레드를 읽는것은 중단하긴 하지만,
//      서로 연관되어있지 않기 때문에 각기 *동시*에 실행시키고 결과값만 기다림
//      위는 2초걸리지만 얘는 1초걸림

//      launch 빌더는 job 클래스를 반환하지만, async는 job에게 상속받는 deferred클래스를 반환받음음
//      따라서 cancel, join 모두 사용가능하지만 await이라는게 생김
   val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() } // 첫번째 중단
        val two = async { doSomethingUsefulTwo() } // 두번째 중단
        println("The answer is ${one.await()+two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000)
    return 13
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000)
    return 29
}