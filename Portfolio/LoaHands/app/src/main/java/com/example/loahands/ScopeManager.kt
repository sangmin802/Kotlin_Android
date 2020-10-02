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

    fun getUserEquip(httpResult : Element) : UserEquip {
        val scripts = httpResult.select("script")
        var userEquipClass = UserEquip()
        val userInfo = scripts[0].toString().replace("<script type=\"text/javascript\">", "").replace("</script>", "").replace("\$.Profile = {", "{").replace("};", "}").trim()
        val userEquip = JSONObject(userInfo).getJSONObject("Equip")
        val userEquipKeys = JSONObject(userInfo).getJSONObject("Equip").keys().iterator()
        for(key in userEquipKeys){
            when(key.takeLast(3)) {
                "000" -> {userEquipClass.weapon = UserEquipDetail(userEquip[key])}
                "001" -> {userEquipClass.head = UserEquipDetail(userEquip[key])}
                "002" -> {userEquipClass.cloth = UserEquipDetail(userEquip[key])}
                "003" -> {userEquipClass.pants = UserEquipDetail(userEquip[key])}
                "004" -> {userEquipClass.glove = UserEquipDetail(userEquip[key])}
                "005" -> {userEquipClass.shoulder = UserEquipDetail(userEquip[key])}
                "006" -> {userEquipClass.necklace = UserEquipDetail(userEquip[key])}
                "007" -> {userEquipClass.earing1 = UserEquipDetail(userEquip[key])}
                "008" -> {userEquipClass.earing2 = UserEquipDetail(userEquip[key])}
                "009" -> {userEquipClass.ring1 = UserEquipDetail(userEquip[key])}
                "010" -> {userEquipClass.ring2 = UserEquipDetail(userEquip[key])}
                "011" -> {userEquipClass.stone = UserEquipDetail(userEquip[key])}
            }
        }
        return userEquipClass
    }
    fun getUserInfo(httpResult: Element, _val : String) : UserInfo {
        val userName = _val
        val expeditionLv = httpResult.getElementsByClass("level-info__expedition").text()
        val Lv = httpResult.getElementsByClass("level-info__item").text()
        val itemLv = httpResult.getElementsByClass("level-info2__expedition").text()
        val reachItemLv = httpResult.getElementsByClass("level-info2__item").text()
        var userInfoClass = UserInfo().apply {
            this.userName = userName
            this.expeditionLv = expeditionLv
            this.Lv = Lv
            this.itemLv = itemLv
            this.reachItemLv = reachItemLv
        }
        return userInfoClass
    }

    suspend fun changeToJSON(_string1 : String, _string2 : String) : ArrayList<Any> {
        return mainScope.async {
            var array = arrayListOf<Any>(JSONObject(_string1), JSONObject(_string2))
            array
        }.await()
    }
}