package com.example.coruoutine

import kotlinx.coroutines.*

//fun main() {
////    예제1
////      .launch와 같은 속성들을 코루틴 빌더라고 하며, 해당 코루틴 빌더 이후 중괄호 내부에서 코루틴이 실행된다.
////      이러한 빌더들은 내부적으로 코루틴을 만들어서 반환하며, 앞에 스코프영역이 필요하다.
////          GlobalScope : 수명주기가 프로그램 전체(프론트단에서 GO)
////              -> 해당 앱이 종료될때까지 작동됨
//    GlobalScope.launch {
//        delay(1000)
//        println("World!")
//    }
//    Thread { // 결과는 같음
//        Thread.sleep(1000)
//        println("World!")
//    }
//    println("Hello, ")
//    Thread.sleep(2000) // 2초동안 해당 Thread(Main thread) 잠재움
//
////    결론
////      * 코루틴은 가벼운 Thread (별도의 프로그램 진행 코어)라 볼 수 있다.
//}


//fun main(){
////    예제2
////      위의 예제에서 코루틴 내부에서는 delay메소드가 작동되었지만,
////      코루틴 외부에서는 delay메소드를 사용하면 에러가 나와서 Thread.sleep을 사용하였다.
////      delay는 suspend메소드(중단기능) 이므로, 같은 suspend메소드나 코루틴 내부에서만 작동된다.(코루틴의 장점이였던 중단기능)
//    GlobalScope.launch {
//        delay(1000)
//        println("World!")
//    }
//    println("Hello, ")
////      runBlocking이 없다면 코루틴 영역에서 1초뒤 실행되는 World는 출력되지 않고 Main thread가 종료됨
////      runBlocking또한 코루틴 빌더로, 코루틴을 생성한다.
////      단 다른 빌더들과 다르게, 해당 빌더는 중괄호 내의 작업들이 수행될 때 까지 현재의 Thread(Main thread)를 중단시킨다.
//    runBlocking {
//        delay(2000)
//    }
//    println("runBlocking End")
//
////    결론
////      1. delay와 같은 suspend(지연) 메소드는 코루틴 영역 내부에서만 실행 가능하다.
////      2. runBlocking또한 코루틴 빌더이지만, 해당 빌더는 영역 내의 작업이 모두 수행될때까지 현재의 Thread를 중단시킨다.
//}

//fun main() = runBlocking {
////    예제3
////      Main thread 자체를 runBlocing빌더의 코루틴으로 하여 해당 영역 내의 작업들이 모두 끝날때까지 종료를 중단.
//    GlobalScope.launch {
//        delay(1000)
//        print("World!")
//    }
//    println("Hello, ")
//    delay(2000)
//}

//fun main() = runBlocking {
////    예제4
////      상식적으로 일을 할 때, 지연되는 시간이 우리의 뜻대로 되지않기때문에 delay는 매우 비효율적이다.
////      코루틴 빌더가 반환하는 코루틴을 변수에 담고, 해당 변수에 담은 뒤, join메소드를 실행시켜서 모든 과정이 완료되 후에 thread가 종료되도록 한다.
//    val job = GlobalScope.launch {
//        delay(1000)
//        println("World!")
//    }
//    println("Hello, ")
//    job.join()
//}

//fun main() = runBlocking {
////    예제5
////      만약, GlobalScope로 여러개의 코루틴 이 생성되었다면, 그만큼 join()을 통해 기다리도록 해야한다.
////      현재 구조적으로 runBlocing으로 코루틴 빌더를 갖고있는 Main thread와 내부에서 GlobalScope.launch의 코루틴빌더는
////      서로 다른 스코프이기 때문에 서로를 기다려주지않아 join을 사용하는것이다.
////      그렇다면 runBlocking을 통해 받아오는 CoroutineScope를 기반으로 launch를 한다면?
////      모든 코루틴 구문을 기다려준다.
////          this는 생략가능
//    this.launch {
//        delay(1000)
//        println("Kotlin ")
//    }
//    this.launch {
//        delay(2000)
//        println("with ")
//    }
//    this.launch {
//        delay(3000)
//        println("Coroutine ")
//    }
//    this.launch {
//        delay(4000)
//        println("World!")
//    }
//    println("Hello, ")
////    결론
////      상위 코루틴은 자신이 가지고있는 하위 코루틴들이 자신과 같은 영역을 보고있다면, 모든 작업을 기다려준다.
//}

//fun main() = runBlocking {
////    예제 5-1
////      laucn뒤에 join()메소드로 대기하게하여 순차적으로 프로그래밍을 할 수 있다.
//    var text = "banana"
//    launch {
//        delay(2000)
//        text = "Chicken"
//    }.join()
//    launch {
//        delay(1500)
//        text+="is delicious"
//    }.join()
//    println(text)
//}

//fun main() = runBlocking {
////    예제6
////      만약 내부의 코드를 별도의 함수로 빼고자 할 때, 앞에 suspend를 붙여서 해당 코루틴 내부에서 기다리도록 할 수 있다.
//    launch {
//        doWorld()
//        println("World!")
//    }
//    println("Hello, ")
//}
//
//suspend fun doWorld() {
//    delay(1000)
//    println("Kotlin ")
//}

//fun main() = runBlocking {
////    예제7
////      10만번을 반복하여 코루틴빌더를 통해 코루틴을 만들어도 잘 작동함
////      코루틴은 매우 가벼움
////      저거 Thread로 바꾸면 엄청 버벅이고 렉걸림
//    repeat(100_000){
//        launch {
//            delay(1000)
//            println(".")
//        }
//    }
//}

//fun main() = runBlocking {
////    예제8
////      서로 다른 코루틴 스코프이기 때문에, Main thread는 기다려주지않음.
////      만약 저기서 GlobalScope가 없다면 기다려줌.
//    GlobalScope.launch {
//        repeat(1000){i ->
//            println("I'm sleeping $i ...")
//            delay(500)
//        }
//    }
//    delay(1300)
//}

//fun main() = runBlocking {
////    예제9
////      println을 개조하여 어떤 thread에서 작동되는지 볼 수 있음
//    launch {
//        repeat(5) {
//            println("Coroutine A, $it")
//        }
//    }
//    launch {
//        repeat(5) {
//            println("Coroutine B, $it")
//        }
//    }
//    println("Coroutine Outer")
//}
//
//fun <T>println(msg : T) {
//    kotlin.io.println("$msg [${Thread.currentThread().name}]")
//}