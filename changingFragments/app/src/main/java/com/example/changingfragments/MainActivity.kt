package com.example.changingfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.changingfragments.fragment.FirstFragment
import com.example.changingfragments.fragment.SecondFragment
import com.example.changingfragments.fragment.ThirdFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      첫 화면은 1
        supportFragmentManager.beginTransaction().replace(R.id.view, FirstFragment()).commit()

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        Fragment를 관리하기 위해서는 supportFragmentManager를 사용해야한다.
//        supportFragmentManager.beginTransaction()를 통해, 첫번째 인자의 아이디를 가지고있는FrameLayout
//        을 두번째 인자의 Fragment로 변경할 수 있다.
//        Log.i("콘솔", "${v}")
        when(v?.id){
            R.id.btn1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.view, FirstFragment()).commit()
            }
            R.id.btn2 -> {
                supportFragmentManager.beginTransaction().replace(R.id.view, SecondFragment()).commit()
            }
            R.id.btn3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.view, ThirdFragment()).commit()
            }
        }
    }
}