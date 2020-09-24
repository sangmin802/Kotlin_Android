package com.example.coruoutine

import kotlin.concurrent.thread

// 코루틴
//      루틴들이 협동하여 모여있는것이 코루틴이다.
//      코루틴은 이전에 자신의 실행이 마지막으로 중단되었던 지점 다음장소에서 실행을 재개한다.

//  일반루틴 : 진입한번, 종료한번
//  코루틴 : 진입, 중단 - 재개, 중단 - 재개, 종료

//  코루틴은 여러방면에서 활용될수 있지만, 대표적으로 비동기작업에 적합하다.
//      1. 비동기처리에 적합하다.
//      2. 메인 스레드가 블로킹되는것을 방지할 수 있다.

//  코루틴의 등장배경
//      꿈의 코드 1
//          val user = fetchUserData()
//          textView.text = user.name
//      main thread에서는 http통신을 할 수 없으므로 에러가 발생함

//          * thread는 간단히 말하여 작업을 수행하는 코어라고 보면됨.

//      꿈의 코드 2
//          thread {
//              val user = fetchUserData()
//              textView.text = user.name
//          }
//      별도의 thread를 만들어서 따로 작동을 돌리기때문에 http통신에는 문제가 없지만, UI관련 작업은 main thread에서만 가능하여 에러 발생함

//      꿈을 포기한 현실적인 코드
//          fetchUserData { user ->
//              textView.text = user.name
//          }
//      fetchUserData함수에, 콜백함수로 중괄호 부분을 변수로 보낸 뒤, fetchUserData함수가 종료되어 나온 user값을 콜백함수의 user 인자로 보내서 진행
//      돌아가긴 하지만, 콜백지옥과 메모리문제등이 생긴다.

//      코루틴을 통한 꿈 실현
//          suspend fun loadUser(){
//              val user = api.fetchUser()
//              show(user)
//          }
