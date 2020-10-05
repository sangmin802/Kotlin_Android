package com.example.loahands.adapters

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.loahands.R
import com.example.loahands.model.UserEquipDetail

class EquipImgAdapter(private val equipList : ArrayList<UserEquipDetail?>, val imgBaseUrl : String, val frag : Fragment, val imgPos : String) : RecyclerView.Adapter<EquipImgAdapter.CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipImgAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemimg, parent, false)

        return CustomViewHolder(view, parent)
    }

    override fun getItemCount(): Int {
        return equipList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val target = holder._parent
        holder.equipTypeImg.setImageResource(frag.resources.getIdentifier("${imgPos+0+position}", "drawable", frag.activity?.packageName))

        if(equipList.get(position) != null){
            Glide.with(target).load("${imgBaseUrl+equipList.get(position)?.itemImg}").into(holder.equipImg)
            holder.equipImg.background = frag.resources.getDrawable(frag.resources.getIdentifier("gradient${equipList.get(position)?.itemGrade}", "drawable", frag.activity?.packageName), null)
        }
    }

    class CustomViewHolder(_view : View, val _parent : ViewGroup) : RecyclerView.ViewHolder(_view) {
        val equipTypeImg = _view.findViewById<ImageView>(R.id.iv_equipTypeImg)
        val equipImg = _view.findViewById<ImageView>(R.id.iv_equipImg)
    }
}