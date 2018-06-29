package com.example.msju.flexboxlayoutmanagerissue

import android.support.v7.widget.RecyclerView

interface OnStartDragListener {
    fun onStartDrag(holder: RecyclerView.ViewHolder):Boolean
}