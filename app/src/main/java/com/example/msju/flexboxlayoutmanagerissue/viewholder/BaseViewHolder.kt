package com.example.msju.flexboxlayoutmanagerissue.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseViewHolder<T>(parent: ViewGroup, layoutId: Int) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false)) {

    abstract fun bind(position: Int, data: T)

}