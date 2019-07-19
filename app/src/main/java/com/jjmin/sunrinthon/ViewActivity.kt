package com.jjmin.sunrinthon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {
    var name = ""
    var content = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        name = Intent().getStringExtra("name")
        content = Intent().getStringExtra("contnet")

        viewTitle.text = name
        viewContent.text = content
    }

}
