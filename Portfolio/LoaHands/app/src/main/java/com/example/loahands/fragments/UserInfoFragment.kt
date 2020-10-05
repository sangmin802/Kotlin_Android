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
import com.example.loahands.adapters.EquipImgAdapter
import com.example.loahands.model.SendingData
import com.example.loahands.model.UserEquip
import com.example.loahands.model.UserEquipDetail
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

        setItemImg(imgBaseUrl, _userEquip)
    }

    fun setItemImg(imgBaseUrl : String, _userEquip : UserEquip?){
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

//        div_userEquipWrap.setBackgroundResource(resources.getIdentifier("bg_profile_equipment", "drawable", activity?.packageName))

        rv_leftEquipImg.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_rightEquipImg.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_leftEquipImg.adapter = EquipImgAdapter(leftList, imgBaseUrl, this, "left")
        rv_rightEquipImg.adapter = EquipImgAdapter(rightList, imgBaseUrl, this, "right")
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