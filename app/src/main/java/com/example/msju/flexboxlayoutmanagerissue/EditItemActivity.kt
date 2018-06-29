package com.example.msju.flexboxlayoutmanagerissue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class EditItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_item)
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, EditItemFragment(), EditItemFragment::javaClass.name).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}