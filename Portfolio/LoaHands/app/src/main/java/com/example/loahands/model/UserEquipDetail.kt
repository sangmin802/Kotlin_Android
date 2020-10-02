package com.example.loahands.model

import android.util.Log
import org.json.JSONObject
import org.jsoup.Jsoup

data class UserEquipDetail(
    val itemWrap : Any
){
    var itemName : String? = null
    var itemImg : String? = null
    init {
        if(itemWrap is JSONObject){
            itemName = Jsoup.parse(itemWrap.getJSONObject("Element_000").getString("value")).text()
            itemImg = itemWrap.getJSONObject("Element_001").getJSONObject("value").getJSONObject("slotData").getString("iconPath")
        }
    }
}