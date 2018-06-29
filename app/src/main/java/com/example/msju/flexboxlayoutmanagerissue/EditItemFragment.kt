package com.example.msju.flexboxlayoutmanagerissue

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.fragment_edit_item.*

class EditItemFragment : Fragment() , OnStartDragListener {

    lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvItemEdit?.apply {
            var list = mutableListOf<ItemData>()
            list.add(ItemData(ItemData.Type.DEFAULT, "Item 1"))
            list.add(ItemData(ItemData.Type.DEFAULT, "Item 2"))
            list.add(ItemData(ItemData.Type.DEFAULT, "Item 3"))
            list.add(ItemData(ItemData.Type.DEFAULT, "Item 4"))
            list.add(ItemData(ItemData.Type.DEFAULT, "Item 5"))
            list.add(ItemData(ItemData.Type.DEFAULT, "Item 6"))

            val flexLayoutManager = FlexboxLayoutManager(context)
            flexLayoutManager.apply {
                flexWrap = FlexWrap.WRAP
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.FLEX_START
            }

            layoutManager = flexLayoutManager

            adapter = EditItemRcyclerViewAdapter(list, this@EditItemFragment)

            val callback = SimpleItemTouchHelperCallback(adapter as EditItemRcyclerViewAdapter)
            itemTouchHelper = ItemTouchHelper(callback)
            itemTouchHelper.attachToRecyclerView(this)
        }
    }

    override fun onStartDrag(holder: RecyclerView.ViewHolder): Boolean {
        itemTouchHelper?.startDrag(holder)
        return true
    }
}