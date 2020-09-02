package com.example.fisrtkotlin

fun main(){
    nullCheck()
    ignoreNulls("sangmin")
}

// NonNull & Nullable
fun nullCheck(){
// '?' - Nullable타입이야
    var name : String  = "sangmin" // NonNull타입
    // 문자열 숫자열 모두 NonNull 타입이지만, 타입 뒤에 '?'를 붙여준다면 Nullable타입이 된다.
    var nullName : String? = null // Nullable 타입

    var nameInUpperCase = name.toUpperCase() // 바로가능
    // Nullable 타입의 값은 특정 메소드를 적용시켜줄 때
    // Null인지 아닌지 메소드가 파악하지못해 에러가 생긴다.
    // 이런 경우, 해당 메소드를 적용시키는 값 뒤에 ?를 붙여주게된다면
    // Null이 아니면 해당 메소드 적용, Null이면 그냥 Null 반환
    var nullNameInUpperCase = nullName?.toUpperCase() // 에러
    println("NonNull : ${nameInUpperCase} Nullable : ${nullNameInUpperCase}")

// '?:' - 기존 ?는 Null이라면 Null 자체를 반환하게했다면 얘는 Null일경우 반환값을 설정할 수 있다
// - 눕힌 모습이 엘비스프레슬리를 닮아 실제 용어가 엘비스연산자라고함; ㄷㄷ
    val lastName : String? = null
    val fullName = name + (lastName?:" (No lastName)")
    println(fullName)
}


fun ignoreNulls(str : String?){
    // !! - Nullable타입이긴한데 Null은 아니야
    // 변수로 Null이 올수 있다고쓰긴했는데, Null 절대 안오니깐 String타입으로 진행해
    // 다만, 절대라는것은 없기때문에 사용을 지양하자
    val notNull : String = str!!
    val upper : String = notNull.toUpperCase()
    println(upper)

    // let - 만약 앞의 값이 Null이 아니라면 내가 지정해주는걸로 진행시켜줘
    // email이 null이면 println이 실행안됨.
    // '?' 랑 비슷해보이지만, '?'는 println을 실행시켜 null이라는 값이보임
    // let은 아예 println을 실행시키지 않아 좀 더 안정성있음    
    val email : String? = "sangmin802@naver.com"
    email?.let{
        println("my email is ${it}")
    }
    
}