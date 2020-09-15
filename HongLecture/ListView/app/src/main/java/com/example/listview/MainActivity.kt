package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val url = "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/information/class/"
    val GameCharList = arrayListOf<GameChar>( // arraylist를 만들껀데, GameChar클래스 타입들을 넣어
        GameChar("${url}img_detail_warlord_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Warlord"),
        GameChar("${url}img_detail_berserker_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Berserker"),
        GameChar("${url}img_detail_destroyer_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Destroyer"),
        GameChar("${url}img_detail_holyknight_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Holyknight"),
        GameChar("${url}img_detail_battlemaster_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Battle Master"),
        GameChar("${url}img_detail_infighter_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Infighter"),
        GameChar("${url}img_detail_soulmaster_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Soul Master"),
        GameChar("${url}img_detail_lancemaster_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Lance Master"),
        GameChar("${url}img_detail_devilhunter_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Devil Hunter"),
        GameChar("${url}img_detail_blaster_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Blaster"),
        GameChar("${url}img_detail_hawkeye_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Hawk Eye"),
        GameChar("${url}img_detail_scouter_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Scouter"),
        GameChar("${url}img_detail_bard_s.png?a30e28ffc1cfe5cf1991", "Magician", "Bard"),
        GameChar("${url}img_detail_summoner_s.png?a30e28ffc1cfe5cf1991", "Magician", "Summoner"),
        GameChar("${url}img_detail_arcana_s.png?a30e28ffc1cfe5cf1991", "Magician", "Arcana"),
        GameChar("${url}img_detail_blade_s.png?a30e28ffc1cfe5cf1991", "Assassin", "Blade"),
        GameChar("${url}img_detail_demonic_s.png?a30e28ffc1cfe5cf1991", "Assassin", "Demonic")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val item = arrayOf("사과", "배", "딸기", "키위")
//        ListView는 adapter로 연결이 되어있어야 값을 넣어줄 수 있다.
//        this(context)는 한 activity의 모든 정보를 담고있다
//        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

//        단 위처럼 제공되는 기본 어뎁뎁터는 단순 하의 데이터만 나열해주기때문에, 실제로는 커스텀 어뎁터를 사용한다.
//        커스텀 어뎁터 만들기
//          1. 모델 객체 만들기.
//          2. 반복이 될 리스트 레이아웃 구성하기.
//          3. 해당 리스트를 반복시킬 어뎁터 만들기.
//          4. 해당 아이디의 ListView의 어뎁터로 설정한다.
        val Adapter = GameCharAdapter(this, GameCharList)
        listView.adapter = Adapter

//        리스트 클릭 시
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
//            내가 클릭한 아이템
            val selectedItem = parent.getItemAtPosition(position) as GameChar // 해당 index번째의 GameChar 클래스
            Toast.makeText(this, selectedItem.detaliClass, Toast.LENGTH_SHORT).show()
        }
    }
}