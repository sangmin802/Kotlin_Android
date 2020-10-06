package com.example.loahands.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.loahands.R
import com.example.loahands.model.UserEquipDetail

class EquipDetailAdapter(val equipList : ArrayList<UserEquipDetail?>, val imgBaseUrl : String, val frag : Fragment) : RecyclerView.Adapter<EquipDetailAdapter.CustomViewHolder>() {
    var imgCount : Int = 0
    var imgPos : String = "left"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipDetailAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemdetail, parent, false)

        return CustomViewHolder(view, parent)
    }

    override fun getItemCount(): Int {
        return equipList.size
    }

    override fun onBindViewHolder(holder: EquipDetailAdapter.CustomViewHolder, position: Int) {
        val target = holder._parent
        holder.equipDetailType.setImageResource(frag.resources.getIdentifier("${imgPos+0+imgCount}", "drawable", frag.activity?.packageName))
        if(equipList.get(position) != null){
            Glide.with(target).load("${imgBaseUrl+equipList.get(position)?.itemImg}").into(holder.equipImg)
            holder.equipName.text = equipList.get(position)?.itemName
            holder.equipParts.text = equipList.get(position)?.itemParts
            holder.equipImg.background = frag.resources.getDrawable(frag.resources.getIdentifier("gradient${equipList.get(position)?.itemGrade}", "drawable", frag.activity?.packageName), null)
        }
        imgCount++
        if(imgPos === "left"){
            if(imgCount > 5) {
                imgPos = "right"
                imgCount = 0
            }
        }
    }

    class CustomViewHolder(_view : View, val _parent : ViewGroup) : RecyclerView.ViewHolder(_view) {
        val equipDetailType = _view.findViewById<ImageView>(R.id.iv_equipDetailType)
        val equipImg = _view.findViewById<ImageView>(R.id.iv_equipDetailImg)
        val equipParts = _view.findViewById<TextView>(R.id.tv_equipDetailParts)
        val equipName = _view.findViewById<TextView>(R.id.tv_eqipDetailName)
    }
}