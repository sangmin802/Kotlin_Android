package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.game_class_list.view.*

class CustomAdapter : RecyclerView.Adapter<Holder>() {
//    MainActivity에서 만들어진 arrayList를 listData에 담음
    var listData = arrayListOf<GameCharClass>()

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : Holder {
//        viewType은 Grid일때 활성화되는듯
//        1. 완성된 레이아웃이 저장될 Activity 클래스에 비어있는 레이아웃을 담아 Holder클래스에 보내줌
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_class_list, parent, false)
        return Holder(view, parent)
    }

    override fun getItemCount() : Int {
//        동적인 데이터 리스트 수
        return listData.size
    }

    override fun onBindViewHolder(holder : Holder, position : Int){
//        2. Holder클래스에 정보를 빼올 하나의 리스트를 보내줌
        val data = listData.get(position)
        holder.setGameCharData(data)
    }
}

//  onCreateViewHolder에서 만든 하나의 레이아웃을 인자로 받음
class Holder(val oneGameClassList : View, val _parent : ViewGroup) : RecyclerView.ViewHolder(oneGameClassList) { // ViewHolder를 사용하기위해 Holder클래스에 상속
    fun setGameCharData(gameCharClass: GameCharClass) {
//        3. Activity에 저장된 비어있는 레이아웃에 알맞은 데이터들을 등록하여 완성된 레이아웃을 구성함
        Glide.with(_parent.context).load(gameCharClass.classImg).into(oneGameClassList.iv_classImg)
        oneGameClassList.tv_groupClass.text = gameCharClass.groupClass
        oneGameClassList.tv_detailClass.text = gameCharClass.detailClass
    }
}