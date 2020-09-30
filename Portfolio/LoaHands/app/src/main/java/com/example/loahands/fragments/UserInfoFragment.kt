package com.example.loahands.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loahands.R
import org.json.JSONObject

class UserInfoFragment : Fragment() {
    private var userData : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userData = it.getString("userData")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("유저정보", "${JSONObject(userData)}")
    }

    companion object {
        @JvmStatic
        fun newInstance(userData : String) =
            UserInfoFragment().apply {
                arguments = Bundle().apply {
                    putString("userData", userData)
                }
            }
    }
}