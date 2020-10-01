package com.example.loahands.fragments

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loahands.R
import com.example.loahands.ScopeManager
import com.example.loahands.model.SendingData
import kotlinx.coroutines.*
import org.json.JSONObject

class UserInfoFragment : Fragment() {
    var userData : SendingData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userData = it.getParcelable("userData")
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

        Log.i("결과값", "${userData?.userEquip?.stone}")
        Log.i("결과값", "${userData?.userInfo?.userName}")
    }

    companion object {
        @JvmStatic
        fun newInstance(userData : SendingData) =
            UserInfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("userData", userData)
                }
            }
    }
}