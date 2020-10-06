package com.example.loahands.fragments

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.loahands.R
import com.example.loahands.ScopeManager
import com.example.loahands.adapters.EquipDetailAdapter
import com.example.loahands.adapters.EquipImgAdapter
import com.example.loahands.model.*
import com.example.loahands.model.UserEquip
import kotlinx.android.synthetic.main.fragment_user_info.*
import kotlinx.coroutines.*
import org.json.JSONObject

class UserInfoFragment : Fragment() {
    var userData : SendingData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userData = it.getParcelable("userData")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgBaseUrl = "http://cdn-lostark.game.onstove.com/"
        val _userEquip = userData?.userEquip
        val _userInfo = userData?.userInfo

        setEquip(imgBaseUrl, _userEquip)
        setUserInfo(imgBaseUrl, _userInfo)
    }

    fun setUserInfo(imgBaseUrl : String, _userInfo : UserInfo?){
        tv_expeditionLv.text = _userInfo?.expeditionLv
        tv_charLv.text = _userInfo?.Lv
        tv_className.text = _userInfo?.className
        tv_itemLv.text = _userInfo?.itemLv
        tv_totalItemLv.text = _userInfo?.reachItemLv
        tv_userName.text = _userInfo?.userName
        Glide.with(this).load("${"http:"+_userInfo?.classLogoImg}").into(iv_classLogo)
        Glide.with(this).load("${"http:"+_userInfo?.classImg}").into(iv_classImg)
    }

    fun setEquip(imgBaseUrl : String, _userEquip : UserEquip?){
        val head = _userEquip?.head
        val shoulder = _userEquip?.shoulder
        val cloth = _userEquip?.cloth
        val pants = _userEquip?.pants
        val glove = _userEquip?.glove
        val weapon = _userEquip?.weapon
        val necklace = _userEquip?.necklace
        val earing1 = _userEquip?.earing1
        val earing2 = _userEquip?.earing2
        val ring1 = _userEquip?.ring1
        val ring2 = _userEquip?.ring2
        var stone = _userEquip?.stone
        var blank = _userEquip?.blank
        val leftList = arrayListOf(head, shoulder, cloth, pants, glove, weapon)
        val rightList = arrayListOf(necklace, earing1, earing2, ring1, ring2, stone, blank)
        val detailList = arrayListOf(weapon, head, shoulder, cloth, pants, glove, necklace, earing1, earing2, ring1, ring2, stone)

        rv_leftEquipImg.layoutManager = CustomLinearLayoutManager(context)
        rv_rightEquipImg.layoutManager = CustomLinearLayoutManager(context)
        rv_userEquipDetail.layoutManager = CustomLinearLayoutManager(context)
        rv_leftEquipImg.adapter = EquipImgAdapter(leftList, imgBaseUrl, this, "left")
        rv_rightEquipImg.adapter = EquipImgAdapter(rightList, imgBaseUrl, this, "right")
        rv_userEquipDetail.adapter = EquipDetailAdapter(detailList, imgBaseUrl, this)
    }

    companion object {
        @JvmStatic
        fun newInstance(userData : SendingData) =
            UserInfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("userData", userData)
                }
            }
    }
}