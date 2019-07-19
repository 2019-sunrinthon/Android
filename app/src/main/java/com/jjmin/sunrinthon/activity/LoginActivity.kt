package com.jjmin.sunrinthon.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jjmin.sunrinthon.R
import com.jjmin.sunrinthon.SignupActivity
import com.jjmin.sunrinthon.data.NetworkModules
import com.jjmin.sunrinthon.data.model.LoginData
import com.jjmin.sunrinthon.kakao.SessionCallback

import com.jjmin.sunrinthon.utils.SharedUtils
import com.kakao.auth.Session
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import java.util.*

class LoginActivity : AppCompatActivity() {
    lateinit var callback: SessionCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        callback = SessionCallback()
        Session.getCurrentSession().addCallback(callback)
        Session.getCurrentSession().checkAndImplicitOpen()

        loginFinishBtn.onClick {
            var id = loginEmailEt.text.toString()
            var passwd = loginPasswdEt.text.toString()

            if(id.isNotEmpty() && passwd.isNotEmpty()) {
                loginrepository("local",id,passwd)
            }else{
                toast("모든 정보를 기입해 주세요")
            }
        }

        loginSignup.onClick {
            var intent = Intent(this@LoginActivity,SignupActivity::class.java)
            startActivity(intent)
        }
    }

    fun loginrepository(provider : String,id : String, passwd : String){
        NetworkModules.retrifit.Login(provider,id,passwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it.success) {

                    SharedUtils.savedata(it.email,it.username,it.token)

                    toast("${SharedUtils.getname()} 로그인 합니다.")
                    finishAffinity()
                    startActivity(Intent(this,MainActivity::class.java))
                }else{

                }
            }) {
                Log.e("loginError", it.message!!)

                if(it.message?.contains("403")!!){
                    toast("로그인이나 비밀번호가 옳바르기 않습니다.")
                }else {
                    toast("서버가 점검중입니다.")
                }
            }
    }

}
