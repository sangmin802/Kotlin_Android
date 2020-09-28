package com.example.loahands.fragments

import android.os.Bundle
import android.os.Handler
import android.sax.Element
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loahands.R
import com.example.loahands.ScopeManager
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import java.net.URLEncoder
import org.json.JSONObject
import org.w3c.dom.Text
import java.security.Key
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class SearchFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_search.setOnClickListener {
            val scopeManager = ScopeManager()
            val editTextVal = URLEncoder.encode("${et_value.text}", "UTF-8")
            scopeManager.HttpRequest(editTextVal)
//                val scripts = httpResult.select("script")
//                val userInfo = scripts[0].toString().replace("<script type=\"text/javascript\">", "").replace("</script>", "").replace("\$.Profile = {", "{").replace("};", "}").trim()
//                val userInfoKeys = JSONObject(userInfo).getJSONObject("Skill").keys().iterator()
//                scopeManager.destroy()
//
//                for(key in userInfoKeys){
//                    Log.i("아이템", "${JSONObject(userInfo).getJSONObject("Skill").getJSONObject(key)}")
//                }
//                Log.i("코루틴", "실행중 ${Thread.currentThread().name}")
//            GlobalScope.launch {
////                콜백방식으로 해봄
////                getHttpRequest(editTextVal) {
////                    val scripts = it.select("script")
////                    val userInfo = scripts[0].toString().replace("<script type=\"text/javascript\">", "").replace("</script>", "").replace("\$.Profile = {", "{").replace("};", "}").trim()
////                    val userInfoKeys = JSONObject(userInfo).getJSONObject("Skill").keys().iterator()
////                    for(key in userInfoKeys){
////                        Log.i("아이템", "${JSONObject(userInfo).getJSONObject("Skill").getJSONObject(key)}")
////                    }
////                }
//
//
////                다 가져오질 못하고있음. 비동기인 코루틴 학습 필요
//                val getHttp = async {
//                    (Jsoup.connect("https://lostark.game.onstove.com/Profile/Character/${editTextVal}").get()).body()
//                }.await()
//                val scripts = getHttp.select("script")
//                val userInfo = scripts[0].toString().replace("<script type=\"text/javascript\">", "").replace("</script>", "").replace("\$.Profile = {", "{").replace("};", "}").trim()
////                로그캣에 전부 노출되진않는데, 갯수는 맞는거보니 그냥 너무길어서 자르나봄
////                Log.i("바로 아이템", "${JSONObject(userInfo).getJSONObject("Skill").length()}")
////                Log.i("바로 아이템", "${JSONObject(userInfo).getJSONObject("Skill").keys()}")
//                val userInfoKeys = JSONObject(userInfo).getJSONObject("Skill").keys().iterator()
////                현재 보니깐, key값이 랜덤으로 계속바뀌어서 키값을 추출하고 순회토록 함
//                for(key in userInfoKeys){
//                    Log.i("아이템", "${JSONObject(userInfo).getJSONObject("Skill").getJSONObject(key)}")
//                }
//            }
        }
    }


//    콜백방식용
//    fun getHttpRequest(_editTextVal : String, callback : ((org.jsoup.nodes.Element) -> Unit)){
//        val getHttp = (Jsoup.connect("https://lostark.game.onstove.com/Profile/Character/${_editTextVal}").get()).body()
//        callback(getHttp)
//    }
    companion object {
        fun newInstance() =
            SearchFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}

