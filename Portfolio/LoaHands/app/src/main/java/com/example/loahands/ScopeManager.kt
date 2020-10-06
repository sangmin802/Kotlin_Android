package com.example.loahands

import android.util.Log
import com.example.loahands.model.SendingData
import com.example.loahands.model.UserEquip
import com.example.loahands.model.UserEquipDetail
import com.example.loahands.model.UserInfo
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.*
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.net.URLEncoder
import kotlin.collections.ArrayList

class ScopeManager {
    private val mainScope = CoroutineScope(Dispatchers.Default)
    fun destroy(){
        mainScope.cancel()
    }
    suspend fun HttpRequest(_val : String) : SendingData {
        val editTextVal = URLEncoder.encode("${_val}", "UTF-8")
        val httpResult = getHttp(editTextVal)

        return mainScope.async {
            val userEquipResult = getUserEquip(httpResult)
            val userInfoResult = getUserInfo(httpResult, _val)

            SendingData(userEquipResult, userInfoResult)
        }.await()
    }

    suspend fun getHttp(_val : String) : Element = runBlocking {
        val result = async {
            (Jsoup.connect("https://lostark.game.onstove.com/Profile/Character/${_val}").get()).body()
        }.await()
        result
    }

    fun getUserEquip(httpResult : Element) : UserEquip? {
        val scripts = httpResult.select("script")
        var userEquipClass = UserEquip()
        val removeScriptTag = scripts[0].toString().replace("<script type=\"text/javascript\">", "").replace("</script>", "").trim()
        if(removeScriptTag.length!==0){
            val userInfo = removeScriptTag.replace("\$.Profile = {", "{").replace("};", "}").trim()
            val userEquip = JSONObject(userInfo).getJSONObject("Equip")
            val userEquipKeys = JSONObject(userInfo).getJSONObject("Equip").keys().iterator()
            for(key in userEquipKeys){
                when(key.takeLast(3)) {
                    "000" -> {userEquipClass.weapon = UserEquipDetail(userEquip[key], "weapon")}
                    "001" -> {userEquipClass.head = UserEquipDetail(userEquip[key], "head")}
                    "002" -> {userEquipClass.cloth = UserEquipDetail(userEquip[key], "cloth")}
                    "003" -> {userEquipClass.pants = UserEquipDetail(userEquip[key], "pants")}
                    "004" -> {userEquipClass.glove = UserEquipDetail(userEquip[key], "glove")}
                    "005" -> {userEquipClass.shoulder = UserEquipDetail(userEquip[key], "shoulder")}
                    "006" -> {userEquipClass.necklace = UserEquipDetail(userEquip[key], "necklace")}
                    "007" -> {userEquipClass.earing1 = UserEquipDetail(userEquip[key], "earing1")}
                    "008" -> {userEquipClass.earing2 = UserEquipDetail(userEquip[key], "earing2")}
                    "009" -> {userEquipClass.ring1 = UserEquipDetail(userEquip[key], "ring1")}
                    "010" -> {userEquipClass.ring2 = UserEquipDetail(userEquip[key], "ring2")}
                    "011" -> {userEquipClass.stone = UserEquipDetail(userEquip[key], "stone")}
                }
            }
            return userEquipClass
        }else{
            return null
        }
    }
    fun getUserInfo(httpResult: Element, _val : String) : UserInfo {
        val userName = _val
        val expeditionLv = httpResult.getElementsByClass("level-info__expedition").text()
        val Lv = httpResult.getElementsByClass("level-info__item").text()
        val itemLv = httpResult.getElementsByClass("level-info2__expedition").text()
        val reachItemLv = httpResult.getElementsByClass("level-info2__item").text()
        val classInfo = httpResult.getElementsByClass("profile-character-info__img")
        val className = classInfo.attr("alt")
        val classLogoImg = classInfo.attr("src")
        val classImg = httpResult.getElementsByClass("profile-equipment__character")[0].children().attr("src")
        var userInfoClass = UserInfo().apply {
            this.userName = userName
            this.expeditionLv = expeditionLv
            this.Lv = Lv
            this.itemLv = itemLv
            this.reachItemLv = reachItemLv
            this.className = className
            this.classLogoImg = classLogoImg
            this.classImg = classImg
        }
        return userInfoClass
    }
}