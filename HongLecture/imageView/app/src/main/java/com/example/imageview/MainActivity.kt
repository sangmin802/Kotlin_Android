package com.example.imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        이미지 url로 적용시키기
//        gradle파일에 Glide기능 추가
//            implementation 'com.github.bumptech.glide:glide:4.11.0'
//            annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
//        mainifests 파일에 추가하여 인터넷 url에 접근할 수 있도록 함
//            <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
//            <uses-permission android:name="android.permission.INTERNET" />
//        이후 아래과정 진행
        val url = "https://scontent-gmp1-1.xx.fbcdn.net/v/t1.0-9/117331960_4247747288629673_9203310391566836283_n.jpg?_nc_cat=100&_nc_sid=6e5ad9&_nc_ohc=H1GByJl8wwEAX8FlKmt&_nc_ht=scontent-gmp1-1.xx&oh=fa43c6789b445fde7275304896182b26&oe=5F82C4BF"
        Glide.with(this).load(url).into(iv_loastArk)

        btn_toast.setOnClickListener {
//            alert같은건가봄
//            토스트메시지를 실행시켜라.
//            첫번째 인자는 현재 액티비티. 두번째인자는 출력되는 글, 세번째는 유지시간
            Toast.makeText(this@MainActivity, "Android with Kotlin", Toast.LENGTH_SHORT).show()

//            토스트 버튼 클릭시 이미지 변경
//            res 디렉토리의 drawble 디렉토리의 android2
            when(iv_android.getTag()){
                "0" -> {
                    iv_android.setTag("1")
                    iv_android.setImageResource(R.drawable.android)
                }
                "1" -> {
                    iv_android.setTag("0")
                    iv_android.setImageResource(R.drawable.android2)
                }
            }
        }
    }
}