package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

//  안드로이드는 서버 DB가 아닌 개인적으로 가지고 있는 간이 데이터베이스가 있다.
//  굳~~~~~~~~~~이 따지면 웹사이트의 쿠키같은건가?
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        앱이 호출되었을 때, 저장되어있던 데이터 불러오기
        loadData()
    }


    //    앱이 종료되는 시점에 호출
    override fun onDestroy() {
        super.onDestroy()

//        앱이 종료될 때, 데이터 저장
        saveData()
    }

    fun saveData() {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() // 추가나 수정
        edit.putString("text", et_inputText.text.toString()) // 첫번째 인자는 키, 두번째 인자는 실제 저장되는 값
        edit.apply() // 저장 완료
    }

    fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        et_inputText.setText(pref.getString("text", "")) // 첫번째 인자는 찾는 키, 찾는 키가 없다면 대체되는 값
    }
}