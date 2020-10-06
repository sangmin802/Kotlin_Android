package com.example.loahands.model

import org.json.JSONObject
import org.jsoup.Jsoup

data class UserEquipDetail(
    val itemWrap : Any,
    val type : String
){
    var itemName : String? = null
    var itemImg : String? = null
    var itemType : String? = null
    var itemGrade : Int = 0
    var itemParts : String? = null
    init {
        if(itemWrap is JSONObject){
            val Element1 = itemWrap.getJSONObject("Element_001")
            itemType = type
            itemName = Jsoup.parse(itemWrap.getJSONObject("Element_000").getString("value")).text()
            itemImg = Element1.getJSONObject("value").getJSONObject("slotData").getString("iconPath")
            itemGrade = Element1.getJSONObject("value").getJSONObject("slotData").getInt("iconGrade")
            itemParts = Jsoup.parse(Element1.getJSONObject("value").getString("leftStr0")).text()
        }
    }
}