package com.example.loahands.fragments

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.loahands.R
import com.example.loahands.ScopeManager
import com.example.loahands.model.SendingData
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


        Glide.with(this).load("${imgBaseUrl+head?.itemImg}").into(iv_head)
        Glide.with(this).load("${imgBaseUrl+shoulder?.itemImg}").into(iv_shoulder)
        Glide.with(this).load("${imgBaseUrl+cloth?.itemImg}").into(iv_cloth)
        Glide.with(this).load("${imgBaseUrl+pants?.itemImg}").into(iv_pants)
        Glide.with(this).load("${imgBaseUrl+glove?.itemImg}").into(iv_glove)
        Glide.with(this).load("${imgBaseUrl+weapon?.itemImg}").into(iv_weapon)
        Glide.with(this).load("${imgBaseUrl+necklace?.itemImg}").into(iv_necklace)
        Glide.with(this).load("${imgBaseUrl+earing1?.itemImg}").into(iv_earing1)
        Glide.with(this).load("${imgBaseUrl+earing2?.itemImg}").into(iv_earing2)
        Glide.with(this).load("${imgBaseUrl+ring1?.itemImg}").into(iv_ring1)
        Glide.with(this).load("${imgBaseUrl+ring2?.itemImg}").into(iv_ring2)
        Glide.with(this).load("${imgBaseUrl+stone?.itemImg}").into(iv_stone)
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