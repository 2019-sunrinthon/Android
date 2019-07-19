package com.jjmin.sunrinthon

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_memo.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class AddMemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_memo)

        var a = memoTitle.text.toString()
        var b = memoContent.text.toString()


        memoBtn.onClick {
            var intent = Intent()
            intent.putExtra("name",a)
            intent.putExtra("content",b)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
