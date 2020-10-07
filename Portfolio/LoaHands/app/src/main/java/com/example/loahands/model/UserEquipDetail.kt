package com.example.loahands.model

import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

data class UserEquipDetail(
    val itemWrap : Any,
    val type : String
){
    var itemName : String? = null
    var itemImg : String? = null
    var itemType : String? = null
    var itemGrade : Int = 0
    var itemParts : String? = null
    var itemTargetClass : String? = null
    var itemStat : String? = null
    var itemExtraStat : String? = null
    init {
        if(itemWrap is JSONObject){
            val Element1 = itemWrap.getJSONObject("Element_001")
            var dynamicEl1 : String = "Element_004"
            var dynamicEl2 : String = "Element_005"
            if(type === "stone"){
                dynamicEl1 = "Element_003"
                dynamicEl2 = "Element_004"
            }
            itemType = type
            itemName = getOnlyText(itemWrap.getJSONObject("Element_000").getString("value"))
            itemTargetClass = getOnlyText(itemWrap.getJSONObject("Element_002").getString("value"))
            itemStat = getOnlyText(itemWrap.getJSONObject(dynamicEl1).getJSONObject("value").getString("Element_001"))
            itemExtraStat = getOnlyText(itemWrap.getJSONObject(dynamicEl2).getJSONObject("value").getString("Element_001"))
            itemImg = Element1.getJSONObject("value").getJSONObject("slotData").getString("iconPath")
            itemGrade = Element1.getJSONObject("value").getJSONObject("slotData").getInt("iconGrade")
            itemParts = getOnlyText(Element1.getJSONObject("value").getString("leftStr0"))
        }
    }

    fun getOnlyText(str : String) : String {
        return Jsoup.parse(str).text()
    }
}