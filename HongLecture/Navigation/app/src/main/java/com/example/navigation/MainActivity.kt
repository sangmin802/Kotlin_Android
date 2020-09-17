package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

//  햄버거나 사이드에서 나오는 슬라이드 네비게이션을 만들 수 있다.
//  gradle에 추가
//  implementation 'com.google.android.material:material:1.0.0'

//      1. res폴더에 네비게이션 메뉴를 다룰 menu res dir을 만들어준다.
//          type을 menu로 해줘야 한다.
//          Tip! drawble의 new에서 --asset을 통해, 안드로이드에서 제공하는 기본 이미지들을 사용할 수 있다.
//      2. menu를 구성하는 태그들을 만들어준다.
//      3. activity_main에서 외부태그를 constraint가 아닌, DrawerLayout으로 변경해준다
//          DrawerLayout이란, Hamburger, Sandwich라 불리는 버튼을 눌렀을 때 화면 사이드에서 스와이프 되며 나오는 view를 말한다.
//      4. DrawerLayout 바로 아래에, material.navigation.NavigationView태그를 추가하고, android:layout_gravity="start"를 통해, 화면 왼쪽으로 빼준다.

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener { // Navigation 관련 클래스들을을 상속받음
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_btn.setOnClickListener {
//            왼쪽방향에서 밀어라
            layout_drawer.openDrawer(GravityCompat.START) // START = Left, END = Right
        }

//      네비게이션 뷰에 아래의 아이템 클릭기능 부여 (상속받았던 클릭이벤트에 override한것이기 때문에, this)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { // Navigaion 메뉴 클릭 시 수행
        when(item.itemId){ // nav_menu의 item들의 아이디
            R.id.access -> Toast.makeText(this, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(this, "이메일", Toast.LENGTH_SHORT).show()
            R.id.send -> Toast.makeText(this, "메시지", Toast.LENGTH_SHORT).show()
        }
//        위의 과정을 진행하고, navigation을 닫아줘
        layout_drawer.closeDrawers()
        return false
    }


//    Nav가 켜져있을 때, 뒤로가기를 눌러도 앱이 꺼지지않고 Nav가 닫히도록
    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.START)){ // Nav가 열려있는 상태면
            layout_drawer.closeDrawers() // Nav만 닫아
        }else{
            super.onBackPressed() // 일반 백버튼 실행
        }
    }
}