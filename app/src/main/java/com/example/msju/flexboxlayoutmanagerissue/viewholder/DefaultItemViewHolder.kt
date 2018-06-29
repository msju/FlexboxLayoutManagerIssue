package com.example.msju.flexboxlayoutmanagerissue.viewholder

import android.view.ViewGroup
import com.example.msju.flexboxlayoutmanagerissue.ItemData
import com.example.msju.flexboxlayoutmanagerissue.R
import kotlinx.android.synthetic.main.rv_item_default_item.view.*


class DefaultItemViewHolder(parent: ViewGroup) : BaseViewHolder<ItemData>(parent, R.layout.rv_item_default_item) {

    val tvTabName = itemView.tvTabName

    override fun bind(position: Int, data: ItemData) {
        tvTabName.setText(data.displayName)
    }
}