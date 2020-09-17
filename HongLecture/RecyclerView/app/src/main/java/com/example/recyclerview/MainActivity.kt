package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


//  업데이트 이후, ListView와 GridView를 대체하여 새로운 코드가 생겼다.
//  RecyclerView
//      100개의 리스트가 있다면, 모두불러오는것이아닌 지정한 수만큼만 불러오고, 이후 스크롤을 통해 추가적으로 불러온다.
//      초기 진행속도를 비교적 빠르게하려는것 같다.

class MainActivity : AppCompatActivity() {
    val url = "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/information/class/"
    val GameCharList = arrayListOf<GameCharClass>( // arraylist를 만들껀데, GameChar클래스 타입들을 넣어
        GameCharClass("${url}img_detail_warlord_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Warlord"),
        GameCharClass("${url}img_detail_berserker_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Berserker"),
        GameCharClass("${url}img_detail_destroyer_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Destroyer"),
        GameCharClass("${url}img_detail_holyknight_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Holyknight"),
        GameCharClass("${url}img_detail_battlemaster_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Battle Master"),
        GameCharClass("${url}img_detail_infighter_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Infighter"),
        GameCharClass("${url}img_detail_soulmaster_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Soul Master"),
        GameCharClass("${url}img_detail_lancemaster_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Lance Master"),
        GameCharClass("${url}img_detail_devilhunter_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Devil Hunter"),
        GameCharClass("${url}img_detail_blaster_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Blaster"),
        GameCharClass("${url}img_detail_hawkeye_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Hawk Eye"),
        GameCharClass("${url}img_detail_scouter_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Scouter"),
        GameCharClass("${url}img_detail_bard_s.png?a30e28ffc1cfe5cf1991", "Magician", "Bard"),
        GameCharClass("${url}img_detail_summoner_s.png?a30e28ffc1cfe5cf1991", "Magician", "Summoner"),
        GameCharClass("${url}img_detail_arcana_s.png?a30e28ffc1cfe5cf1991", "Magician", "Arcana"),
        GameCharClass("${url}img_detail_blade_s.png?a30e28ffc1cfe5cf1991", "Assassin", "Blade"),
        GameCharClass("${url}img_detail_demonic_s.png?a30e28ffc1cfe5cf1991", "Assassin", "Demonic")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CustomAdapter()
        adapter.listData = GameCharList
        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}