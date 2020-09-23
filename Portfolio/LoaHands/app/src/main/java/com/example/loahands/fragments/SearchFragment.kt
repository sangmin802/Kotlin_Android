package com.example.loahands.fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loahands.R
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.net.URLEncoder
import org.json.JSONObject
import java.util.*
import kotlin.concurrent.schedule

class SearchFragment : Fragment() {
    val scope = CoroutineScope(Dispatchers.Main)
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
            val editTextVal = URLEncoder.encode("${et_value.text}", "UTF-8")
            scope.launch(Dispatchers.Default) {
                val getHttp = (Jsoup.connect("https://lostark.game.onstove.com/Profile/Character/${editTextVal}").get()).body()
                val scripts = getHttp.select("script")

//                다 가져오질 못하고있음. 비동기인 코루틴 학습 필요
                Timer().schedule(3000) {
                    Log.i("3초뒤 아이템", "${scripts[0]}")
                }
                Log.i("바로 아이템", "${scripts[0]}")


//                for((index, element : org.jsoup.nodes.Element) in scripts.withIndex()) {
//                    if(index===0){
//
//                        val target = element.toString().replace("\$.Profile = {", "{").replace("};", "}").trim()
//                        val userInfoJson = JSONObject(target)
//                        Log.i("아이템제이슨", "${userInfoJson}")
//                    }
//                }
            }
        }
    }

    companion object {
        fun newInstance() =
            SearchFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}