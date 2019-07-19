package com.jjmin.sunrinthon.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jjmin.sunrinthon.*



import com.jjmin.sunrinthon.data.model.LoginData
import com.jjmin.sunrinthon.utils.SharedUtils
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onLongClick






class MainActivity : AppCompatActivity() {

    // 4개의 메뉴에 들어갈 Fragment들
    lateinit var fragmentManager: FragmentManager
    private var fragment = Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeBtn.bringToFront()

        homeBtn.onClick {
            fragment = HomeFragment.newInstance()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout,fragment).commit()
        }

        init()

        mainBtn.onLongClick{

            userDelete()

            return@onLongClick
        }
    }

    fun init(){
        fragmentManager = supportFragmentManager
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fragment = HomeFragment.newInstance()
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment).commit()
    }

    fun userDelete() {
        SharedUtils.delete()
        finish()
    }

    val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_key -> {
                    fragment = KeyFargment()
                }
                R.id.navigation_communication -> {
                    fragment = ComunicationFragment.newInstance()
                }
                R.id.navigation_profile -> {
                    fragment = ProfileFragment.newInstance()
                }
                R.id.navigation_setting ->{
                    fragment = SettingFragment.newInstance()
                }
            }
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment).commit()
            true
        }
}
