package com.example.loahands

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.loahands.model.UserEquipDetail

class EquipDialog(val context: Context) {
    val dlg = Dialog(context)
    lateinit var dlgEquipImg : ImageView
    lateinit var dlgEquipName : TextView
    lateinit var dlgEquipTargetClass : TextView
    lateinit var dlgEquipStat : TextView
    lateinit var dlgEquipExtraStat : TextView

    fun start(_equipData : UserEquipDetail, imgBaseUrl : String, frag : Fragment) {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(R.layout.equipdialog)
        dlg.setCancelable(true)

        dlgEquipImg = dlg.findViewById(R.id.iv_diaEquipImg)
        dlgEquipName = dlg.findViewById(R.id.tv_diaEquipName)
        dlgEquipTargetClass = dlg.findViewById(R.id.tv_diaTargetClass)
        dlgEquipStat = dlg.findViewById(R.id.tv_diaEquipStat)
        dlgEquipExtraStat = dlg.findViewById(R.id.tv_diaEquipExtraStat)

        Glide.with(context).load(imgBaseUrl+_equipData.itemImg).into(dlgEquipImg)
        dlgEquipImg.background = frag.resources.getDrawable(frag.resources.getIdentifier("gradient${_equipData.itemGrade}", "drawable", frag.activity?.packageName), null)
        dlgEquipName.text = _equipData.itemName
        dlgEquipTargetClass.text = _equipData.itemTargetClass
        dlgEquipStat.text = _equipData.itemStat
        dlgEquipExtraStat.text = _equipData.itemExtraStat

        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dlg.window?.setLayout(width, height)
        dlg.window?.setBackgroundDrawableResource(R.color.transparent);

        dlg.show()
    }
}