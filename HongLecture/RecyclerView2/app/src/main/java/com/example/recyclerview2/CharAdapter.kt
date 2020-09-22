package com.example.recyclerview2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharAdapter(val charList : ArrayList<Char>) : RecyclerView.Adapter<CharAdapter.CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharAdapter.CustomViewHolder {
//        1번순서
//        Activity에서 onCreate, setContentView를 통해 xml을 연결하는것처럼
//        완성된 레이아웃이 들어가게될 Activity에 미리 만든 비어있는 레이아웃을 연결한다.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.char_list, parent, false)

//        클릭이벤트도 해당 class에 묶어서 보냄
        return CustomViewHolder(view, parent).apply {
            this.inflated_char_list.setOnClickListener {
                val curPos : Int = adapterPosition // 클릭 이벤트 실행시에만 제공되는 기능인듯함
                val charData : Char = charList.get(curPos)
                Toast.makeText(parent.context, "그룹 : ${charData.groupClass}\n직업 : ${charData.detailClass}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return charList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        3번순서
//        CustomViewHolder에게 상속받은 val 값들을 통해 배열의 데이터들을 연결함
        Glide.with(holder._parent).load(charList.get(position).profile).into(holder.profile)
        holder.groupClass.text = charList.get(position).groupClass
        holder.detailClass.text = charList.get(position).detailClass
    }

    class CustomViewHolder(val inflated_char_list : View, val _parent : ViewGroup) : RecyclerView.ViewHolder(inflated_char_list) {
//        2번순서
//        비어있는 레이아웃들에서 데이터가 들어가야할 태그들의 id를 호출
        val profile = inflated_char_list.findViewById<ImageView>(R.id.iv_prifile) // 이미지
        val groupClass = inflated_char_list.findViewById<TextView>(R.id.tv_groupClass) // 그룹클래스
        val detailClass = inflated_char_list.findViewById<TextView>(R.id.tv_detailClass) // 서브클래스스
   }
}