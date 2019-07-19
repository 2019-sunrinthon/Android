package com.jjmin.sunrinthon.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.jjmin.sunrinthon.data.model.LoginData
import com.jjmin.sunrinthon.data.model.SignUpData
import io.realm.Realm
import org.jetbrains.anko.commit
import org.jetbrains.anko.toast

object SharedUtils {

    lateinit var Preferences: SharedPreferences
    lateinit var context: Context

    fun init(context: Context) {
        this.context = context
        Preferences = context.getSharedPreferences("user", MODE_PRIVATE)
    }


    fun savedata(email: String, name: String, token: String) {
        var editor = Preferences.edit()
        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("token", token)
        editor.commit()
    }

    fun getname(): String? {
        return Preferences.getString("name", "")
    }

    fun getemail(): String? {
        return Preferences.getString("email", "")
    }

    fun gettoken(): String? {
        return Preferences.getString("token", "")
    }

    fun delete() {
        var editor = Preferences.edit()
        editor.clear()
        editor.commit()
        context.toast("로그아웃합니다.")
    }
}