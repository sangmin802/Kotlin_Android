package com.example.coruoutine

import kotlinx.coroutines.*

//fun main() = runBlocking<Unit> {
////    Dispatchers and threads
////      Dispathers : 코루틴이 어떠한 thread에서 실행이 될지 결정해주는 것
////      모든 코루틴 빌더들은 선택적으로 Dispathers를 설정할 수 있다
//
////      자신을 호출했던 코루틴의 영역을 상속받음음
//   launch {
//        println("main runBlocking : I'm workin in thread ${Thread.currentThread().name}")
//    }
//    launch(Dispatchers.Unconfined) {
//        println("Unconfined : I'm workin in thread ${Thread.currentThread().name}")
//    }
////    GlobalScope에서 실행되는 thread
//    launch(Dispatchers.Default) {
//        println("Default : I'm workin in thread ${Thread.currentThread().name}")
//    }
////    직접 thread 생성
////      비추천
//    launch(newSingleThreadContext("MyOwnThread")) {
//        println("MyOwnThread : I'm workin in thread ${Thread.currentThread().name}")
//    }
//}

//fun main() {
////    Jumping between threads
////      Thread간 이동
//
////    runBlocking때는 ctx1 스레드에서 진행
////    withContext에서 ctx2 스레드에서 진행
////    ctx1로 복귀
//    newSingleThreadContext("Ctx1").use { ctx1 ->
//        newSingleThreadContext("Ctx2").use { ctx2 ->
//            runBlocking(ctx1) {
//                println("Started in ctx1")
//                withContext(ctx2) {
//                    println("Working in ctx2")
//                }
//                println("Back to ctx1")
//            }
//        }
//    }
//}

//fun main() = runBlocking<Unit> {
////    coroutineContext[Job]을통해 현재의 컨텍스트를 확인할 수 있다.
////    isActive 는 coroutineContext[Job]?.isActive로 현재 컨텍스트가 실행중인지 확인할 수 있다.
//    println("My job is ${coroutineContext[Job]}")
//    launch {
//        println("My job is ${coroutineContext[Job]}")
//    }
//    async {
//        println("My job is ${coroutineContext[Job]}")
//    }
//}

//fun main() = runBlocking {
////    Children of coroutine
////      일반 launch는 request 코루틴의 영향을 받아 cancel시 작동이 안된다.
////      GlobalScope는 전역스코프로 request 코루틴에게 영향을 받지않아 cancel이 되더라도 작동된다.
//    val request = launch {
//        GlobalScope.launch {
//            println("job1 : I run in GlobalScope and execute independently!")
//            delay(1000)
//            println("job1 : I am not affected bt cancellation of the request")
//        }
//
//        launch {
//            delay(100)
//            println("job2 : I am a child of the request coroutine")
//            delay(1000)
//            println("job2 : I will not execute this line if my parent request is cancelled")
//        }
//    }
//    delay(500)
//    request.cancel()
//    delay(1000)
//    println("main : Who has survived request cancellation?")
//}

//fun main() = runBlocking {
////    Parental responsibilities
////      자식이 같은 스코프로 상속받는 코루틴이라면 완료될때까지 기다린다.
//    val request = launch {
//        repeat(3) { i ->
//            launch {
//                delay((i+1)*200L)
//                println("Coroutine $i is done")
//            }
//        }
//        println("request : I'm done and I don't explicitly join my children that are still active")
//    }
//    request.join()
//    println("Now processing of the request is complete")
//}

////  Coroutine scope
////      코루틴을 통해 작업을 하다가, 사용자가 뒤로가기등으로 앱을 종료하였을 때 모두 cancel시켜줘야한다.
////      그런데 수많은 코루틴들을 모두 cancel() 하나하나 입력해주는것은 비효율적이다.
//
////      모든 코루틴들을 담고있는 하나의 코루틴 스코프를 만들고 화면을 나갈 때 그 스코프만 종료시켜줌녀 된다.
//class Activity {
//    private val mainScope = CoroutineScope(Dispatchers.Default)
//
//    fun destroy() {
//        mainScope.cancel()
//    }
//    fun doSomething() {
//        repeat(10) { i ->
//            mainScope.launch {
//                delay((i+1)*200L)
//                println("Coroutine $i is done")
//            }
//        }
//    }
//}
//
//fun main() = runBlocking {
//    val activity = Activity()
//    activity.doSomething()
//    println("Launched coroutines")
//    delay(500)
//    println("Destroying activity!")
//    activity.destroy()
//    delay(1000)
//}