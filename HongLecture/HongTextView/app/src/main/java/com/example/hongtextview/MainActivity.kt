package com.example.hongtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


// 기본적으로 xml파일하나 kt파일 하나가 하나의 화면을 구성한다
//  xml파일은 정적인 파일이다
//      프론트엔드에서 HTML, CSS와 같은 기능
//  kt파일은 동적인 파일이다
//      프론트엔드에서 script 부분\

class MainActivity : AppCompatActivity() {

//    onCreate
//      앱이 최초로 실행되었을 때, 수행되는 것
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//    R은 res(resources)폴더를 의미한다.
//    setContentView xml 파일을 연결한다.
//      해당 메소드로 연결했기 때문에, xml파일에서 id값들을 호출할 수 있다.
        setContentView(R.layout.activity_main) // res폴더의 layout폴더의 activity_main파일

        tv_title.setText("LostArk\nseason2")
    }
}