package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

//  Fragment
//  Activity간 화면 전환이 아닌, 한 Activity안에서 부품만 교체 되는것
//  프론트엔드 프레임워크에서 컴포넌트 기능인 듯 하다.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFrag(0)

        btn_fragment1.setOnClickListener {
            setFrag(0)
        }
        btn_fragment2.setOnClickListener {
            setFrag(1)
        }
        btn_fragment3.setOnClickListener {
            setFrag(2)
        }
    }

    private fun setFrag(fragNum : Int) {
//        Fragment 연결
        val ft = supportFragmentManager.beginTransaction()
        when(fragNum){
            0 -> {
                ft.replace(R.id.main_frame, Fragment1()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, Fragment2()).commit()
            }
            2 -> {
                ft.replace(R.id.main_frame, Fragment3()).commit()
            }
        }
    }
}