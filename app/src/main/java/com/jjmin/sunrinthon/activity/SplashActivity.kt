package com.jjmin.sunrinthon.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jjmin.sunrinthon.R
import com.jjmin.sunrinthon.utils.SharedUtils

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()

        handler.postDelayed({
            Log.e("SharedUtils.gettoken()",SharedUtils.gettoken())
            if(SharedUtils.gettoken()!="") {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 2000)
    }
}
