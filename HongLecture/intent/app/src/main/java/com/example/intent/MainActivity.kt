package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        activity와 activity간 화면이동 및 정보전달은 intent객체를 사용하면 된다.
//        하지만 우리 이전에 사용했던 하나의 mainactivity만 두고 내부에서 fragment만 바뀌는 navigation방법도 있다.
        btn_a.setOnClickListener {
//            다음 화면으로 이동하기 위해 intent 객체 생성.
            val intent = Intent(this, SubActivity::class.java)
//            보내지는 intent객체에 같이보낼 변수 담기.
//            intent.putExtra("msg", tv_sendMsg.text.toString())

//            혹은, Fragment와 Activity 동일하게 bundleOf메소드를 이용하면 더 편리하다.
            val bundle = bundleOf("msg" to tv_sendMsg.text.toString(), "num" to 1)
            intent.putExtras(bundle)
            startActivity(intent) // intent객체에 담긴 activity로 이동한다.

            finish() // 현재의 activity를 파괴한다.
//            뒤로가기누르면 아예 앱이 꺼짐
        }
    }
}