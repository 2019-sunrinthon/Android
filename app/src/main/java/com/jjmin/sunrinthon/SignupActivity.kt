package com.jjmin.sunrinthon

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jjmin.sunrinthon.data.NetworkModules
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        signupButton.onClick {
            var name = registerNameEt.text.toString()
            var email = registerEmailEt.text.toString()
            var password = registerPasswordEt.text.toString()
            var phone = registerNumberEt.text.toString()

            if(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && phone.isNotEmpty()){
                signUp(name,password,email,phone)
            }else{
                toast("모든 정보를 기입해주세요")
            }
        }
    }

    fun signUp(name : String,password : String,email : String,phone : String){
        NetworkModules.retrifit.SignUp(name,password,name,email,phone,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    toast("회원가입이 정상적으로 완료되었습니다.")
                    finish()
                }){
                    Log.e("SignUpError",it.message)
                }
    }
}
