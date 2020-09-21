package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

// 웹뷰
// 안드로이드 화면을 웹의 화면으로 대체할 수 있다.
// 반응형 환경이 구현된 웹 어플리케이션이라면, 해당 기능을 통해 간단하게 안드로이드 앱으로 만들 수 있다.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        웹뷰 셋팅
//        자바스크립트 기능 허용
        wv_webView.settings.javaScriptEnabled = true
//        아래 두줄이 없다면 새로운 창을 띄워버림
        wv_webView.webViewClient = WebViewClient()
        wv_webView.webChromeClient = WebChromeClient()

//        웹뷰 연결
        wv_webView.loadUrl("https://sangmin802.github.io/haemulhansang/#/")
//        Tip!
//          mainifests의 thema에서 noactionbar를 통해, 상단 바를 지울 수 있다.
    }

    override fun onBackPressed() {
        if(wv_webView.canGoBack()) { // 웹사이트에서 뒤로갈 페이지가 존재한다면
            wv_webView.goBack()
        }else{
            super.onBackPressed()
        }
    }
}