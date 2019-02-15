package com.example.cartapp

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun verticalLayoutManager(context: Context, reverseLayout: Boolean = false): RecyclerView.LayoutManager {
    return LinearLayoutManager(context, RecyclerView.VERTICAL, reverseLayout)
}

fun horizontalLayoutManager(context: Context, reverseLayout: Boolean = false): RecyclerView.LayoutManager {
    return LinearLayoutManager(context, RecyclerView.HORIZONTAL, reverseLayout)
}