package com.example.msju.flexboxlayoutmanagerissue

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.msju.flexboxlayoutmanagerissue.viewholder.DefaultItemViewHolder

class EditItemRcyclerViewAdapter(var data: MutableList<ItemData>, var dragListener: OnStartDragListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter {

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        when (p0) {
            is DefaultItemViewHolder -> {
                p0.itemView.setOnLongClickListener {
                    dragListener.onStartDrag(p0)
                }
                p0.bind(p1, data[p1])
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        when (p1) {
            ItemData.Type.DEFAULT.ordinal -> return DefaultItemViewHolder(p0)
            else -> return DefaultItemViewHolder(p0)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].type.ordinal
    }

    override fun onItemMove(fromPos: Int, toPos: Int): Boolean {
        if (fromPos == toPos) {
            return false
        }
        data.swap(fromPos, toPos)
        notifyItemMoved(fromPos, toPos)
        return true
    }


    fun MutableList<ItemData>.swap(index1: Int, index2: Int) {
        val tmp = this[index1] // 'this' corresponds to the list
        this[index1] = this[index2]
        this[index2] = tmp
    }
}