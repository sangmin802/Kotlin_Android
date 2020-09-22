package com.example.recyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val url = "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/pc/information/class/"
    val GameCharList = arrayListOf<Char>(
        Char("${url}img_detail_warlord_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Warlord"),
        Char("${url}img_detail_berserker_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Berserker"),
        Char("${url}img_detail_destroyer_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Destroyer"),
        Char("${url}img_detail_holyknight_s.png?a30e28ffc1cfe5cf1991", "Warrior", "Holyknight"),
        Char("${url}img_detail_battlemaster_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Battle Master"),
        Char("${url}img_detail_infighter_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Infighter"),
        Char("${url}img_detail_soulmaster_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Soul Master"),
        Char("${url}img_detail_lancemaster_s.png?a30e28ffc1cfe5cf1991", "Fighter", "Lance Master"),
        Char("${url}img_detail_devilhunter_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Devil Hunter"),
        Char("${url}img_detail_blaster_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Blaster"),
        Char("${url}img_detail_hawkeye_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Hawk Eye"),
        Char("${url}img_detail_scouter_s.png?a30e28ffc1cfe5cf1991", "Hunter", "Scouter"),
        Char("${url}img_detail_bard_s.png?a30e28ffc1cfe5cf1991", "Magician", "Bard"),
        Char("${url}img_detail_summoner_s.png?a30e28ffc1cfe5cf1991", "Magician", "Summoner"),
        Char("${url}img_detail_arcana_s.png?a30e28ffc1cfe5cf1991", "Magician", "Arcana"),
        Char("${url}img_detail_blade_s.png?a30e28ffc1cfe5cf1991", "Assassin", "Blade"),
        Char("${url}img_detail_demonic_s.png?a30e28ffc1cfe5cf1991", "Assassin", "Demonic")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        수직으로 생성
//        rv_recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

//        수평으로 생성
//        rv_recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

//        그리드로 생성
        rv_recyclerView.layoutManager = GridLayoutManager(this, 2)
        rv_recyclerView.setHasFixedSize(true) // recyclerView 성능개선

        rv_recyclerView.adapter = CharAdapter(GameCharList)
    }
}