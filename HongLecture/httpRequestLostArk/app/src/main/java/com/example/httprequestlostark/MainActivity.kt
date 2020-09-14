package com.example.httprequestlostark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jsoup.Jsoup
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//    HTTP Reauest
//    HTML parser인 Jsoup을 받아야함
//    안드로이드는 진짜 완전 쌩 영어만 되나봄
//    따라서 한글로된 query는 아래의 방법으로 인코딩해줘야함
//    https://cors-anywhere.herokuapp.com
//    println((URL("https://lostark.game.onstove.com/Profile/Character/${URLEncoder.encode("모여요꿈동산", "UTF-8")}").readText()))
        val scripts = (Jsoup.connect("https://m-lostark.game.onstove.com/Profile/Character/${URLEncoder.encode("워로드는뒤로점프", "UTF-8")}").get()).body().select("script")
        for((index, element : org.jsoup.nodes.Element) in scripts.withIndex()) {
            if(index===0){
                val target = element.childNode(0).toString().replace("\$.Profile = {", "{").replace("};", "}").trim()
//            println(target)
            }

        }


//    MainActivity 처럼 실제 구동 파일에서만 작동!
//        받아온 string형식의 json파일을 JSONObject를 통해 사용할 수 있는 json으로 만든다.
//        단, 해당 기능은 함수임의구동이 아닌 실제 앱 실행을 통해서만 볼 수 있다.
//        val lol = "{\"summoner\":{\"name\":\"모여요꿈동산\",\"level\":55,\"profileImageUrl\":\"https://opgg-static.akamaized.net/images/profile_icons/profileIcon1625.jpg\",\"profileBorderImageUrl\":\"https://opgg-static.akamaized.net/images/borders2/challenger.png\",\"url\":\"https://www.op.gg/summoner/userName=모여요꿈동산\",\"leagues\":[{\"hasResults\":true,\"wins\":102,\"losses\":29,\"tierRank\":{\"name\":\"솔랭\",\"tier\":\"Challenger\",\"tierDivision\":\"Challenger\",\"string\":\"Challenger (62LP)\",\"shortString\":\"C1\",\"division\":\"i\",\"imageUrl\":\"https://opgg-static.akamaized.net/images/medals/challenger_1.png\",\"lp\":62,\"tierRankPoint\":176}},{\"hasResults\":true,\"wins\":310,\"losses\":856,\"tierRank\":{\"name\":\"자유 5:5 랭크\",\"tier\":\"Platinum\",\"tierDivision\":\"Platinum\",\"string\":\"Platinum (248LP)\",\"shortString\":\"P1\",\"division\":\"i\",\"imageUrl\":\"https://opgg-static.akamaized.net/images/medals/platinum_1.png\",\"lp\":248,\"tierRankPoint\":237}}],\"previousTiers\":[{\"name\":\"솔랭\",\"tier\":\"Diamond\",\"tierDivision\":\"Diamond\",\"string\":\"Diamond (797LP)\",\"shortString\":\"D1\",\"division\":\"i\",\"imageUrl\":\"https://opgg-static.akamaized.net/images/medals/diamond_1.png\",\"lp\":797,\"tierRankPoint\":354,\"season\":9}],\"ladderRank\":{\"rank\":974235,\"rankPercentOfTop\":25},\"profileBackgroundImageUrl\":\"http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Taliyah_0.jpg\"}}"
//        Log.i("결과값", "${JSONObject(lol).getJSONObject("summoner").get("name")}")
//        val loa = "{\n" +
//                "  \"Equip\": {\n" +
//                "    \"Ee4170f6_000\": {\n" +
//                "      \"Element_000\": {\n" +
//                "        \"type\": \"NameTagBox\",\n" +
//                "        \"value\": \"<P ALIGN='CENTER'><FONT COLOR='#FA5D00'>+15 운명의 날 리아네 하프</FONT></P>\"\n" +
//                "      }\n" +
//                "    }\n" +
//                "  }\n" +
//                "}"

//          Jsoup을 통해 문자열 내에 있는 태그들을 지울 수 있다.
//        Log.i("결과값", "${Jsoup.parse(JSONObject(loa).getJSONObject("Equip").getJSONObject("Ee4170f6_000").getJSONObject("Element_000").get("value").toString()).text()}")
    }
}