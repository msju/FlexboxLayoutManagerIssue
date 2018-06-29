package com.example.msju.flexboxlayoutmanagerissue

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.google.android.flexbox.FlexboxLayoutManager

class SimpleItemTouchHelperCallback(var adapter: ItemTouchHelperAdapter) : ItemTouchHelper.Callback() {


    val TAG = "Debug"

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {

        recyclerView.layoutManager?.apply {
            when {
                this is FlexboxLayoutManager -> {
                    return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
                            ItemTouchHelper.START or ItemTouchHelper.END or ItemTouchHelper.UP or ItemTouchHelper.DOWN)
                }
                this is GridLayoutManager -> return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
                        ItemTouchHelper.START or ItemTouchHelper.END or ItemTouchHelper.UP or ItemTouchHelper.DOWN)
                this is LinearLayoutManager -> when ((recyclerView.layoutManager as LinearLayoutManager).orientation) {
                    LinearLayoutManager.VERTICAL -> {
                        return makeMovementFlags(ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                                ItemTouchHelper.START or ItemTouchHelper.END)
                    }
                    else -> makeMovementFlags(ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
                            ItemTouchHelper.START or ItemTouchHelper.END)
                }
                else -> return makeMovementFlags(ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.START or ItemTouchHelper.END)
            }
        }
        return makeMovementFlags(ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                ItemTouchHelper.START or ItemTouchHelper.END)
    }

    override fun onMove(recyclerView: RecyclerView, source: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        if (source.itemViewType != target.itemViewType) {
            return false
        }
        adapter.onItemMove(source.adapterPosition, target.adapterPosition)

        return true
    }

    override fun onMoved(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, fromPos: Int, target: RecyclerView.ViewHolder, toPos: Int, x: Int, y: Int) {
        super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y)
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        when (actionState) {
            ItemTouchHelper.ACTION_STATE_IDLE -> viewHolder?.itemView?.alpha = 1.0f
            ItemTouchHelper.ACTION_STATE_DRAG -> viewHolder?.itemView?.alpha = 0.5f
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        viewHolder?.itemView?.alpha = 1.0f

    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return false
    }

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }


}