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
    fun HttpRequest(_val : String) {
        var userEquipArr = arrayListOf<Any>()
        mainScope.launch {
            val httpResult = getHttp(_val)
            val scripts = httpResult.select("script")
            val userInfo = scripts[0].toString().replace("<script type=\"text/javascript\">", "").replace("</script>", "").replace("\$.Profile = {", "{").replace("};", "}").trim()
            val userEquip = JSONObject(userInfo).getJSONObject("Equip")
            val userEquipKeys = JSONObject(userInfo).getJSONObject("Equip").keys().iterator()
            for(key in userEquipKeys){
                userEquipArr.add(userEquip[key])
            }
            Log.i("결과값", "${JSONObject(userEquipArr[19].toString()).getJSONObject("Element_006")}")
        }
    }

    suspend fun getHttp(_val : String) : Element = runBlocking {
        val result = async {
            (Jsoup.connect("https://lostark.game.onstove.com/Profile/Character/${_val}").get()).body()
        }.await()
        result
    }
}