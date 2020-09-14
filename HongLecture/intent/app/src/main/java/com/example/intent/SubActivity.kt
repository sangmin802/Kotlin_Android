package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        if(intent.hasExtra("msg") && intent.hasExtra("num")){
            tv_getMsg.text = intent.getStringExtra("msg")
            tv_getNum.text = intent.getIntExtra("num", 700).toString()
        }
    }
}