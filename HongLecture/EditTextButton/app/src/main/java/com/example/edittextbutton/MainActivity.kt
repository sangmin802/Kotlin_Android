package com.example.edittextbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Edit Text = Plain Text
//        Frontend단에서 input text와 같은 기능
//          android:hint === placeholder

        btn_getText.setOnClickListener{
//            버튼 클릭시, Edit Text에 입력된 값을 가져와서 Text에 적용시켜줄거임

//            Edit Text에 입력된 값을 문자열로 가져와주세요.
            val resultText = et_id.text.toString()
//            가져온 값을 적용시켜주세요.
            tv_result.setText(resultText)
        }
    }
}