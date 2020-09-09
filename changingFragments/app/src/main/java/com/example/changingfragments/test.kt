package com.example.changingfragments

import java.net.URL
import java.net.URLEncoder

fun main(){
//    HTTP Reauest
//    안드로이드는 진짜 완전 쌩 영어만 되나봄
//    따라서 한글로된 query는 아래의 방법으로 인코딩해줘야함
    println((URL("https://codingtest.op.gg/api/summoner/${URLEncoder.encode("상민", "UTF-8")}").readText()))
}
