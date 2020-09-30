package com.example.loahands.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.loahands.R
import com.example.loahands.ScopeManager
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URLEncoder

class MainFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.beginTransaction().replace(R.id.frame_changingFrame, WelcomeFragment.newInstance()).commit()

        btn_search.setOnClickListener {
            searchClickEvent()
        }
    }

    fun searchClickEvent(){
        val editTextVal = URLEncoder.encode("${et_value.text}", "UTF-8")
        CoroutineScope(Dispatchers.IO).launch {
            getUserData(editTextVal)
        }
    }

    suspend fun getUserData(editTextVal: String) {
        val scopeManager = ScopeManager()
        val userData = scopeManager.HttpRequest(editTextVal)
        parentFragmentManager.beginTransaction().replace(R.id.frame_changingFrame, UserInfoFragment.newInstance(userData.toString())).commit()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}