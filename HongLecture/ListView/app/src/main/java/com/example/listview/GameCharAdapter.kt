package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

// 이거 React할 때, .map으로 컴포넌트 반복시킨거랑 많이 비슷한듯함
class GameCharAdapter (
    val context : Context, // activty의 정보를 담고있는 컨텍스트
    val CharList : ArrayList<GameChar> // GameChar class 형식으로 담겨진 ArrayList
) : BaseAdapter() { // 기본 adapter기술을 상속받음

    //        listView에 어떻게 화면을 뿌려줄것인지 구현
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        반복시킬 내가만든 레이아웃
//        해당 context의 listView는 나는 이 레이아웃이 반복된것으로 바꿀꺼야
        val view : View = LayoutInflater.from(context).inflate(R.layout.list_game_char, null)

//        내가 만들었던 레이아웃에서 동적으로 값이 바뀌어야 할 부분들을 가져옴
        val img = view.findViewById<ImageView>(R.id.iv_img) // ImageView타입의 이미지
        val groupClass = view.findViewById<TextView>(R.id.tv_groupClass) // TextView타입의 메인클래스
        val detailClass = view.findViewById<TextView>(R.id.tv_detailClass) // TextView타입의 디테일클래스

//        반복해서 레이아웃을 만들어 낼 때, 순서에 맞는 생성된 class들을 불러옴
        val charClass = CharList[position] // 반복순회할 때 index

//        내가 만들었던 레이아웃에 값을 동적으로 지정해줌
        Glide.with(context).load(charClass.img).into(img)
        groupClass.text = charClass.groupClass
        detailClass.text = charClass.detaliClass

//        완성된 하나의 레이아웃을 반환
        return view
    }

//    매 순간마다 어떤 클래스를 가져와서 사용할 것인지
    override fun getItem(position: Int): Any {
        return CharList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

//    총 몇개의 레이아웃(리스트)이 만들어졌는지
    override fun getCount(): Int {
        return CharList.size
    }

}