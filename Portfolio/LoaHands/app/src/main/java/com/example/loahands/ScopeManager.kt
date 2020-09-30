package com.example.loahands

import android.util.Log
import kotlinx.coroutines.*
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class ScopeManager {
    private val mainScope = CoroutineScope(Dispatchers.Default)
    fun destroy(){
        mainScope.cancel()
    }
    suspend fun HttpRequest(_val : String) : JSONObject {
        var userEquipArr = arrayListOf<Any>()
        return mainScope.async {
            val httpResult = getHttp(_val)
            val scripts = httpResult.select("script")
            val userInfo = scripts[0].toString().replace("<script type=\"text/javascript\">", "").replace("</script>", "").replace("\$.Profile = {", "{").replace("};", "}").trim()
            val userEquip = JSONObject(userInfo).getJSONObject("Equip")
            val userEquipKeys = JSONObject(userInfo).getJSONObject("Equip").keys().iterator()
            for(key in userEquipKeys){
                userEquipArr.add(userEquip[key])
            }
            userEquip
        }.await()
    }

    suspend fun getHttp(_val : String) : Element = runBlocking {
        val result = async {
            (Jsoup.connect("https://lostark.game.onstove.com/Profile/Character/${_val}").get()).body()
        }.await()
        result
    }
}