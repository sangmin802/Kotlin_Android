package com.example.loahands.model

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class CustomLinearLayoutManager(_context : Context?) : LinearLayoutManager(_context, LinearLayoutManager.VERTICAL, false) {
    override fun canScrollVertically(): Boolean {
        return false
    }
}